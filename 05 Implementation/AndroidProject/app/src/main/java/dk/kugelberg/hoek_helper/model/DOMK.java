package dk.kugelberg.hoek_helper.model;


public interface DOMK extends Noegletal {

    void setVaerdi(double x);
    double getVaerdi();
    void beregn();
    void setBeregnet(boolean val);
    boolean getBeregnet();
    void init(VO vo, STO sto, KO ko, VE ve, X x, DOMK domk);
    void initOver(VO voOver, X xOver, DOMK domkOver);
    boolean erBeregnet();


}
