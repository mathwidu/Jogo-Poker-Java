package MeuJogo.modelo;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Event;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Jogo extends JPanel implements ActionListener{
    private Image fundo;

    public Jogo(){
        ImageIcon referencia = new ImageIcon("res\\Background.png");
        fundo = referencia.getImage();
        
    }

    public void paint (Graphics g){
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);
        g.dispose();
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    
    }   
}
