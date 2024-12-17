package com.adiselav.student_test;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class},version = 1)
public abstract class StudentDatabase extends RoomDatabase {

    public abstract StudentDAO getStudentiDao();

    public static StudentDatabase database;
    public static synchronized StudentDatabase getInstance(Context context){
        if (database==null)
        {
            database = Room.databaseBuilder(context, StudentDatabase.class,"studenti.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return database;
    }

}
