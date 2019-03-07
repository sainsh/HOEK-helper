package dk.kugelberg.hoek_helper.model;


public interface DOMK {

    void setVaerdi(double vaerdi);
    double getVaerdi();
    void beregn();
    void init(VO vo, VO voOver, STO sto, KO ko, VE ve, X x, X xOver,DOMK domkOver ,DOMK domkUnder);
    void initOver(X xOver, VO voOver);
    void initUnder(DOMK domkUnder);
    boolean erBeregnet();


}
