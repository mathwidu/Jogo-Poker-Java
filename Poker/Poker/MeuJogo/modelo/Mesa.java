package MeuJogo.modelo;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private Baralho baralho;
    private List<Carta> cartasComunitarias;
    private List<Jogador> jogadores;
    private double pot;
    private double apostaMinima;
    private int posicaoDealer;

    public Mesa(List<Jogador> jogadores,double apostaMinima){
        this.baralho = new Baralho();
        this.cartasComunitarias = new ArrayList<>();
        this.jogadores = jogadores;
        this.pot = 0.0;
        this.posicaoDealer = 0;
    }

    public void definirBlinds() {
        int posicaoSB = (posicaoDealer + 1) % jogadores.size();
        int posicaoBB = (posicaoDealer + 2) % jogadores.size();
    
        Jogador smallBlind = jogadores.get(posicaoSB);
        Jogador bigBlind = jogadores.get(posicaoBB);
    
        double apostaSB = apostaMinima / 2;
        
        // Verificando fichas antes de deduzir o small blind
        if (smallBlind.getFichas() >= apostaSB) {
            smallBlind.setFichas(smallBlind.getFichas() - apostaSB);
            this.pot += apostaSB;
            System.out.println(smallBlind.getNome() + " pagou o small blind de " + apostaSB + " fichas.");
        } else {
            System.out.println(smallBlind.getNome() + " não tem fichas suficientes para o small blind.");
        }
    
        // Verificando fichas antes de deduzir o big blind
        if (bigBlind.getFichas() >= apostaMinima) {
            bigBlind.setFichas(bigBlind.getFichas() - apostaMinima);
            this.pot += apostaMinima;
            System.out.println(bigBlind.getNome() + " pagou o big blind de " + apostaMinima + " fichas.");
        } else {
            System.out.println(bigBlind.getNome() + " não tem fichas suficientes para o big blind.");
        }
    
        // Exibindo o valor do pote após a definição dos blinds
        System.out.println("Valor do pote atual: " + pot);
    }
    

    public void iniciarRodada(){
        for(Jogador jogador : jogadores){
            jogador.receberCarta(baralho.distribuirCarta());
            jogador.receberCarta(baralho.distribuirCarta());
        }

        exibirCartasJogadores();
    }

    public void rodadaApostas() {
        for (Jogador jogador : jogadores) {
            if (jogador.isEstaNaMao()) { // Verifica se o jogador está na mão antes de pedir uma ação
                jogador.escolherAcao(apostaMinima, apostaMinima);
            } else {
                System.out.println(jogador.getNome() + " está fora da mão.");
            }
        }
    }
    

    public void realizarFlop(){
        for (int i=0; i<3; i++) {
            cartasComunitarias.add(baralho.distribuirCarta());
        }
        System.out.println("Flop: " + cartasComunitarias);
    }

    public void realizarTurn(){
        cartasComunitarias.add(baralho.distribuirCarta());
        System.out.println("Turn: " + cartasComunitarias);
    }

    public void realizarRiver(){
        cartasComunitarias.add(baralho.distribuirCarta());
        System.out.println("River" + cartasComunitarias);
    }

    public void exibirCartasJogadores(){
        for(Jogador jogador : jogadores){
            System.out.println(jogador.getNome() + " tem" + jogador.getMao());
        }
    }

    public void adicionarAoPot(double valor){
        pot += valor;
    }

    public double getPot(){
        return pot;
    }
}
