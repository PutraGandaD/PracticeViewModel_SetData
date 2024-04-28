package com.putragandad.practiceviewmodel.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Note(val title: String,
                val content: String) : Parcelable


