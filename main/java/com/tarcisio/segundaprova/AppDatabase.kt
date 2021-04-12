package com.tarcisio.segundaprova

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Cafe::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun cafeDAO(): CafeDAO
}