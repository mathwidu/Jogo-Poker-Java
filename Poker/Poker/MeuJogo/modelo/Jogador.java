package MeuJogo.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogador {
    private String nome;
    private double fichas;
    private List<Carta> mao;
    private boolean estaNaMao;
    
    public Jogador(String nome, double fichas){
        this.nome = nome;
        this.fichas = fichas;
        this.mao = new ArrayList<>();
        estaNaMao = true;
    }

    public void receberCarta(Carta carta){
        mao.add(carta);
    }

    public void escolherAcao(double apostaAtual, double apostaMinima){
        if (!estaNaMao) { 
            System.out.println(nome + " já está fora da mão.");
            return;
        }
        
        Scanner scanner = new Scanner(System.in);

        System.out.println(nome + ", escolha sua ação:");
        System.out.println("1 - Fold (Desistir)");
        System.out.println("2 - Check (Passar)");
        System.out.println("3 - Call (Pagar): " + apostaAtual + " fichas");
        System.out.println("4 - Raise (Aumentar)");

        int acao = scanner.nextInt();
        switch (acao) {
            case 1:
                estaNaMao = false;
                System.out.println(nome + " desistiu.");
                break;
        
            case 2:
                System.out.println(nome + " passou.");
                break;
            case 3:
                if(fichas >= apostaAtual){
                    fichas -= apostaAtual;
                    System.out.println(nome + " pagou " + apostaAtual + " fichas.");
                } else {
                    System.out.println(nome + " não tem fichas o suficiente para pagar.");
                }
                break;
            case 4: 
                System.out.println("Digite o valor do raise: ");
                double raise = scanner.nextInt();
                if(fichas >= raise + apostaAtual){
                    fichas -= (apostaAtual + raise);
                    System.out.println(nome + " aumentou a aposta para " + (apostaAtual+raise));
                } else {
                    System.out.println("Fichas insufientes para raise");
                }
                break;
            default:
            System.out.println("Escolha invalida. Tente novamente.");
            escolherAcao(apostaAtual, apostaMinima);
            scanner.close();
        }
    }

    public List<Carta> getMao(){
        return mao;
    }

    public String getNome(){
        return nome;
    }

    public boolean isEstaNaMao() {
        return estaNaMao;
    }

    public void setEstaNaMao(boolean estaNaMao) {
        this.estaNaMao = estaNaMao;
    }

    public double getFichas() {
        return fichas;
    }

    public void setFichas(double fichas) {
        this.fichas = fichas;
    }

    
}
