package id.co.moviebox.service_genre.domain.usecase

import id.co.moviebox.base_component.model.Result
import id.co.moviebox.base_component.service.BaseUseCase
import id.co.moviebox.service_genre.domain.entity.SearchUser
import id.co.moviebox.service_genre.domain.repository.SearchRepository

class SearchUserUseCase(
    private val repository: SearchRepository
): BaseUseCase<String, List<SearchUser>?>() {
    override val default: List<SearchUser>
        get() = listOf()

    override suspend fun build(param: String): Result<List<SearchUser>?> {
        return Result(null)
//        return repository.searchUser(param)
    }

}