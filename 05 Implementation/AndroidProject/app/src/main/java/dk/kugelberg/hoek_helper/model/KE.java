package dk.kugelberg.hoek_helper.model;

public interface KE {

    void init(KO ko, X x, SE se, VE ve);

    void setVaerdi(double Vaerdi);
    double getVaerdi();

    void setBeregnet(boolean val);
    boolean getBeregnet();

}
