package dk.kugelberg.hoek_helper.model;

public interface VE {

    void init(VO vo, X x, SE se, KE ke);

    void setVaerdi(double x);
    double getVaerdi();

    void setBeregnet(boolean val);
    boolean getBeregnet();

    void beregn();


}
