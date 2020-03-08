package org.pacote.android.apps.charadas.views.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.pacote.android.apps.charadas.databinding.ActivityMainBinding;
import org.pacote.android.apps.charadas.models.entities.Charada;
import org.pacote.android.apps.charadas.viewmodel.CharadaViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private CharadaViewModel charadaViewModel;
    private List<Charada> todasCharadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // View Binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        charadaViewModel = new ViewModelProvider(this).get(CharadaViewModel.class);

        charadaViewModel.getTodasCharadas().observe(this, new Observer<List<Charada>>() {
            @Override
            public void onChanged(@Nullable final List<Charada> charadas) {
                todasCharadas = charadas;
                atualizaPergunta();
            }
        });

    }

    public void onClickExibirResposta(View view) {
        binding.resposta.setVisibility(View.VISIBLE);

        binding.exibirResposta.setVisibility(View.INVISIBLE);
        binding.compartilhar.setVisibility(View.VISIBLE);
        binding.proxima.setVisibility(View.VISIBLE);


    }

    public void onClickProximaCharada(View view) {
        binding.resposta.setVisibility(View.INVISIBLE);

        binding.exibirResposta.setVisibility(View.VISIBLE);
        binding.compartilhar.setVisibility(View.INVISIBLE);
        binding.proxima.setVisibility(View.INVISIBLE);

        atualizaPosicaoAtual();
        atualizaPergunta();

    }

    public void onClickCompartilharCharada(View view) {

        String msg = "P: " + todasCharadas.get(charadaViewModel.getPosicaoAtual()).getPergunta();
        msg += " R: " + todasCharadas.get(charadaViewModel.getPosicaoAtual()).getResposta();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);

        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, msg);
        startActivity(Intent.createChooser(intent, "Compartilhe"));
    }

    private void atualizaPosicaoAtual() {
        if (charadaViewModel.getPosicaoAtual() <= todasCharadas.size()) {
            charadaViewModel.setPosicaoAtual(charadaViewModel.getPosicaoAtual() + 1);
        } else {
            charadaViewModel.setPosicaoAtual(0);
        }
    }

    private void atualizaPergunta() {
        binding.charada.setText(todasCharadas.get(charadaViewModel.getPosicaoAtual()).getPergunta());
        binding.resposta.setText(todasCharadas.get(charadaViewModel.getPosicaoAtual()).getResposta());
    }


}
