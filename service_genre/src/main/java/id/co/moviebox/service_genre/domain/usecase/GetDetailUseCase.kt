package id.co.moviebox.service_genre.domain.usecase

import id.co.moviebox.base_component.model.Result
import id.co.moviebox.base_component.service.BaseUseCase
import id.co.moviebox.service_genre.domain.entity.DetailMovie
import id.co.moviebox.service_genre.domain.repository.MoviesRepository

class GetDetailUseCase(
    private val repository: MoviesRepository
): BaseUseCase<String, DetailMovie>() {

    override val default: DetailMovie
        get() = DetailMovie.DEFAULT

    override suspend fun build(param: String): Result<DetailMovie> {
        val data = Result<DetailMovie>()
        data.data = repository.getDetailMovie(param)
        return data
    }
}