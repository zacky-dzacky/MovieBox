package id.co.moviebox.service_genre.domain.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Genre(
    @SerializedName("id") var id: String,
    @SerializedName("name") var name: String,
): Serializable {
    companion object {
        val DEFAULT = Genre("", "")
    }
}