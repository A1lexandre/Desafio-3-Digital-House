package com.android.marvelapi.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Price(
    val price: String,
    val type: String
): Parcelable