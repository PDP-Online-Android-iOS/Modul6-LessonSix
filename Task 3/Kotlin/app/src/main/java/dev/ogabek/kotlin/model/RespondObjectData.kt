package dev.ogabek.kotlin.model

data class RespondObjectData <T> (
    val status: String,
    val data: T,
    val message: String
)