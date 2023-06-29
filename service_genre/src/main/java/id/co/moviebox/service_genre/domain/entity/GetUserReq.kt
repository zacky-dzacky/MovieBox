package id.co.moviebox.service_genre.domain.entity

data class GetUserReq(
    var userID: String
) {
    companion object {
        val DEFAULT = GetUserReq("")
    }
}