package com.tarcisio.segundaprova

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CafeAdapter : RecyclerView.Adapter<CafeViewHolder>() {
    var listaCafe: List<Cafe> = ArrayList();

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CafeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itens_cafe, parent, false);
        val holder = CafeViewHolder(view);
        return holder;
    }

    override fun onBindViewHolder(holder: CafeViewHolder, position: Int) {
        val cafeEscolhido = listaCafe.get(position);

        holder.nomeCafe.text = cafeEscolhido.nome;
    }

    override fun getItemCount(): Int {
        return listaCafe.size
    }
}