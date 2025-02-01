package com.abhinay.cleanarchitecturenoteapp.feature_note.domain.util


/**
 * Represents the order in which notes should be displayed.
 * This is a sealed class with three concrete implementations: Title, Date, and Color.
 * Each implementation determines the primary attribute by which the notes will be sorted.
 *
 * @property orderType The type of ordering (ascending or descending).
 */
sealed class NoteOrder(val orderType: OrderType) {

    class Title(orderType: OrderType) : NoteOrder(orderType)
    class Date(orderType: OrderType) : NoteOrder(orderType)
    class Color(orderType: OrderType) : NoteOrder(orderType)

    fun copy(orderType: OrderType): NoteOrder {
        return when (this) {
            is Title -> Title(orderType)
            is Date -> Date(orderType)
            is Color -> Color(orderType)
        }
    }
}