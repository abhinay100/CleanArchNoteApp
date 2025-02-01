package com.abhinay.cleanarchitecturenoteapp.feature_note.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.use_case.NoteUseCases
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.util.NoteOrder
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * [NotesViewModel] is a ViewModel responsible for managing the state and business logic
 * related to the list of notes. It handles user interactions, data fetching, and
 * updates the UI state accordingly.
 *
 * This ViewModel uses Hilt for dependency injection and leverages Kotlin Coroutines
 * for asynchronous operations.
 *
 * @property noteUseCases The use cases related to notes, providing access to
 *                         operations like getting, deleting, and adding notes.
 */
@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
) : ViewModel() {

    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state

    private var recentlyDeletedNote: Note? = null
    private var getNotesJob: Job? = null

    init {
        getNotes(NoteOrder.Date(OrderType.Descending))
    }


    fun onEvent(event: NotesEvent) {

        when (event) {
            is NotesEvent.Order -> {

                if (state.value.noteOrder::class.java == event.noteOrder::class.java &&
                    state.value.noteOrder.orderType == event.noteOrder.orderType
                ) {
                    return
                }
                getNotes(event.noteOrder)

            }

            is NotesEvent.DeleteNote -> {

                viewModelScope.launch {
                    noteUseCases.deleteNote(event.note)
                    recentlyDeletedNote = event.note
                }

            }

            is NotesEvent.RestoreNote -> {

                viewModelScope.launch {

                    noteUseCases.addNote(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null

                }

            }

            is NotesEvent.ToggleOrderSection -> {

                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )

            }
        }

    }

    private fun getNotes(noteOrder: NoteOrder) {
        getNotesJob?.cancel()
        getNotesJob = noteUseCases.getNotes(noteOrder)
            .onEach { notes ->
                _state.value = state.value.copy(
                    notes = notes,
                    noteOrder = noteOrder
                )
            }
            .launchIn(viewModelScope)
    }


}