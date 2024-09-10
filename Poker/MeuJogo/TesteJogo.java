package MeuJogo;
import MeuJogo.modelo.Baralho;
import MeuJogo.modelo.Carta;
import MeuJogo.modelo.Jogador;

public class TesteJogo {
    public static void main(String[] args) {
        Baralho baralho = new Baralho();

        Jogador jogador1 = new Jogador("Jogador 1");

        System.out.println("Número de cartas no baralho: " + baralho.getQuantidadeCartas());

        jogador1.receberCarta(baralho.distribuirCarta());
        jogador1.receberCarta(baralho.distribuirCarta());

        System.out.println(jogador1.getNome() + "Recebeu as seguintes cartas:");
        for(Carta carta : jogador1.getMao()){
            System.out.println(carta.getValor() + " De " + carta.getNaipe());
        }

        System.out.println("Número de cartas no baralho: " + baralho.getQuantidadeCartas());

    }    
}
