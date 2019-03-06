package dk.kugelberg.hoek_helper.model;

interface Raekke {

    DOMK getDOMK();

    GROMK getGROMK();

    KE getKE();

    KO getKO();

    SE getSE();

    STO getSTO();

    VE getVE();

    VO getVO();

    X getX();

    int getRaekkenummer();

    void setDOMK(DOMK domk);

    void setKO(KO ko);

    void setSE(SE se);

    void setSTO(STO sto);

    void setVE(VE ve);

    void setVO(VO vo);

    void setX(X x);

    void setRaekkenummer(int raekkenummer);


}
