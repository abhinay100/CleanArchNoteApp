package com.abhinay.cleanarchitecturenoteapp.feature_note.domain.model

import androidx.room.PrimaryKey
import com.abhinay.cleanarchitecturenoteapp.ui.theme.BabyBlue
import com.abhinay.cleanarchitecturenoteapp.ui.theme.LightGreen
import com.abhinay.cleanarchitecturenoteapp.ui.theme.RedOrange
import com.abhinay.cleanarchitecturenoteapp.ui.theme.RedPink
import com.abhinay.cleanarchitecturenoteapp.ui.theme.Violet


/**
 * Represents a single note within the application.
 *
 * This data class stores the essential information for a note, including its title,
 * content, creation timestamp, color, and a unique identifier.
 *
 * @property title The title of the note. Cannot be null or empty.
 * @property content The main body of the note. Can be null or empty.
 * @property timestamp The timestamp representing when the note was created or last modified, stored as a Long (e.g., milliseconds since the epoch).
 * @property color The color associated with the note. This is represented as an Int, typically from a predefined color palette.
 * @property id The unique identifier for the note. It's nullable, as new notes might not have an ID until they are saved to a persistent storage (like a database). Uses Room's @PrimaryKey for database storage.
 *
 * @constructor Creates a new Note object.
 */
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)

    }
}
