package dk.kugelberg.hoek_helper.model;

public interface KO {

    void init(KE ke, X x, STO sto, VO vo);
    void init1(X x1, VO vo1);
    void init2(X x2, VO vo2);

    void setVaerdi(double Vaerdi);
    double getVaerdi();

    void setBeregnet(boolean val);
    boolean getBeregnet();

    void beregn();


}
