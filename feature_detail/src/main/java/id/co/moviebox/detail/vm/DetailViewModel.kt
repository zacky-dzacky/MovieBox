package id.co.moviebox.detail.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.co.moviebox.base_component.extention.StatefulLiveData
import id.co.moviebox.service_genre.domain.entity.Genre
import id.co.moviebox.service_genre.domain.usecase.GetDetailLocalUseCase
import id.co.moviebox.service_genre.domain.usecase.GetDetailUseCase
import id.co.moviebox.service_genre.domain.usecase.SetFavoritelUseCase
import id.co.moviebox.service_genre.domain.usecase.UnSetFavoritelUseCase
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    getDetailUseCase: GetDetailUseCase,
    setFavoriteUseCase: SetFavoritelUseCase,
    unSetFavoritelUseCase: UnSetFavoritelUseCase,
    getDetailLocalUseCase: GetDetailLocalUseCase
): ViewModel() {

    val getDetailUser = StatefulLiveData(
        getDetailUseCase,
        viewModelScope,
        true
    )

    val setFavorite = StatefulLiveData(
        setFavoriteUseCase,
        viewModelScope,
        true
    )

    val unSetFavorite = StatefulLiveData(
        unSetFavoritelUseCase,
        viewModelScope,
        true
    )

    val getDetailLocal = StatefulLiveData(
        getDetailLocalUseCase,
        viewModelScope,
        true
    )

    fun getDetailUser(moviesID: String) {
        getDetailUser.get(moviesID)
    }

    fun setAsFavorite(userID: Genre) {
        setFavorite.get(userID)
    }

    fun unSetAsFavorite(userID: Genre) {
        unSetFavorite.get(userID)
    }

    fun getDetailLocal(userID: String) {
        getDetailLocal.get(userID)
    }
}