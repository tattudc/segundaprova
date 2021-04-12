package com.tarcisio.segundaprova

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CafeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val nomeCafe: TextView;

    init {
        nomeCafe = view.findViewById(R.id.nomeCafe);
    }
}