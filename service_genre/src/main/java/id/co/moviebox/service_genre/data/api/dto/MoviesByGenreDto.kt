package id.co.moviebox.service_genre.data.api.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MoviesByGenreDto(
    @SerializedName("id") val id: Int? = 0,
    @SerializedName("page") val page: Int? = 0,
    @SerializedName("results") val result: List<MovieDto>? = listOf(),
) : Serializable {
    companion object {
        val DEFAULT_LIST = listOf<MovieDto>()
    }
}