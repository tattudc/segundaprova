package com.tarcisio.segundaprova

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room

class AlteraFragmentViewModel(application: Application): AndroidViewModel(application) {
    val db: AppDatabase by lazy {
        Room.databaseBuilder(application.applicationContext,
            AppDatabase::class.java, "cafe.sqlite")
            .allowMainThreadQueries()
            .build()
    }

    var nome:String = "";
    var pais:String = "";
    var sabor:String = "";
    var preco:Float = 0f;
    var grao:String ="";
    var brasilProduz:Int = 0;

    fun setDados(id : Long){
        val cafe = db.cafeDAO().findById(id);

        nome = cafe.nome;
        pais = cafe.pais;
        sabor = cafe.sabor;
        preco = cafe.preco;
        grao = cafe.grao;
        brasilProduz  = cafe.brasilProduz;
    }

    fun AlteraDados(cafe: Cafe){
        db.cafeDAO().atualizar(cafe);
    }

}