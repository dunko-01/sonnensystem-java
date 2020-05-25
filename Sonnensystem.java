import GLOOP.*;

public class Sonnensystem {
    GLLicht licht;
    GLSchwenkkamera kamera;
    Erde erde;
    public Sonnensystem() {
        kamera = new GLSchwenkkamera();
        licht = new GLLicht();
        erde = new Erde();
    }
}
