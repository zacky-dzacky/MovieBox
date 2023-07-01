package id.co.moviebox.service_genre.data.api.dto

import com.google.gson.annotations.SerializedName
import org.intellij.lang.annotations.Language
import java.io.Serializable

data class DetailMovieDto (

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
    @SerializedName("release_date") val release_date: String = "1989-09-06",
    @SerializedName("revenue") val revenue: Int = 0,
    @SerializedName("runtime") val runtime: Int = 57,
    @SerializedName("spoken_languages") val spoken_languages: List<SpokenLanguage>,
    @SerializedName("status") val status: String = "Released",
    @SerializedName("tagline") val tagline: String = "Thou shalt not take the name of the Lord thy God in vain.",
    @SerializedName("title") val title: String = "",
    @SerializedName("video") val video: Boolean = false,
    @SerializedName("vote_average") val voteAverage: Double? = 0.0,
    @SerializedName("vote_count") val voteCount: Int? = 0
): Serializable

data class SpokenLanguage(
    @SerializedName("english_name") val english_name: String? =  "",
    @SerializedName("iso_639_1") val iso_639_1: String? =  "",
    @SerializedName("name") val name: String? =  ""
): Serializable

data class ProductionCompany(
    @SerializedName("id") val id: Int? =  0,
    @SerializedName("logo_path") val logoPath: String? =  "",
    @SerializedName("name") val name: String? =  "",
    @SerializedName("origin_country") val originCountry: String? =  ""
)

data class BelongsToCollection(
    @SerializedName("id") val id: Int? = 0,
    @SerializedName("name") val name: String? = "",
    @SerializedName("poster_path") val poster_path: String? = "",
    @SerializedName("backdrop_path") val backdrop_path: String? = ""
)

data class Genre(
    @SerializedName("id") val id: Int? = 0,
    @SerializedName("name") val name: String? = ""
)