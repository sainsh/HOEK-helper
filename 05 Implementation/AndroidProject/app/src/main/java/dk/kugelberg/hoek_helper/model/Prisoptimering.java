package dk.kugelberg.hoek_helper.model;

public interface Prisoptimering {
    void init(VE ve, X x, KO ko, DOMK domk, STO sto, SE se);
    void initOver(X x1, VO vo1);
    void initUnder(X x2, VO vo2, DOMK domk2);

    void setVaerdi(double vaerdi);

    double getVaerdi();

    void beregn();

    void setBeregnet(boolean val);

    boolean getBeregnet();

}
