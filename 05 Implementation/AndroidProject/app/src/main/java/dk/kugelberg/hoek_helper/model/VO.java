package dk.kugelberg.hoek_helper.model;


public interface VO {

    /* ****************************************************************************************
     * *********************************GETTERS AND SETTERS************************************
     * ***************************************************************************************/


    void setVaerdi(double vaerdi);
    double getVaerdi();
    void beregn();
    void init(VO vo1, VO vo2, STO sto, KO ko, VE ve, X x1, X x2, DOMK domk1, DOMK domk2);
    boolean erBeregnet();


    void beregn();



}
