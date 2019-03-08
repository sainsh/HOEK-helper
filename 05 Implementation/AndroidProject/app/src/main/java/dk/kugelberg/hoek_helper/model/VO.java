package dk.kugelberg.hoek_helper.model;


public interface VO {

    void init(VE ve, X x, KO ko, DOMK domk, STO sto, SE se);
    void initOver(X xOver, VO voOver);
    void initUnder(X xUnder, VO voUnder, DOMK domkUnder);

    void setVaerdi(double vaerdi);

    double getVaerdi();

    void beregn();

    void setBeregnet(boolean val);

    boolean getBeregnet();


}
