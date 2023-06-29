package id.co.moviebox.service_genre.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import id.co.moviebox.base_component.di.AppScope
import id.co.moviebox.service_genre.data.api.service.UserApi
import id.co.moviebox.service_genre.data.local.UserDatabase
import id.co.moviebox.service_genre.data.local.dao.UserLocalDao
import retrofit2.Retrofit

@Module
class UserDataModule {

    @Provides
    fun provideUserApi(retrofit: Retrofit): UserApi = retrofit.create(UserApi::class.java)

    @Provides
    @AppScope
    fun provideUserDatabase(context: Context): UserDatabase {
        return Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            UserDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @AppScope
    fun provideUserLocalDao(userDatabase: UserDatabase): UserLocalDao {
        return userDatabase.userLocalDao()
    }
}