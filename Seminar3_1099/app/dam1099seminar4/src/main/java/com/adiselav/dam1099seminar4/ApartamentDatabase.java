package com.adiselav.dam1099seminar4;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Apartament.class}, version = 1)
public abstract class ApartamentDatabase extends RoomDatabase {
    public abstract ApartamentDAO getDaoObject();

}
