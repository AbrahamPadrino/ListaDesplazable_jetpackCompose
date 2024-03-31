package com.example.listadesplazabledeartes.data

import com.example.listadesplazabledeartes.R
import com.example.listadesplazabledeartes.model.Art

class Datasource {
    fun loadArts(): List<Art> {
        return listOf<Art>(
            Art(R.string.title_art_one, R.drawable.art_1),
            Art(R.string.title_art_two, R.drawable.art_2),
            Art(R.string.title_art_three, R.drawable.art_3),
            Art(R.string.title_art_four, R.drawable.art_4),
            Art(R.string.title_art_five, R.drawable.art_5),
            Art(R.string.title_art_six, R.drawable.art_6),
            Art(R.string.title_art_seven, R.drawable.art_7),
            Art(R.string.title_art_eight, R.drawable.art_8),
            Art(R.string.title_art_nine, R.drawable.art_9)
        )
    }
}