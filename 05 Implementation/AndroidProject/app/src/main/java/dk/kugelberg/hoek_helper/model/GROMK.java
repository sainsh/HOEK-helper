package dk.kugelberg.hoek_helper.model;

public interface GROMK extends Noegletal {

    void init(X x, STO sto);

    void initOver(X x, STO sto);

    void setVaerdi(double vaerdi);

    double getVaerdi();

    void beregn();

    void setBeregnet(boolean val);

    boolean getBeregnet();
}
