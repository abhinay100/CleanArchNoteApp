package com.abhinay.cleanarchitecturenoteapp.feature_note.domain.use_case


import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.util.NoteOrder
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


/**
 * `GetNotes` is a use case class responsible for retrieving a list of `Note` objects
 * from the underlying `NoteRepository` and applying sorting based on the provided `NoteOrder`.
 *
 * This class acts as an intermediary between the data layer (repository) and the
 * presentation layer (e.g., ViewModel). It encapsulates the logic of retrieving and
 * sorting notes, providing a clean and testable interface for the UI to use.
 *
 * @property repository The `NoteRepository` instance used to fetch the notes.
 */
class GetNotes(
    private val repository: NoteRepository
) {

    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<Note>> {

        return repository.getNotes().map { notes ->
            when (noteOrder.orderType) {
                is OrderType.Ascending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }

                }

                is OrderType.Descending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }

        }

    }

}