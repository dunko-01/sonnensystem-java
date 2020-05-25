import GLOOP.*;

public class Sonnensystem {
    GLSchwenkkamera kamera;
    GLLicht licht;
    Erde erde;
    Sonne sonne;
    public Sonnensystem() {
        kamera = new GLSchwenkkamera();
        licht = new GLLicht();
        erde = new Erde();
        sonne = new Sonne();
    }
}
