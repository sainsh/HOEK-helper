package dk.kugelberg.hoek_helper.model;

public interface STO {

    void init(X x, VO vo, KO ko, SE se, GROMK gromk, X xOver, VO voOver, X xUnder, VO voUnder);

    void setVaerdi(double x);

    double getVaerdi();

    void beregn();

    void setBeregnet(boolean val);

    boolean getBeregnet();


}
