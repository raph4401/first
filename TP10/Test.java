import java.awt.*;
import javax.swing.*;

public class Test extends JFrame {
    Case vignette;

    public Test(){
        super("Je vous vois");
        setBounds(200, 80, 600, 600);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        

        // Exercice 5 : 
        Image image =Toolkit.getDefaultToolkit().getImage("moi.jpg"); // chargement de l'image
        Zone cible = new Zone(100, 100, 200, 180);

        // valeur de vignette : 
        vignette = new Case(cible, image);
        vignette.setSource(new Zone(140, 120, 240, 200));
        setVisible(true);
    }

    @Override
    public void paint(Graphics g){
        vignette.trace(g, this);
    }

    public static void main(String[] args){
        new Test();
    }
}
