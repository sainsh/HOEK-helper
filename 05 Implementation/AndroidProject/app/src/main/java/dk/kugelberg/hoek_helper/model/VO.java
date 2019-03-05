package dk.kugelberg.hoek_helper.model;


public interface VO {

    void init(VE ve, X x, KO ko, DOMK domk, STO sto, SE se);
    void init1(X x1, VO vo1);
    void init2(X x2, VO vo2, DOMK domk2);

    void setVaerdi(double vaerdi);

    double getVaerdi();

    void beregn();

    void setBeregnet(boolean val);

    boolean getBeregnet();


}
