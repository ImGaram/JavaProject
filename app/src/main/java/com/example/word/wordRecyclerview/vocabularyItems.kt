package com.example.word.wordRecyclerview

import java.io.Serializable

data class vocabularyItems (
    val number : Int,
    val word : String,
    val mean : String
) : Serializable