package id.co.moviebox.service_genre.data.local.repository

import id.co.moviebox.base_component.model.Result
import id.co.moviebox.service_genre.data.local.dao.UserLocalDao
import id.co.moviebox.service_genre.data.local.entity.UserLocal
import id.co.moviebox.service_genre.data.local.mapper.UsersLocalMapper
import id.co.moviebox.service_genre.domain.entity.DetailMovie
import id.co.moviebox.service_genre.domain.entity.Genre
import id.co.moviebox.service_genre.domain.repository.UserLocalRepository

class UserLocalRepositoryImpl(
    private val userLocalDao: UserLocalDao,
    private val usersLocalMapper: UsersLocalMapper
): UserLocalRepository{
    override suspend fun getTrending(): List<Genre> {
        return usersLocalMapper(userLocalDao.getAll())
    }

    override suspend fun setFavoriteUser(user: Genre): Result<Unit> {
        val userLocal = UserLocal(
            user.id,
            user.name
        )
        userLocalDao.insertAll(userLocal)
        return Result(Unit)
    }

    override suspend fun unSetFavoriteUser(user: Genre): Result<Unit> {
        val userLocal = UserLocal(
            user.id,
            user.name
        )
        userLocalDao.delete(userLocal)
        return Result(Unit)
    }

    override suspend fun getDetailUser(userID: String): Result<DetailMovie> {

        val asdf = userID
        val localUser = userLocalDao.findByUserID(asdf)
//        val userData = DetailUser(
//            localUser?.login ?: "",
//            localUser?.id ?: "",
//            localUser?.node_id ?: "",
//            localUser?.avatar_url ?: "",
//            localUser?.gravatar_id ?: "",
//            localUser?.url ?: "",
//            localUser?.html_url ?: "",
//            localUser?.followers_url ?: "",
//            localUser?.following_url ?: "",
//            localUser?.gists_url?: "",
//            localUser?.starred_url?: "",
//            localUser?.subscriptions_url?: "",
//            localUser?.organizations_url?: "",
//            localUser?.repos_url?: "",
//            localUser?.events_url?: "",
//            localUser?.received_events_url?: "",
//            localUser?.type?: "",
//            localUser?.site_admin ?: "n", "", "", "", "", "", "", "", "",
//            "", "", "", "", "", ""
//        )

        return Result(null)
    }
}