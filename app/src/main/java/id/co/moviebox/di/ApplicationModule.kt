package id.co.moviebox.di

import dagger.Module

@Module(includes = [ApplicationBindingModule::class, ThemeInflaterModule::class])
interface ApplicationModule