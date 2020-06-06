import GLOOP.*;

public class Mond {
    private Sonne   sonne;
    private Planet  erde;
    private GLVektor mittelpunkt;
    
    private GLKugel mond;
    public Mond (Sonne pSonne, Planet pErde) {
        sonne = pSonne;
        erde = pErde;
        mittelpunkt = new GLVektor(erde.gibMittelpunkt().gibX()+32,0,0);
        
        mond = new GLKugel  (mittelpunkt,8,"img/moon.png");
        mond.drehe          (-90,0,0);
    }
    
    public void dreheUmSelbst(int pW) {
        mond.drehe          (0,pW,0,mittelpunkt);
    }
    public void dreheUmErde(int pW) {
        mond.drehe          (0,pW,0,erde.gibMittelpunkt());
    }
    public void dreheUmSonne(int pW) {
        mond.drehe          (0,pW,0,sonne.gibMittelpunkt());
        dreheMittelpunkt    (pW);
    }
    
    public void dreheMittelpunkt(int pW) {
        mittelpunkt.rotiere (pW,0,1,0);
    }
    public GLVektor gibMittelpunkt() {
        return mittelpunkt;
    }
}