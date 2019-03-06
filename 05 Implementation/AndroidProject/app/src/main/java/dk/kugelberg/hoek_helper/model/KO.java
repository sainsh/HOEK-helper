package dk.kugelberg.hoek_helper.model;

public interface KO {

    void init(KE ke, X x, STO sto, VO vo, X xOver, VO voOver, X xUnder, VO voUnder);

    void setVaerdi(double Vaerdi);
    double getVaerdi();

    void setBeregnet(boolean val);
    boolean getBeregnet();

    void beregn();

}