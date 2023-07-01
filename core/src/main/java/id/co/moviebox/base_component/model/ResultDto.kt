package id.co.moviebox.base_component.model

import com.google.gson.annotations.SerializedName

class ResultDto<T>(
    @SerializedName("results")
    val results: List<T>? = null,
    @SerializedName("message")
    val id: Int? = 0,
    @SerializedName("status")
    val page: Int? = 1,
    @SerializedName("code")
    val code: String = "XXX"
) {
    companion object {
        const val SUCCESS = "000"
    }
}