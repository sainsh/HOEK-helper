package dk.kugelberg.hoek_helper.model;

public interface X {

    void init(VO vo, VE ve, DOMK domk, STO sto, SE se, GROMK gromk,X xOver, VO voOver, X xUnder, VO voUnder, DOMK domkUnder);

    void setVaerdi(double x);
    double getVaerdi();

    void beregn();

    void setBeregnet(boolean val);
    boolean getBeregnet();



}
