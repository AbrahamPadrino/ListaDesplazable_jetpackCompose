package com.example.listadesplazabledeartes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Art(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
