package com.example.noteapp.modules.notes.domain.util

sealed class OrderType{
    object Ascending: OrderType()
    object Descending: OrderType()
}