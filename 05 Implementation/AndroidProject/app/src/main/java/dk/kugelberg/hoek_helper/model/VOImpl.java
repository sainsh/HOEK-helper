package dk.kugelberg.hoek_helper.model;

public class VOImpl implements VO {


    private double vaerdi = Double.NaN;
    private boolean erBeregnet = false;

    public VOImpl()
    {

    }



    @Override
    public void setVaerdi(double vaerdi)
    {
        if(vaerdi<0)
        {
            throw new VaerdiException();
        else {
            this.vaerdi = vaerdi;
            erBeregnet=false;
        }
    }

    @Override
    public void beregn()
    {






        //this.vaerdi = x;
    }

    @Override
    public double getVaerdi() {
        if (vaerdi == Double.NaN)
            beregn();
        return vaerdi;
    }
}
