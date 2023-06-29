package id.co.moviebox.service_genre.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import id.co.moviebox.service_genre.data.local.UserDatabase.Companion.ROOM_VERSION
import id.co.moviebox.service_genre.data.local.dao.UserLocalDao
import id.co.moviebox.service_genre.data.local.entity.UserLocal

@Database(entities = [UserLocal::class], version = ROOM_VERSION, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userLocalDao(): UserLocalDao

    companion object {
        const val DATABASE_NAME = "moviebox_db"
        const val ROOM_VERSION = 1
    }
}