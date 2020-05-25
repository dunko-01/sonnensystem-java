import GLOOP.*;

public class Sonnensystem {
    GLSchwenkkamera kamera;
    GLHimmel weltall;
    
    Sonne sonne;
    Erde erde;
    Mond mond;
    public Sonnensystem() {
        kamera = new GLSchwenkkamera();
        
        sonne = new Sonne();
        erde = new Erde();
        mond = new Mond();
        
        weltall = new GLHimmel("img/space.png");
    }
}
