package id.co.moviebox.service_genre.domain.usecase

import id.co.moviebox.base_component.model.Result
import id.co.moviebox.base_component.service.BaseUseCase
import id.co.moviebox.service_genre.domain.entity.User
import id.co.moviebox.service_genre.domain.repository.UserLocalRepository

class GetFavoriteUseCase(
    private val repository: UserLocalRepository
): BaseUseCase<Unit, List<User>>() {

    override val default: List<User>
        get() = listOf()

    override suspend fun build(param: Unit): Result<List<User>> {
        val data = Result<List<User>>()
        data.data = repository.getAllFavoriteUser()
        return data
    }
}