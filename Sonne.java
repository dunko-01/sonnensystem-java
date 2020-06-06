import GLOOP.*;

public class Sonne {
    private GLVektor mittelpunkt;
    private int radius;
    
    private GLKugel sonne;
    private GLLicht sonnenlicht;
    public Sonne() {
        mittelpunkt = new GLVektor  (0,0,0);
        radius = 128;
        
        sonne = new GLKugel         (mittelpunkt,radius,"img/sun.png");
        sonne.drehe                 (-90,0,0);
        sonne.setzeSelbstleuchten   (1,1,1);
        
        sonnenlicht = new GLLicht   (64,0,0);
        sonnenlicht.setzeGlanzlicht (1,1,1);
    }
    
    public void dreheUmSelbst(int pw) {
        sonne.drehe (0,pw,0,0,0,0);
    }
    
    public GLVektor gibMittelpunkt() {
        return mittelpunkt;
    }
    public int gibRadius() {
        return radius;
    }
}