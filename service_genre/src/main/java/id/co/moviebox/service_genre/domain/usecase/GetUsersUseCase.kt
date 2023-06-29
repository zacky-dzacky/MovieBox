package id.co.moviebox.service_genre.domain.usecase

import id.co.moviebox.base_component.model.Result
import id.co.moviebox.base_component.service.BaseUseCase
import id.co.moviebox.service_genre.domain.entity.GetUserReq
import id.co.moviebox.service_genre.domain.entity.Genre
import id.co.moviebox.service_genre.domain.repository.MoviesRepository

class GetUsersUseCase(
    private val repository: MoviesRepository
) : BaseUseCase<GetUserReq, List<Genre>>() {

    override val default: List<Genre>
        get() = listOf()

    override suspend fun build(param: GetUserReq): Result<List<Genre>> {
        val data = Result<List<Genre>>()
        data.data = repository.getGenres()
        return data
    }
}