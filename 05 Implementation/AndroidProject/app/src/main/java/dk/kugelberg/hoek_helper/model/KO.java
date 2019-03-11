package dk.kugelberg.hoek_helper.model;

public interface KO extends Noegletal {

    void init(KE ke, X x, STO sto, VO vo);
    void initOver(X xOver, VO voOver);
    void initUnder(X xUnder, VO voUnder);

    void setVaerdi(double Vaerdi);
    double getVaerdi();

    void setBeregnet(boolean val);
    boolean getBeregnet();

    void beregn();

}