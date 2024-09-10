package MeuJogo.modelo;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private List<Carta> mao;

    public Jogador(String nome){
        this.nome = nome;
        this.mao = new ArrayList<>();
    }

    public void receberCarta(Carta carta){
        mao.add(carta);
    }

    public List<Carta> getMao(){
        return mao;
    }

    public String getNome(){
        return nome;
    }
}
