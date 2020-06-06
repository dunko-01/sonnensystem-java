import GLOOP.*;

public class Planet {
    private Sonne       sonne;
    private GLVektor    mittelpunkt;
    private int radius;
    private double neigung;
    
    private GLKugel      planet;
    public Planet(int pX, Sonne pSonne) {
        sonne = pSonne;
        mittelpunkt = new GLVektor(pX,0,0);
        
        planet = new GLKugel(mittelpunkt,1);
        planet.drehe        (-90,0,0);
    }
    
    public void setzeEigenschaften(int pGroesse, String pTextur, double pNeigung) {
        planet.skaliere     (pGroesse);
        planet.setzeTextur  (pTextur);
        planet.drehe        (0,0,pNeigung);
        
        radius = pGroesse;
        neigung = pNeigung;
    }
    
    public void dreheUmSelbst(int pw) {
        planet.drehe        (0,0,-neigung);
        planet.drehe        (0,2,0,mittelpunkt);
        planet.drehe        (0,0,neigung);
    }
    public void dreheUmSonne(double pW) {
        planet.drehe        (0,pW,0,sonne.gibMittelpunkt());
        dreheMittelpunkt    (pW);
    }
    
    public void dreheMittelpunkt(double pW) {
        mittelpunkt.drehe   (0,pW,0);
    }
    public GLVektor gibMittelpunkt() {
        return mittelpunkt;
    }
    public int gibRadius() {
        return radius;
    }
}