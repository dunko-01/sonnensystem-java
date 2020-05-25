import GLOOP.*;

public class Sonne {
    GLKugel sonne;
    GLLicht sonnenlicht;
    public Sonne() {
        sonne = new GLKugel(0,0,0,96,"img/sun.png");
        sonne.drehe(-90,0,0);
        sonne.setzeSelbstleuchten(1,1,1);
        sonnenlicht = new GLLicht(64,0,0);
        sonnenlicht.setzeGlanzlicht(1,1,1);
    }
}
