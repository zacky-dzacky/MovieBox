package id.co.moviebox.base_component.ui

import id.co.moviebox.base_component.model.Error

sealed class StatefulResult<out R> {
    val succeeded
        get() = this is Success && data != null

    data class Success<out T>(val data: T) : StatefulResult<T>()
    data class Failed(val error: Error? = null) : StatefulResult<Nothing>()
    object Loading : StatefulResult<Nothing>()
}