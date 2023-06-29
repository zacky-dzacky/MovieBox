package id.co.moviebox.service_genre.di

import android.content.Context
import dagger.Module
import dagger.Provides
import id.co.moviebox.service_genre.data.api.flow.ShowSearchUserSource
import id.co.moviebox.service_genre.data.api.mapper.SearchUserDtoMapper
import id.co.moviebox.service_genre.data.api.mapper.UserDtoMapper
import id.co.moviebox.service_genre.data.api.mapper.UsersDtoMapper
import id.co.moviebox.service_genre.data.api.repository.SearchRepositoryImpl
import id.co.moviebox.service_genre.data.api.repository.UserRepositoryImpl
import id.co.moviebox.service_genre.data.api.service.UserApi
import id.co.moviebox.service_genre.data.local.dao.UserLocalDao
import id.co.moviebox.service_genre.data.local.mapper.UsersLocalMapper
import id.co.moviebox.service_genre.data.local.repository.UserLocalRepositoryImpl
import id.co.moviebox.service_genre.domain.repository.SearchRepository
import id.co.moviebox.service_genre.domain.repository.UserLocalRepository
import id.co.moviebox.service_genre.domain.repository.UserRepository

@Module
class UserRepositoryModule {

    @Provides
    fun provideUserRepository(context: Context, userApi: UserApi, userLocalDao: UserLocalDao): UserRepository {
        return UserRepositoryImpl(
            context,
            userApi,
            UsersDtoMapper(),
            UserDtoMapper(),
            userLocalDao,
            UsersLocalMapper()
        )
    }

    @Provides
    fun provideUserLocalRepository(userLocalDao: UserLocalDao) : UserLocalRepository {
        return UserLocalRepositoryImpl(
            userLocalDao,
            UsersLocalMapper()
        )
    }

    @Provides
    fun provideSearchRepository(searchUserSource: ShowSearchUserSource) : SearchRepository {
        return SearchRepositoryImpl(
            searchUserSource
        )
    }

    @Provides
    fun provideShowSearchUserSource(userApi: UserApi): ShowSearchUserSource {
        return ShowSearchUserSource(
            userApi,
            SearchUserDtoMapper()
        )
    }

}