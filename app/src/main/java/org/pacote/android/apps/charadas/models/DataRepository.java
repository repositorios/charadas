package org.pacote.android.apps.charadas.models;

import android.app.Application;

import androidx.lifecycle.LiveData;

import org.pacote.android.apps.charadas.models.dao.CharadaDao;
import org.pacote.android.apps.charadas.models.entities.Charada;

import java.util.List;

public class DataRepository {
    private CharadaDao charadaDao;
    private LiveData<List<Charada>> todasCharadas;


    public DataRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        charadaDao = db.charadaDao();
        todasCharadas = charadaDao.getTodasCharadas();
    }

    public LiveData<List<Charada>> getTodasCharadas() {
        return todasCharadas;
    }

    void insert(final Charada charada) {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                charadaDao.insert(charada);
            }
        });
    }
}
