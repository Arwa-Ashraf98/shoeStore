package com.example.android.udacityshoestoe.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ModelShoe(
    var shoeName: String,
    var shoeCompany: String,
    var shoeSize: String,
    var shoeDescription: String,
) : Parcelable