package id.co.moviebox.service_genre.di
import dagger.Module
import dagger.Provides
import id.co.moviebox.service_genre.domain.repository.UserLocalRepository
import id.co.moviebox.service_genre.domain.repository.MoviesRepository
import id.co.moviebox.service_genre.domain.usecase.GetDetailLocalUseCase
import id.co.moviebox.service_genre.domain.usecase.GetDetailUseCase
import id.co.moviebox.service_genre.domain.usecase.GetTrendingUseCase
import id.co.moviebox.service_genre.domain.usecase.GetUsersUseCase
import id.co.moviebox.service_genre.domain.usecase.SetFavoritelUseCase
import id.co.moviebox.service_genre.domain.usecase.UnSetFavoritelUseCase

@Module
class UserUseCaseModule {

    @Provides
    fun provideGetDetailUseCase(repository: MoviesRepository): GetDetailUseCase {
        return GetDetailUseCase(repository)
    }

    @Provides
    fun provideFavoriteUseCase(repository: UserLocalRepository): GetTrendingUseCase {
        return GetTrendingUseCase(repository)
    }

    @Provides
    fun provideGetUsersUseCase(repository: MoviesRepository): GetUsersUseCase {
        return GetUsersUseCase(repository)
    }

    @Provides
    fun provideSetFavoritelUseCase(repository: UserLocalRepository): SetFavoritelUseCase {
        return SetFavoritelUseCase(repository)
    }

    @Provides
    fun provideUnSetFavoritelUseCase(repository: UserLocalRepository): UnSetFavoritelUseCase {
        return UnSetFavoritelUseCase(repository)
    }

    @Provides
    fun provideGetDetailLocalUseCase(repository: UserLocalRepository): GetDetailLocalUseCase {
        return GetDetailLocalUseCase(repository)
    }
}