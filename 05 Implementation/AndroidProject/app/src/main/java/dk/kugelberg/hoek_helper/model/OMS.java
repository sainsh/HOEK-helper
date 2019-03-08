package dk.kugelberg.hoek_helper.model;

public interface OMS extends Noegletal {
    void init(VE ve, X x, KO ko, DOMK domk, STO sto, SE se, X xOver, VO voOver, X xUnder, VO voUnder, DOMK domkUnder);

    void setVaerdi(double vaerdi);

    double getVaerdi();

    void beregn();

    void setBeregnet(boolean val);

    boolean getBeregnet();
}
