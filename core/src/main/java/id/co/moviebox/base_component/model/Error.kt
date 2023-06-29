package id.co.moviebox.base_component.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Error(
    var code: String,
    var message: String
): Parcelable {
    companion object {
        const val NO_DATA = "0000"
        const val NO_INTERNET = "0001"
        const val UNAUTHORIZED = "0002"
    }
}