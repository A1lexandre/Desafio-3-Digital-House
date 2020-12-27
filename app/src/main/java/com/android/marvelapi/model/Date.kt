package com.android.marvelapi.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Date(
    val date: String,
    val type: String
): Parcelable