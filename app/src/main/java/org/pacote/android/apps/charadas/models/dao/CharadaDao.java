package org.pacote.android.apps.charadas.models.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import org.pacote.android.apps.charadas.models.entities.Charada;

import java.util.List;

@Dao
public interface CharadaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Charada charada);

    @Query("SELECT * FROM charadas ORDER BY RANDOM()")
    LiveData<List<Charada>> getTodasCharadas();
}
