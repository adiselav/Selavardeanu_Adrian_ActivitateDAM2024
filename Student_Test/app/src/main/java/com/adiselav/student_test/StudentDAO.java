package com.adiselav.student_test;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDAO {

    @Insert
    long adaugaStudent(Student student);

    @Query("SELECT * FROM studenti")
    List<Student> getStudenti();

    @Delete
    void stergeStudenti(Student student);

    @Query("DELETE FROM studenti WHERE integralist == 1")
    void deleteIntegralisti();

    @Query("SELECT COUNT(id) FROM studenti")
    int nrStudenti();
}
