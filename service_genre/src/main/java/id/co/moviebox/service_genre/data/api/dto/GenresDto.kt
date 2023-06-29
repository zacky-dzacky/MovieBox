package id.co.moviebox.service_genre.data.api.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GenresDto(
    @SerializedName("genres") val genres: List<GenreDto>,
) : Serializable {
    companion object {
        val DEFAULT_LIST = listOf<GenreDto>()
    }
}