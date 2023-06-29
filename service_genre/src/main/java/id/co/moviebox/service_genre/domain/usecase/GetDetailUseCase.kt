package id.co.moviebox.service_genre.domain.usecase

import id.co.moviebox.base_component.model.Result
import id.co.moviebox.base_component.service.BaseUseCase
import id.co.moviebox.service_genre.domain.entity.DetailUser
import id.co.moviebox.service_genre.domain.repository.UserRepository

class GetDetailUseCase(
    private val repository: UserRepository
): BaseUseCase<String, DetailUser>() {

    override val default: DetailUser
        get() = DetailUser.DEFAULT

    override suspend fun build(param: String): Result<DetailUser> {
        val data = Result<DetailUser>()
        data.data = repository.getUser(param)
        return data
    }
}