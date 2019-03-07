package dk.kugelberg.hoek_helper.model;

public interface STO {

    void init(X x, VO vo, KO ko, SE se);
    void init1(X x1, VO vo1);
    void init2(X x2, VO vo2);

    void setVaerdi(double x);

    double getVaerdi();

    void beregn();

    void setBeregnet(boolean val);

    boolean getBeregnet();


}
