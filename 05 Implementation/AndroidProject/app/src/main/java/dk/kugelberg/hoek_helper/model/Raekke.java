package dk.kugelberg.hoek_helper.model;

public interface Raekke {

    DOMK getDOMK();

    GROMK getGROMK();

    KE getKE();

    KO getKO();

    SE getSE();

    STO getSTO();

    VE getVE();

    VO getVO();

    X getX();

    OMS getOMS();

    DB getDB();

    int getRaekkenummer();

    void setDOMK(DOMK domk);

    void setKO(KO ko);

    void setSE(SE se);

    void setSTO(STO sto);

    void setVE(VE ve);

    void setVO(VO vo);

    void setX(X x);

    void setKE(KE ke);

    void setGROMK(GROMK gromk);

    void setDB(DB db);

    void setOMS(OMS oms);

    void setRaekkenummer(int raekkenummer);


}
