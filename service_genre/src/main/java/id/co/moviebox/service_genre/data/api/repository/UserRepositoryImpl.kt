package id.co.moviebox.service_genre.data.api.repository

import android.content.Context
import id.co.moviebox.service_genre.data.api.mapper.UserDtoMapper
import id.co.moviebox.service_genre.data.api.mapper.UsersDtoMapper
import id.co.moviebox.service_genre.data.api.service.UserApi
import id.co.moviebox.service_genre.data.local.dao.UserLocalDao
import id.co.moviebox.service_genre.data.local.mapper.UsersLocalMapper
import id.co.moviebox.service_genre.domain.entity.DetailUser
import id.co.moviebox.service_genre.domain.entity.User
import id.co.moviebox.service_genre.domain.repository.UserRepository

class UserRepositoryImpl(
    private val context: Context,
    private val userApi: UserApi,
    private val usersDtoMapper: UsersDtoMapper,
    private val userDtoMapper: UserDtoMapper,
    private val userLocalDao: UserLocalDao,
    private val usersLocalMapper: UsersLocalMapper
) : UserRepository {
    override suspend fun getListUser(): List<User> {

        return usersDtoMapper(context, userApi.getUsers())

//        users.let {
//            it.map { data ->
//                val userLocal = UserLocal(
//                    login = data.login,
//                    id = data.id,
//                    node_id = data.node_id,
//                    avatar_url = data.avatar_url,
//                    gravatar_id = data.gravatar_id,
//                    url = data.url,
//                    html_url = data.html_url,
//                    followers_url = data.followers_url,
//                    following_url = data.following_url,
//                    gists_url = data.gists_url,
//                    starred_url = data.starred_url,
//                    subscriptions_url = data.subscriptions_url,
//                    organizations_url = data.organizations_url,
//                    repos_url = data.repos_url,
//                    events_url = data.events_url,
//                    received_events_url = data.received_events_url,
//                    type = data.type,
//                    site_admin = data.site_admin,
//                )
//                userLocalDao.insertAll(userLocal)
//            }
//        }
    }

    override suspend fun getUser(username: String): DetailUser {
        return userDtoMapper(context, userApi.getUsersByUsername(username))
    }
}