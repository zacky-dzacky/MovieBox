package id.co.moviebox.service_genre.domain.usecase

import id.co.moviebox.base_component.model.Result
import id.co.moviebox.base_component.service.BaseUseCase
import id.co.moviebox.service_genre.domain.entity.User
import id.co.moviebox.service_genre.domain.repository.UserLocalRepository

class UnSetFavoritelUseCase(
    private val repository: UserLocalRepository
): BaseUseCase<User, Unit>() {

    override val default: Unit
        get() = Unit

    override suspend fun build(param: User): Result<Unit> {
        return repository.setFavoriteUser(param)
    }
}