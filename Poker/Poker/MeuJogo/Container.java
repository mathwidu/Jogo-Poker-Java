package MeuJogo;
import javax.swing.JFrame;
import MeuJogo.modelo.Jogo;

public class Container extends JFrame {
    public Container() {
        add(new Jogo());
        setTitle("meu jogo");
        setSize(1024, 728);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Container();
    }
    
}