package com.adiselav.dam1099seminar4;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

//in interfata facem comenzile pentru baza de date

@Dao
public interface ApartamentDAO {
    @Insert
    void insertApartament(Apartament apartament);

    @Query("Select * from  Apartamente")
    List<Apartament> getApartamente();

    @Delete
    void deleteApartament(Apartament apartament);
}
