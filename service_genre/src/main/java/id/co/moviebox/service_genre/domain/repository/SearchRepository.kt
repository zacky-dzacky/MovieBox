package id.co.moviebox.service_genre.domain.repository

import androidx.paging.PagingData
import id.co.moviebox.service_genre.domain.entity.SearchUser
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    fun searchUser(name: String, position: Int): Flow<PagingData<SearchUser>>
}