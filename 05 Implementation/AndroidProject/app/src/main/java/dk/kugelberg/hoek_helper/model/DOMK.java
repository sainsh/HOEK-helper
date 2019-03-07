package dk.kugelberg.hoek_helper.model;


public interface DOMK {

    void setVaerdi(double x);
    double getVaerdi();
    void beregn();
    void setBeregnet(boolean val);
    boolean getBeregnet();
    void init(VO vo, VO voOver, STO sto, KO ko, VE ve, X x, X xOver, DOMK domk, DOMK domkOver);
    boolean erBeregnet();
    void initOver(VO voOver,X xOver, DOMK domkOver);


}
