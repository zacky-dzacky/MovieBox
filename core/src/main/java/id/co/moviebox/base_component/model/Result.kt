package id.co.moviebox.base_component.model

import java.security.MessageDigest

class Result<T>(
    var data: T? = null,
    val id: Int? = 0,
    val page: Int? = 1,
    val message: String? = "",
    val code: String = "XXX"
)