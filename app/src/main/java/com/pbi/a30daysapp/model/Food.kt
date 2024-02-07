package com.pbi.a30daysapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Food(
    @StringRes val foodTitle: Int,
    @StringRes val foodDesc: Int,
    @DrawableRes val foodImage: Int
)
