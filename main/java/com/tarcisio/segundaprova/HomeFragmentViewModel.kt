package com.tarcisio.segundaprova

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room

class HomeFragmentViewModel(application: Application): AndroidViewModel(application) {
    var cafe: List<Cafe>?= null;

    init {
        val db: AppDatabase by lazy {
            Room.databaseBuilder(application.applicationContext,
                    AppDatabase::class.java, "cafe.sqlite")
                    .allowMainThreadQueries()
                    .build()
        }
        cafe = db.cafeDAO().listAll();
    }
}