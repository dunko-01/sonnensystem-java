import GLOOP.*;

public class Mond {
    GLKugel mond;
    public Mond () {
        mond = new GLKugel(292,36,0,8,"img/moon.png");
        mond.drehe(-90,0,0);
    }
}
