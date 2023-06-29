package id.co.moviebox.detail.di

import dagger.Module

@Module(includes = [DetailBindingModule::class, DetailViewModelModule::class])
interface DetailModule