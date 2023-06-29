package id.co.moviebox.base_component.model

class Result<T>(
    var data: T? = null,
    val message: String? = null,
    val status: String = "INITIATE",
    val code: String = "XXX"
)