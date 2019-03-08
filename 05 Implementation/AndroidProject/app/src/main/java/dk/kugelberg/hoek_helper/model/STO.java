package dk.kugelberg.hoek_helper.model;

public interface STO extends Noegletal {

    void init(X x, VO vo, KO ko, SE se, GROMK gromk);
    void initOver(X xOver, VO voOver);
    void initUnder(X xUnder, VO voUnder);

    void setVaerdi(double x);

    double getVaerdi();

    void beregn();

    void setBeregnet(boolean val);

    boolean getBeregnet();


}
