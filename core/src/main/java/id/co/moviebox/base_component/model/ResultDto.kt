package id.co.moviebox.base_component.model

import com.google.gson.annotations.SerializedName

class ResultDto<T>(
    @SerializedName("items")
    val items: List<T>? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("status")
    val status: String = "INITIATE",
    @SerializedName("code")
    val code: String = "XXX"
) {
    companion object {
        const val SUCCESS = "000"
    }
}