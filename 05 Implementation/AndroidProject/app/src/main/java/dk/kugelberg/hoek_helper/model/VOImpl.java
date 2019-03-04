package dk.kugelberg.hoek_helper.model;

public class VOImpl implements VO
{
    VO v;


    private double vaerdi = Double.NaN;
    private boolean erBeregnet = false;

    public VOImpl()
    {

    }

    //Beregner denne formel VO = VE * X
    @Override
    public void beregnVoMedVeOgX(double ve,double x)
    {
        double resultat=ve*x;

        this.vaerdi=resultat;
        erBeregnet=true;

    }

    @Override
    //Beregner denne formel VO = STO - KO
    public void beregnVoMedStoko(double sto,double ko )
    {
        double resultat=sto-ko;
        this.vaerdi=resultat;
        erBeregnet=true;
    }

    @Override
    //Beregn denne formel VO = 1/100*X^2+100*X
    public void berengVoMed1100x2100x(double x)
    {
        double resultat= 1/100*Math.pow(x,2)+100*x;
        this.vaerdi=resultat;
        erBeregnet=true;
    }

    @Override
    //Beregn denne formel VO = DB - Oms
    public void berengVoMedDbMinusOms(double db,double oms)
    {
        double resultat=db-oms;
        this.vaerdi=resultat;
        erBeregnet=true;
    }



    @Override
    public void setVaerdi(double vaerdi)
    {
        if(vaerdi<0) {
            throw new VaerdiException();
        }
        else {
            this.vaerdi = vaerdi;
            erBeregnet=false;
        }
    }


    @Override
    public double getVaerdi()
    {
        return vaerdi;
    }
}
