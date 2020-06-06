import GLOOP.*;

public class Planetennamen {
    private GLTafel[] tafeln;
    public Planetennamen() {
        
        tafeln = new GLTafel[5];
        for(int i=0; i<5; i++) {
            tafeln[i] = new GLTafel     (0,0,0,96,36);
            tafeln[i].setzeSichtbarkeit (false);
            tafeln[i].setzeAutodrehung  (true);
            tafeln[i].setzeTextur       ("img/tafel.png");
            tafeln[i].setzeTextfarbe    (1,1,1);
        }
        
        setzeText   (0,"Sonne");
        setzeText   (1,"Erde");
        setzeText   (2,"Mars");
        setzeText   (3,"Jupiter");
        setzeText   (4,"Saturn");
    }
    
    private void setzeText(int pZ, String pName) {
        tafeln[pZ].setzeText    ("  "+pName,18);
    }
    
    public void positioniere(int pPlanetenZahl, GLVektor pPlanetenPos, int pR) {
        GLVektor position = new GLVektor    (32+pR,48,0);
        
        //  ((32+r,48,0)+pos,96,36);
        position.addiere                    (pPlanetenPos);
        tafeln[pPlanetenZahl].setzePosition (position);
    }
    public void machSichtbar(int pPlanetenZahl) {
        for(int i=0; i<5; i++) {
            tafeln[i].setzeSichtbarkeit (false);
        }
        tafeln[pPlanetenZahl].setzeSichtbarkeit (true);
    }
}