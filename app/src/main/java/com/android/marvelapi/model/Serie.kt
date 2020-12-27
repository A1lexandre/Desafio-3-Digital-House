package com.android.marvelapi.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Serie (
    val resourceURI: String,
    val name: String
):Parcelable