package id.co.moviebox.service_genre.domain.usecase

import id.co.moviebox.base_component.model.Result
import id.co.moviebox.base_component.service.BaseUseCase
import id.co.moviebox.service_genre.domain.entity.Genre
import id.co.moviebox.service_genre.domain.repository.UserLocalRepository

class GetFavoriteUseCase(
    private val repository: UserLocalRepository
): BaseUseCase<Unit, List<Genre>>() {

    override val default: List<Genre>
        get() = listOf()

    override suspend fun build(param: Unit): Result<List<Genre>> {
        val data = Result<List<Genre>>()
        data.data = repository.getAllFavoriteUser()
        return data
    }
}