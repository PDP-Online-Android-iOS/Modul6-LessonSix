package dev.ogabek.kotlin.model

data class RespondListData <T> (
    val status: String,
    val data: List<T>,
    val message: String
)