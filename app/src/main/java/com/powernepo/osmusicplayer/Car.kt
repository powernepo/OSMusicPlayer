package com.powernepo.osmusicplayer

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Car(
    val name: String
) : Parcelable