package dk.kugelberg.hoek_helper.model;


public interface VO {

    /* ****************************************************************************************
     * *********************************GETTERS AND SETTERS************************************
     * ***************************************************************************************/


    /**
     * Sætter variablen vaerdi til værdien angivet som argument.
     * @param vaerdi
     */
    void setVaerdi(double vaerdi);

    /**
     * Returnerer værdien af variablen vaerdi.
     * @return
     */
    double getVaerdi();

    //void beregn();

    void beregnVoMedVeOgX(double ve,double x);
    void beregnVoMedStoko(double sto,double ko );
    void berengVoMed1100x2100x(double x);
    void berengVoMedDbMinusOms(double db,double oms);



}
