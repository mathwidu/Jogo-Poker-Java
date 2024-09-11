package MeuJogo;
import java.util.ArrayList;
import java.util.List;
import MeuJogo.modelo.Baralho;
import MeuJogo.modelo.Carta;
import MeuJogo.modelo.Jogador;
import MeuJogo.modelo.Mesa;

public class TesteJogo {
    public static void main(String[] args) {
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador("jogador 1", 100.00));
        jogadores.add(new Jogador("jogador 2", 100.00));
        jogadores.add(new Jogador("jogador 3", 100.00));
        jogadores.add(new Jogador("jogador 4", 100.00));
        jogadores.add(new Jogador("jogador 5", 100.00));
        jogadores.add(new Jogador("jogador 6", 100.00));
        
        Mesa mesa = new Mesa(jogadores, 20.00);
        
        mesa.iniciarRodada();
        mesa.definirBlinds();

        System.out.println("Valor do pote atual" + mesa.getPot());
        mesa.rodadaApostas();

        mesa.realizarFlop();
        System.out.println("Valor do pote atual" + mesa.getPot());
        mesa.rodadaApostas();

        mesa.realizarTurn();
        System.out.println("Valor do pote atual" + mesa.getPot());
        mesa.rodadaApostas();

        mesa.realizarRiver();
        System.out.println("Valor do pote atual" + mesa.getPot());
        mesa.rodadaApostas();

        System.out.println("Valor final do pote: 1" + mesa.getPot());

    }    
}
