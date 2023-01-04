import java.awt.*;

public class Case {
    Zone source, cible;
    Image img;

    public Case(Zone c, Image i){
        source = null;
        cible = c;
        img = i;
    }

    // les accesseurs : 
    public void setSource(Zone s){
        source = s;
    }

    public Zone getSource(){return(source);}

    // les méthodes :
    
    // Exercice 11 :
    public boolean isIn(int x, int y){
        int width = cible.getX2() - cible.getX1();
        int height = cible.getY2() - cible.getY1();
    
        return(cible.getX1() <= x && (cible.getX1() + width) >= x &&
               cible.getY1() <= y && (cible.getY1() + height) >= y);
        }


    public void trace(Graphics g, Component t){
        int width = cible.getX2() - cible.getX1();
        int height = cible.getY2() - cible.getY1();

        if(source == null){
            // on colorie la cible
            g.fillRect(cible.getX1(), cible.getY1(), cible.getX2() - cible.getX1(), cible.getY2() - cible.getY1());
        }else{
            // Pour faire le dessin
            g.drawImage(img, cible.getX1(), cible.getY1(), cible.getX2(), cible.getY2(),
                      source.getX1(), source.getY1(), source.getX2(), source.getY2(), t);
            // Pour le contour : 
            g.drawRect(cible.getX1(), cible.getY1(), width, height);
        }
    }
}
