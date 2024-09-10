package MeuJogo.modelo;

public class Carta{
    private Naipe naipe;
    private Valor valor;

    public Carta(Naipe naipe, Valor valor){
        this.naipe = naipe;
        this.valor = valor;
    }

    public Naipe getNaipe() {
        return naipe;
    }

    public Valor getValor() {
        return valor;
    }

// Enum para definir os naipes do baralho
public enum Naipe {
    COPAS, OUROS, PAUS, ESPADAS;
}

// Enum para definir os valores das cartas
public enum Valor {
    DOIS, TRES, QUATRO, CINCO, SEIS, SETE, OITO, NOVE, DEZ, VALETE, DAMA, REI, AS;
}

}