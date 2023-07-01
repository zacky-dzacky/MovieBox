package id.co.moviebox.service_genre.data.api.mapper

import id.co.moviebox.base_component.extention.toResult
import id.co.moviebox.base_component.model.Result
import id.co.moviebox.base_component.model.ResultDto
import id.co.moviebox.service_genre.data.api.dto.DetailMovieDto
import id.co.moviebox.service_genre.domain.entity.DetailMovie

class DetailMovieMapper {
    operator fun invoke(from: DetailMovieDto): DetailMovie {
        return from.let { data ->
            DetailMovie(
                adult = data.adult,
                backdropPath = data.backdropPath,
                belongsToCollection = data.belongsToCollection,
                budget = data.budget,
                genres = data.genres,
                homepage = data.homepage,
                id = data.id,
                imdb_id = data.imdb_id,
                originalLanguage = data.originalLanguage,
                originalTitle = data.originalTitle,
                overview = data.overview,
                popularity = data.popularity,
                posterPath = data.posterPath,
                productionCompany = data.productionCompany,
                releasedDate = data.release_date,
                revenue = data.revenue,
                runtime = data.runtime,
                spoken_languages = data.spoken_languages,
                status = data.status,
                tagline = data.tagline,
                title = data.title,
                video = data.video,
                voteAverage = data.voteAverage,
                voteCount = data.voteCount,
            )
        }

    }
}