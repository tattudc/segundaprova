package com.tarcisio.segundaprova

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabela_cafe")
data class Cafe (
    var nome:String = "",
    var pais:String = "",
    var sabor:String = "",
    var preco:Float = 0f,
    var grao:String ="",
    var brasilProduz:Int = 0
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
