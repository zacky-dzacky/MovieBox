package id.co.moviebox.service_genre.data.api.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GenreDto(
    @SerializedName("id")var id: String,
    @SerializedName("name")var name: String,
) : Serializable