import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mystere extends JFrame implements MouseListener{
    Case plateau[][];
    Zone cible;

    public Mystere(){
        super("Un jeu");
        setBounds(200, 80, 600, 600);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addMouseListener(this);
        setVisible(true);

        // Exercice 5 : 
        Image image =Toolkit.getDefaultToolkit().getImage("fond.png"); // chargement de l'image
        //Zone cible = new Zone(100, 100, 200, 180);

        // valeur de vignette : 
        //vignette = new Case(cible, image);
        //vignette.setSource(new Zone(140, 120, 240, 200));

        // Exercice 7 :
        plateau = new Case[5][5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j <5; j++){
                plateau[i][j] = new Case(new Zone(100*i + 50, 100*j + 50, 100 * i + 150, 100 * j +150), image);
                // Exercice 8 :
                plateau[i][j].setSource(new Zone(100 * i, 100 * j, 100 * i + 100, 100 * j +100));
            }
        }
        // Exercice 10 : 
        plateau[4][4].setSource(null);
    }


    // Exercice 9 : 
    @Override
    public void paint(Graphics g){
        super.paint(g);
        //vignette.trace(g, this);
        for(int i = 0; i <5; i++){
            for(int j = 0; j <5; j++){
                plateau[i][j].trace(g, this);
            }
        }
    }

    // Exercice 13 : 
    public void swap(int i, int j){
        if(i >= 0 && j >= 0 && i <= 5 && j <= 5){
            if(plateau[i - 1][j].getSource() == null){
                plateau[i - 1][j].setSource(plateau[i][j].getSource());
                plateau[i][j].setSource(null);
            }else if( plateau[i + 1][j].getSource() == null){
                plateau[i + 1][j].setSource(plateau[i][j].getSource());
                plateau[i][j].setSource(null);
            }else if(plateau[i][j - 1].getSource() == null){
                plateau[i][j - 1].setSource(plateau[i][j].getSource());
                plateau[i][j].setSource(null);
            }else if(plateau[i][j + 1].getSource() == null){
                plateau[i][j + 1].setSource(plateau[i][j].getSource());
                plateau[i][j].setSource(null);
            }
        }
    }
    public static void main(String[] args){
        new Mystere();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        for(int i = 0; i < 5 ; i++){
            for(int j = 0; j <5; j++){
                if(plateau[i][j].isIn(x, y)){
                    plateau[i][j].setSource(null);
                    //swap(i, j);
                    repaint();
                    System.out.println("Cliker");
                }
            }
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

}
