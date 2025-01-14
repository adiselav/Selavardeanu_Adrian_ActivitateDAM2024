package com.adiselav.tramvai;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TramvaiDAO {
    @Insert
    void insertTramvai(Tramvai tramvai);

    @Query("SELECT * FROM tramvaie")
    List<Tramvai> getTramvaie();

    @Query("DELETE FROM tramvaie WHERE bidirectional == 1")
    void deleteTramvaieBidirectionale();

    @Query("SELECT COUNT(id) FROM tramvaie")
    int nrTramvaie();

    @Delete
    void deleteTramvai(Tramvai tramvai);
}
