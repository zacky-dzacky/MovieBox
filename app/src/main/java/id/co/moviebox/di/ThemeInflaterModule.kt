package id.co.moviebox.di

import dagger.Module
import dagger.Provides
import id.co.moviebox.base_component.ui.ThemeInflater
import id.co.moviebox.ui.ThemeInflaterImpl

@Module
class ThemeInflaterModule{
    @Provides
    fun provideMyXLThemeInflater(): ThemeInflater {
        return ThemeInflaterImpl()
    }
}