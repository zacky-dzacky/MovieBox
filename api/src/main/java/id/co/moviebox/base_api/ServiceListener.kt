package id.co.moviebox.base_api

abstract class ServiceListener {
    abstract fun onSuccess(modelResponse: String)

    abstract fun onFailed(message: String?)
}