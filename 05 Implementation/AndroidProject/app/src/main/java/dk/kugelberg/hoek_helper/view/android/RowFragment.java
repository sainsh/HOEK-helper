package dk.kugelberg.hoek_helper.view.android;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import dk.kugelberg.hoek_helper.R;
import dk.kugelberg.hoek_helper.model.DOMK;
import dk.kugelberg.hoek_helper.model.KE;
import dk.kugelberg.hoek_helper.model.KO;
import dk.kugelberg.hoek_helper.model.SE;
import dk.kugelberg.hoek_helper.model.STO;
import dk.kugelberg.hoek_helper.model.VE;
import dk.kugelberg.hoek_helper.model.VO;
import dk.kugelberg.hoek_helper.model.X;
import dk.kugelberg.hoek_helper.model.XImpl;
import dk.kugelberg.hoek_helper.view.viewmodel.Main;

public class RowFragment extends Fragment {




    //Værdierne bruges til at sætte objekternes værdi i model.
    //Objekterne oprettes først i model og derfor bruges primitive variable i view.
//    private double xRaw = Double.NaN;
//    private double vo = Double.NaN;
//    private double ve = Double.NaN;
//    private double domk = Double.NaN;
//    private double sto = Double.NaN;
//    private double se = Double.NaN;


    private Main viewModel;

    private X x;
    private X xOver;
    private X xUnder;
    private VO vo;
    private VO voOver;
    private VO voUnder;
    private VE ve;
    private SE se;
    private KE ke;
    private DOMK domk;
    private DOMK domkUnder;
    private KO ko;
    private STO sto;


    private EditText xEditText;
    private EditText voEditText;
    private EditText veEditText;
    private EditText domkEditText;

    private int raekkenummer;


    public RowFragment() {

        // Must be Empty

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Instantiate keynumbers
        x = viewModel.getRow(getRaekkenummer()).getX();
        vo = viewModel.getRow(getRaekkenummer()).getVO();
        ve = viewModel.getRow(getRaekkenummer()).getVE();
        se = viewModel.getRow(getRaekkenummer()).getSE();
        ke = viewModel.getRow(getRaekkenummer()).getKE();
        domk = viewModel.getRow(getRaekkenummer()).getDOMK();
        ko = viewModel.getRow(getRaekkenummer()).getKO();
        sto = viewModel.getRow(getRaekkenummer()).getSTO();



        // xEditText = getView().findViewById(R.id.x_text_view);
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_row, container, false);
        xEditText = v.findViewById(R.id.x_text_view);
        voEditText = v.findViewById(R.id.vo_text_view);
        veEditText = v.findViewById(R.id.ve_text_view);
        domkEditText = v.findViewById(R.id.domk_text_view);



        //xEditText.addTextChangedListener(xFieldWatcher);
        //voEditText.addTextChangedListener(voTextWatcher);



        xEditText.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // Hvis input felt ikke er tomt, sæt værdi til objekt
                if (!xEditText.getText().toString().equals("")){

                    double inputValue = Double.parseDouble(xEditText.getText().toString());
                    getX().setVaerdi(inputValue);
                    System.out.println("\n[++] RÆKKENUMMER: " + getRaekkenummer());
                }

            }
            public void afterTextChanged(Editable s) {

                // Skal kalde alle beregn metoder undtagen dens egen
                beregnVO();
                beregnVE();
                beregnDOMK();

            }
        });

        voEditText.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!voEditText.getText().toString().equals("")){

                    double inputValue = Double.parseDouble(voEditText.getText().toString());
                    getVo().setVaerdi(inputValue);
                    System.out.println("\n[++] RÆKKENUMMER: " + getRaekkenummer());
                }

            }
            public void afterTextChanged(Editable s) {

                // Skal kalde alle beregn metoder undtagen dens egen
                beregnVE();
                beregnDOMK();
                beregnX();

            }
        });

        veEditText.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                double inputValue = Double.parseDouble(veEditText.getText().toString());
                getVe().setVaerdi(inputValue);
                System.out.println("\n[++] RÆKKENUMMER: " + getRaekkenummer());
            }
            public void afterTextChanged(Editable s) {

                // Skal kalde alle beregn metoder undtagen dens egen
                beregnVO();
                beregnDOMK();
                beregnX();


            }
        });

        domkEditText.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                double inputValue = Double.parseDouble(domkEditText.getText().toString());
                getDomk().setVaerdi(inputValue);
                System.out.println("\n[++] RÆKKENUMMER: " + getRaekkenummer());
            }
            public void afterTextChanged(Editable s) {

                // Skal kalde alle beregn metoder undtagen dens egen
                beregnVO();
                beregnVE();
                beregnX();

            }
        });

        return v;
    }



    public void beregnX(){

        // Hent objekterne her og smid i init()

        //viewModel.getRow(this.raekkenummer).getxRaw().init();
    }

    public void beregnVO(){

        System.out.println("[+] BEREGN VO ER BLEBET KALDT!!");

        if (getVo().kanBeregnes(ve, x, ko, domk, sto, se)){
            System.out.println("[+++] JEG KAN GODT BEREGNES FRA MIN RÆKKE AF!");
            getVo().init(ve, x, ko, domk, sto, se);
            getVo().beregn();
            double calculatedValue = getVo().getVaerdi();
            voEditText.setText(Double.toString(calculatedValue));
        }

        // Hvis tabel str er større end det nummer vi har nu, så skal vi også tilføje at x kan udregnes fra værdier nedenunder
        else if (viewModel.getController().hentTabelStr()-1 > getRaekkenummer()){
            System.out.println("Prøver er beregne nedefra...");
            // Kan beregnes fra under?
            xUnder = viewModel.getRow(getRaekkenummer()+1).getX();
            voUnder = viewModel.getRow(getRaekkenummer()+1).getVO();
            domkUnder = viewModel.getRow(getRaekkenummer()+1).getDOMK();


            // Hvis kan beregnes nede fra, så gør det...
            if (getVo().kanBeregnesUnder(xUnder, voUnder, domkUnder)){
                getVo().initUnder(xUnder, voUnder, domkUnder);
                getVo().beregn();
                double calculatedValue = getVo().getVaerdi();
                voEditText.setText(Double.toString(calculatedValue));
            }
        }




    }

    public void beregnVE(){


        // Kan VE beregnes?
        if (getVe().kanBeregnes(vo, x, se, ke)){

            // Init VE
            getVe().init(vo, x, se, ke);
            // Beregn
            getVe().beregn();

            // Set VE felt til den beregnede værdi
            double calculatedValue = getVe().getVaerdi();
            veEditText.setText(Double.toString(calculatedValue));

        }

    }

    public void beregnDOMK(){

    }






    private int getRaekkenummer() {
        return raekkenummer;
    }

    protected void setRaekkenummer(int raekkenummer) {
        this.raekkenummer = raekkenummer;
    }

    private Main getViewModel() {
        return viewModel;
    }

    protected void setViewModel(Main viewModel) {
        this.viewModel = viewModel;
    }


    private X getX() {
        return x;
    }

    private void setX(X x) {
        this.x = x;
    }

    private VO getVo() {
        return vo;
    }

    private void setVo(VO vo) {
        this.vo = vo;
    }

    private VE getVe() {
        return ve;
    }

    private void setVe(VE ve) {
        this.ve = ve;
    }

    private SE getSe() {
        return se;
    }

    private void setSe(SE se) {
        this.se = se;
    }

    private KE getKe() {
        return ke;
    }

    private void setKe(KE ke) {
        this.ke = ke;
    }

    private DOMK getDomk() {
        return domk;
    }

    private void setDomk(DOMK domk) {
        this.domk = domk;
    }
}
