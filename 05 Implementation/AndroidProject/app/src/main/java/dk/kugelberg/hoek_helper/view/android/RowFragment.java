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
import dk.kugelberg.hoek_helper.model.KE;
import dk.kugelberg.hoek_helper.model.SE;
import dk.kugelberg.hoek_helper.model.VO;
import dk.kugelberg.hoek_helper.model.X;
import dk.kugelberg.hoek_helper.view.viewmodel.Main;

/**
 * A simple {@link Fragment} subclass.
 */
public class RowFragment extends Fragment {




    //Værdierne bruges til at sætte objekternes værdi i model.
    //Objekterne oprettes først i model og derfor bruges primitive variable i view.
    private double x = Double.NaN;
    private double vo = Double.NaN;
    private double ve = Double.NaN;
    private double domk = Double.NaN;
    private double sto = Double.NaN;
    private double se = Double.NaN;


    private EditText xEditText;
    private EditText voEditText;
    private EditText veEditText;
    private EditText domkEditText;

    private int raekkenummer;

    private Main viewModel;

    public RowFragment() {

        // Required empty public constructor

        // Create new row in tabel

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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
                // Set X value
                if (!xEditText.getText().toString().equals("")){
                    setX(Double.parseDouble(xEditText.getText().toString()));
                    viewModel.getRow(getRaekkenummer()).getX().setVaerdi(getX());
                    System.out.println("\n[++] RÆKKENUMMER: " + getRaekkenummer());
                }

            }
            public void afterTextChanged(Editable s) {

                // Skal kalde alle beregn metoder
                beregnVE();



            }
        });

        voEditText.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!voEditText.getText().toString().equals("")){
                    // Set VO value
                    setVo(Double.parseDouble(voEditText.getText().toString()));
                    viewModel.getRow(getRaekkenummer()).getVO().setVaerdi(getVo());
                    System.out.println("\n[++] RÆKKENUMMER: " + getRaekkenummer());
                }

            }
            public void afterTextChanged(Editable s) {

                // Skal kalde alle beregn metoder
                beregnVE();

            }
        });

        veEditText.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Set VE value
                setVe(Double.parseDouble(veEditText.getText().toString()));
                viewModel.getRow(getRaekkenummer()).getVE().setVaerdi(getVe());
                System.out.println("\n[++] RÆKKENUMMER: " + getRaekkenummer());
            }
            public void afterTextChanged(Editable s) {



            }
        });

        domkEditText.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Set DOMK value
                setDomk(Double.parseDouble(domkEditText.getText().toString()));
                viewModel.getRow(getRaekkenummer()).getDOMK().setVaerdi(getDomk());
                System.out.println("\n[++] RÆKKENUMMER: " + getRaekkenummer());
            }
            public void afterTextChanged(Editable s) {

            }
        });





        return v;
    }


    public void beregnX(){

        // Hent objekterne her og smid i init()

        //viewModel.getRow(this.raekkenummer).getX().init();
    }

    public void beregnVO(){

    }

    public void beregnVE(){

        // Hent nødvendige objekter
        X x = viewModel.getRow(getRaekkenummer()).getX();
        VO vo = viewModel.getRow(getRaekkenummer()).getVO();
        SE se = viewModel.getRow(getRaekkenummer()).getSE();
        KE ke = viewModel.getRow(getRaekkenummer()).getKE();


        System.out.println("\n\n[+] BEREGN VE ER BLEVET KALDT!");
        // Kan VE beregnes?
        if (viewModel.getRow(getRaekkenummer()).getVE().kanBeregnes(vo, x, se, ke)){
            System.out.println("\n\n\n[+] VE KAN BEREGNES!");
            // Init VE
            viewModel.getRow(getRaekkenummer()).getVE().init(vo, x, se, ke);
            // Beregn
            viewModel.getRow(getRaekkenummer()).getVE().beregn();

            // Set VE felt til den beregnede værdi
            double calculatedValue = viewModel.getRow(getRaekkenummer()).getVE().getVaerdi();
            veEditText.setText(Double.toString(calculatedValue));


        }

    }

    public void beregDOMK(){

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



    private double getX() {
        return x;
    }

    private void setX(double x) {
        this.x = x;
    }

    private double getVo() {
        return vo;
    }

    private void setVo(double vo) {
        this.vo = vo;
    }

    private double getVe() {
        return ve;
    }

    private void setVe(double ve) {
        this.ve = ve;
    }

    private double getDomk() {
        return domk;
    }

    private void setDomk(double domk) {
        this.domk = domk;
    }

    private double getSto() {
        return sto;
    }

    private void setSto(double sto) {
        this.sto = sto;
    }

    private double getSe() {
        return se;
    }

    private void setSe(double se) {
        this.se = se;
    }
}
