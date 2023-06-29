package id.co.moviebox.base_component.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreModule(application: Application) {
    private val appContext: Context

    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return appContext
    }

    init {
        appContext = application
    }
}