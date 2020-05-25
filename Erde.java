import GLOOP.*;

public class Erde {
    GLKugel erde;
    public Erde() {
        erde = new GLKugel(256,0,0,24,"img/earth.png");
        erde.drehe(-90,0,-23.5);
    }
}
