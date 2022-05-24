package dev.ogabek.kotlin.network

interface VolleyHandler {
    fun onSuccess(response: String)
    fun onError(error: String)
}