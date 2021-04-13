package com.tarcisio.segundaprova

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CafeDAO {

    @Insert
    fun inserir(cafe:Cafe):Long

    @Delete
    fun deletar(cafe:Cafe):Int

    @Update
    fun atualizar(cafe:Cafe):Int

    @Query("SELECT * FROM tabela_cafe")
    fun listAll():LiveData<List<Cafe>>

    @Query("SELECT * FROM tabela_cafe WHERE id= :id")
    fun findById(id:Long):Cafe



}