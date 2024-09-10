package MeuJogo.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import MeuJogo.modelo.Carta.Naipe;
import MeuJogo.modelo.Carta.Valor;

public class Baralho{
    private List<Carta> cartas;

    public Baralho(){
        cartas = new ArrayList<>();
        for(Naipe naipe: Naipe.values()){
            for(Valor valor: Valor.values()){
                cartas.add(new Carta(naipe, valor));
            }
        }
        Collections.shuffle(cartas);
    }

    public Carta distribuirCarta(){
        if(!cartas.isEmpty()){
            return cartas.remove(0);
        }
        return null;
    }

    public int getQuantidadeCartas(){
        return cartas.size();
    }

}