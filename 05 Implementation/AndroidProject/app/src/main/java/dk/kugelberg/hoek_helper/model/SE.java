package dk.kugelberg.hoek_helper.model;

public interface SE {

    void init(VO vo, VE ve, DOMK domk, STO sto, SE se);

    void setVaerdi(double x);

    double getVaerdi();

    void beregn();

    void setBeregnet(boolean val);

    boolean getBeregnet();
}
