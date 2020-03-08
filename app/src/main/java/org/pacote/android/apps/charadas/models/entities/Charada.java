package org.pacote.android.apps.charadas.models.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "charadas")
public class Charada {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @NonNull
    @ColumnInfo(name = "pergunta")
    private String pergunta;

    @NonNull
    @ColumnInfo(name = "resposta")
    private String resposta;

    public Charada(@NonNull String pergunta, @NonNull String resposta) {
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @NonNull
    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(@NonNull String pergunta) {
        this.pergunta = pergunta;
    }

    @NonNull
    public String getResposta() {
        return resposta;
    }

    public void setResposta(@NonNull String resposta) {
        this.resposta = resposta;
    }
}
