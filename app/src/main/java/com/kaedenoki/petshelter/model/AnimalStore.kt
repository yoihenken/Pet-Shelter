package com.kaedenoki.petshelter.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AnimalStore (
    var id : String ?= null,
    var name : String ?= null,
    var animal : String ?= null,
    var type : String ?= null,
    var room : String ?= null,
) : Parcelable