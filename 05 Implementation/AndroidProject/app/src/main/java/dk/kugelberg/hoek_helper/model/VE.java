package dk.kugelberg.hoek_helper.model;

public interface VE extends Noegletal {

    void init(VO vo, X x, SE se, KE ke);

    boolean kanBeregnes(VO vo, X x, SE se, KE ke);

    void setVaerdi(double x);
    double getVaerdi();

    void setBeregnet(boolean val);
    boolean getBeregnet();

    void beregn();


}
