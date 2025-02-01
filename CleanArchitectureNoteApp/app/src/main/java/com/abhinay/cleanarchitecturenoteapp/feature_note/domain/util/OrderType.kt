package com.abhinay.cleanarchitecturenoteapp.feature_note.domain.util


/**
 * Created by Abhinay on 28/01/25.
 *
 *
 */
sealed class OrderType {
    object Ascending : OrderType()
    object Descending : OrderType()
}