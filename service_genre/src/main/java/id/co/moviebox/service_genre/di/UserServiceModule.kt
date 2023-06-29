package id.co.moviebox.service_genre.di

import dagger.Module

@Module(includes = [UserUseCaseModule::class, UserRepositoryModule::class, UserDataModule::class])
interface UserServiceModule