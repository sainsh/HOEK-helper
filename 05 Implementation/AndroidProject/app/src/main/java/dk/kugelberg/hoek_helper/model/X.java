package dk.kugelberg.hoek_helper.model;

public interface X {

    void init(VO vo, VE ve, DOMK domk, STO sto, SE se, GROMK gromk);
    void init1(X x1, VO vo1);
    void init2(X x2, VO vo2, DOMK domk2);

    void setVaerdi(double x);
    double getVaerdi();

    void beregn();

    void setBeregnet(boolean val);
    boolean getBeregnet();



}
