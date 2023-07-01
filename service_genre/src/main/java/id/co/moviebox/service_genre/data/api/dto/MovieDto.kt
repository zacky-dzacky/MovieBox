package id.co.moviebox.service_genre.data.api.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieDto(
    @SerializedName("description") val description: String? = "",
    @SerializedName("favorite_count") val favorite_count: Int? =  0,
    @SerializedName("id") val id: String? = "",
    @SerializedName("item_count") val item_count: Int? = 0,
    @SerializedName("iso_639_1") val iso_639_1: String? = "en",
    @SerializedName("list_type") val list_type: String? = "movie",
    @SerializedName("name") val name: String? = "",
    @SerializedName("poster_path") val poster_path: String? = ""
) : Serializable {
    companion object {
        val DEFAULT_LIST = MovieDto("", 0, "",
        0, "", "", "", "")
    }
}