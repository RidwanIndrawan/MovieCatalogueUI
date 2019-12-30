package id.ridwan.moviecatalogueui

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data  class Data(
        var photo : Int,
        var name : String,
        var desc : String,
        var check : String
    ) : Parcelable
