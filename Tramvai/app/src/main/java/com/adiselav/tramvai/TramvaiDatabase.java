package com.adiselav.tramvai;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Tramvai.class}, version = 1)

public abstract class TramvaiDatabase extends RoomDatabase {

    public abstract TramvaiDAO getDaoObject();

    public static TramvaiDatabase database;
    public static synchronized TramvaiDatabase getInstance(Context context){
        if (database==null)
        {
            database = Room.databaseBuilder(context, TramvaiDatabase.class,"tramvaie.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return database;
    }
}
