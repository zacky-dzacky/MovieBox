package id.co.moviebox.service_genre.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.co.moviebox.service_genre.data.local.entity.UserLocal

@Dao
interface UserLocalDao {
    @Query("SELECT * FROM UserLocal")
    suspend fun getAll(): List<UserLocal>


    @Query("SELECT * FROM UserLocal WHERE name = :userID LIMIT 1")
    suspend fun findByUserID(userID: String): UserLocal?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg users: UserLocal)

    @Delete
    suspend fun delete(profile: UserLocal)

    @Query("DELETE FROM userlocal")
    suspend fun deleteAll()
}