package com.kaedenoki.petshelter.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class DataSave(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,

    @ColumnInfo(name = "name")
    var name : String? = null,

    @ColumnInfo(name = "animal")
    var animal : String? = null,

    @ColumnInfo(name = "type")
    var type : String? = null,

    @ColumnInfo(name = "room")
    var room : String? = null
) : Parcelable
