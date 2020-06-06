import GLOOP.*;

public class Sonnensystem {
    private GLSchwenkkamera kamera;
    private GLTastatur taste;
    private GLMaus maus;
    private GLHimmel weltall;
    
    private Sonne sonne;
    
    private Planet[] planeten;
    
    private Mond mond;
    private GLZylinder saturnsPlanetenRing;
    
    private Planetennamen planetennamen;
    
    private int planetenZahl;
    public Sonnensystem() {
        kamera = new GLSchwenkkamera();
        taste = new GLTastatur      ();
        maus = new GLMaus           ();
        weltall = new GLHimmel      ("img/space.png");
        
        sonne = new Sonne   ();
        
        planeten = new Planet[4];
        for(int i=0; i<4; i++) {
            planeten[i] = new Planet    (512+i*256,sonne);
        }
        
        //  Erde und Mond
        planeten[0].setzeEigenschaften  (24, "img/earth.png", -23.5);
        mond = new Mond                 (sonne, planeten[0]);        
        //  Mars
        planeten[1].setzeEigenschaften  (18, "img/mars.png", -25.19);        
        //  Jupiter
        planeten[2].setzeEigenschaften  (64, "img/jupiter.png", -3.13);
        //  Saturn und Planetenring
        planeten[3].setzeEigenschaften  (40, "img/saturn.png", -26.73);
        saturnsPlanetenRing = new GLZylinder (planeten[3].gibMittelpunkt(),64,0.2,"img/saturn-ring.png");
        saturnsPlanetenRing.drehe            (90,0,-26.73);
        
        planetennamen = new Planetennamen   ();
        
        starte      ();
        Sys.beenden ();
    }
    
    private void starte() {
        int planetenZahl = 0;
        
        GLVektor kameraPosition = new GLVektor  (0,192,0);
        kameraPosition.addiere                  (kamera.gibPosition());
        kamera.setzePosition                    (kameraPosition);
        while(!taste.esc()) {
            sonne.dreheUmSelbst         (2);
            
            //  drehe alle Planeten um die Sonne und um sich selbst
            for(int i=1; i<5; i++) {
                double d = i;
                double winkelGeschwindikkeit = 1/d;
                planeten[i-1].dreheUmSonne  (winkelGeschwindikkeit);
                planeten[i-1].dreheUmSelbst (3);
                if(i==4) {
                    dreheSaturnsPlanetenRingUmSonne(winkelGeschwindikkeit);
                }
            }
            
            mond.dreheUmSonne           (1);
            mond.dreheUmErde            (3);
            //mond.dreheUmSelbst  (2);
            
            /*if(kamera.gibBlickpunkt()!=sonne.gibMittelpunkt()) {
                dreheKameraUmSonne();
            }*/
            
            planetenWechsel();
            
            //  ≈30Hz
            Sys.warte           (1000/30);
        }
    }
    
    private void dreheSaturnsPlanetenRingUmSonne(double pW) {
        saturnsPlanetenRing.drehe    (0,pW,0,sonne.gibMittelpunkt());
    }
    
    private void planetenWechsel() {
        if(taste.rechts() || maus.doppelklick()) {
            if  (planetenZahl == 4){
                planetenZahl = 0;
            } else {
                planetenZahl++;
            }
        } else if(taste.links()) {
            if (planetenZahl == 0){
                planetenZahl = 4;
            } else {
                planetenZahl--;
            }
        }
        setzeNeueTafelUndBlickpunkt();
    }
    
    private void setzeNeueTafelUndBlickpunkt() {
        if (planetenZahl == 0 ) {
            kamera.setzeBlickpunkt      (sonne.gibMittelpunkt());
            planetennamen.positioniere  (planetenZahl,sonne.gibMittelpunkt(),sonne.gibRadius());
        } else {
            Planet b = planeten[planetenZahl-1];
            kamera.setzeBlickpunkt      (b.gibMittelpunkt());
            planetennamen.positioniere  (planetenZahl,b.gibMittelpunkt(),b.gibRadius());
        }
        
        planetennamen.machSichtbar  (planetenZahl);
    }
}