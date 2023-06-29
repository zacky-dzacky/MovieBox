package id.co.moviebox.service_genre.domain.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GetUserResp(
    @SerializedName("id") var userID: String
) : Serializable {
    companion object {
        val DEFAULT = GetUserResp("")
    }
}