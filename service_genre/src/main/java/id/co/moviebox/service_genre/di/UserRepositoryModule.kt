package id.co.moviebox.service_genre.di

import android.content.Context
import dagger.Module
import dagger.Provides
import id.co.moviebox.service_genre.data.api.flow.ShowSearchUserSource
import id.co.moviebox.service_genre.data.api.mapper.MoviesByGenreMapper
import id.co.moviebox.service_genre.data.api.mapper.DetailMovieMapper
import id.co.moviebox.service_genre.data.api.mapper.GenresDtoMapper
import id.co.moviebox.service_genre.data.api.repository.SearchRepositoryImpl
import id.co.moviebox.service_genre.data.api.repository.MovieRepositoryImpl
import id.co.moviebox.service_genre.data.api.service.MoviesApi
import id.co.moviebox.service_genre.data.local.dao.UserLocalDao
import id.co.moviebox.service_genre.data.local.mapper.UsersLocalMapper
import id.co.moviebox.service_genre.data.local.repository.UserLocalRepositoryImpl
import id.co.moviebox.service_genre.domain.repository.SearchRepository
import id.co.moviebox.service_genre.domain.repository.UserLocalRepository
import id.co.moviebox.service_genre.domain.repository.MoviesRepository

@Module
class UserRepositoryModule {

    @Provides
    fun provideUserRepository(context: Context, userApi: MoviesApi, userLocalDao: UserLocalDao): MoviesRepository {
        return MovieRepositoryImpl(
            context,
            userApi,
            GenresDtoMapper(),
            DetailMovieMapper(),
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
    fun provideShowSearchUserSource(userApi: MoviesApi): ShowSearchUserSource {
        return ShowSearchUserSource(
            userApi,
            MoviesByGenreMapper()
        )
    }

}