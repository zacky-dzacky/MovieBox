package id.co.moviebox.service_genre.domain.entity

import com.google.gson.annotations.SerializedName
import id.co.moviebox.service_genre.data.api.dto.BelongsToCollection
import id.co.moviebox.service_genre.data.api.dto.Genre
import id.co.moviebox.service_genre.data.api.dto.ProductionCompany
import id.co.moviebox.service_genre.data.api.dto.SpokenLanguage
import java.io.Serializable

data class DetailMovie(
    @SerializedName("adult") val adult: Boolean = false,
    @SerializedName("backdrop_path") val backdropPath: String = "",
    @SerializedName("belongs_to_collection") val belongsToCollection: BelongsToCollection,
    @SerializedName("budget") val budget: Int =  0,
    @SerializedName("genres") val genres: List<Genre>,
    @SerializedName("homepage") val homepage: String = "",
    @SerializedName("id") val id: Int =  0,
    @SerializedName("imdb_id") val imdb_id: String =  "",
    @SerializedName("original_language") val originalLanguage: String =  "",
    @SerializedName("original_title") val originalTitle: String =  "",
    @SerializedName("overview") val overview: String =  "",
    @SerializedName("popularity") val popularity: Double =  0.0,
    @SerializedName("poster_path") val posterPath: String =  "",
    @SerializedName("production_companies") val productionCompany: List<ProductionCompany>? = listOf(),
    @SerializedName("release_date") val releasedDate: String = "",
    @SerializedName("revenue") val revenue: Int = 0,
    @SerializedName("runtime") val runtime: Int = 57,
    @SerializedName("spoken_languages") val spoken_languages: List<SpokenLanguage>? = listOf(),
    @SerializedName("status") val status: String = "",
    @SerializedName("tagline") val tagline: String = "",
    @SerializedName("title") val title: String = "",
    @SerializedName("video") val video: Boolean = false,
    @SerializedName("vote_average") val voteAverage: Double? = 0.0,
    @SerializedName("vote_count") val voteCount: Int? = 0
): Serializable {
    companion object {
        val DEFAULT = DetailMovie(false,
            "",
            BelongsToCollection(),
            0,
            listOf(),
            "",
            0,
            "",
            "",
            "",
            "",
            0.0,
            "",
            listOf(),
            "",
            0,
            57,
            listOf(),
            "",
            "",
            "",
            false,
            0.0,
            0
        )
    }
}