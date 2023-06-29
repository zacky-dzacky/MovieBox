package id.co.moviebox.home.vm

import androidx.lifecycle.ViewModel
import id.co.moviebox.base_component.extention.StatefulLiveData
import id.co.moviebox.service_genre.domain.entity.GetUserReq
import id.co.moviebox.service_genre.domain.usecase.GetUsersUseCase
import javax.inject.Inject
import androidx.lifecycle.viewModelScope

class HomeVM @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
): ViewModel(), HomeContract.Presenter {


    override val user = StatefulLiveData(getUsersUseCase, viewModelScope)


    override fun getUser() {
        user.get(GetUserReq.DEFAULT)
    }


}