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

    void beregn();



}
