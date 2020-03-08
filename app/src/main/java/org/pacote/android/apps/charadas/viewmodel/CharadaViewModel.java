package org.pacote.android.apps.charadas.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.pacote.android.apps.charadas.models.DataRepository;
import org.pacote.android.apps.charadas.models.entities.Charada;

import java.util.List;

public class CharadaViewModel extends AndroidViewModel {
    private DataRepository dataRepository;
    private LiveData<List<Charada>> todasCharadas;
    private int posicaoAtual = 0;

    public CharadaViewModel(@NonNull Application application) {
        super(application);
        dataRepository = new DataRepository(application);
        todasCharadas = dataRepository.getTodasCharadas();
    }

    public LiveData<List<Charada>> getTodasCharadas() {
        return todasCharadas;
    }

    public int getPosicaoAtual() {
        return posicaoAtual;
    }

    public void setPosicaoAtual(@NonNull int posicaoAtual) {
        this.posicaoAtual = posicaoAtual;
    }
}
