package com.dstod.courcesapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val topic: Int,
    val attendees: Int,
    @DrawableRes val background: Int
)
