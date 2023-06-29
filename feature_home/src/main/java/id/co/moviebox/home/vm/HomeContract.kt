package id.co.moviebox.home.vm

import id.co.moviebox.base_component.extention.StatefulLiveData
import id.co.moviebox.service_genre.domain.entity.GetUserReq
import id.co.moviebox.service_genre.domain.entity.Genre

interface HomeContract {

    interface Presenter {
        val user: StatefulLiveData<GetUserReq, List<Genre>>
        fun getUser()
    }
}