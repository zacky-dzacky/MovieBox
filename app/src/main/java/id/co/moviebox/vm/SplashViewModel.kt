package id.co.moviebox.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.co.moviebox.base_component.extention.StatefulLiveData
import id.co.moviebox.service_genre.domain.entity.GetUserReq
import id.co.moviebox.service_genre.domain.usecase.GetUsersUseCase
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    getUsersUseCase: GetUsersUseCase
): ViewModel() {

    val statusOpenMain = StatefulLiveData(
        getUsersUseCase,
        viewModelScope
    )

    fun openMain() {
        statusOpenMain.get(GetUserReq.DEFAULT)
    }

}