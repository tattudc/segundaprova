package com.tarcisio.segundaprova

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import androidx.room.Room.databaseBuilder

class CadastraFragmentViewModel(application: Application): AndroidViewModel(application) {
    var nome:String = "";
    var pais:String = "";
    var sabor:String = "";
    var preco:Float = 0f;
    var grao:String ="";
    var brasilProduz:Int = 0;

    val db:AppDatabase by lazy {
        databaseBuilder(
                application.applicationContext,
                AppDatabase::class.java, "cafe.sqlite")
                .allowMainThreadQueries()
                .build()
    }

    fun cadastraDados(cafe:Cafe){
        db.cafeDAO().inserir(cafe);
    }
}