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
import dk.kugelberg.hoek_helper.model.KEimpl;
import dk.kugelberg.hoek_helper.model.SE;
import dk.kugelberg.hoek_helper.model.SEImpl;
import dk.kugelberg.hoek_helper.model.VE;
import dk.kugelberg.hoek_helper.model.VEImpl;
import dk.kugelberg.hoek_helper.model.VO;
import dk.kugelberg.hoek_helper.model.VOImpl;
import dk.kugelberg.hoek_helper.model.X;
import dk.kugelberg.hoek_helper.model.XImpl;

/**
 * A simple {@link Fragment} subclass.
 */
public class RowFragment extends Fragment {

    X x = new XImpl();
    VO vo = new VOImpl();
    VE ve;
    DOMK domk;
    EditText xEditText;
    EditText voEditText;
    EditText veEditText;
    EditText domkEditText;

    public RowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // xEditText = getView().findViewById(R.id.x_text_view);
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_row, container, false);
        xEditText = v.findViewById(R.id.x_text_view);
        xEditText.addTextChangedListener(xFieldWatcher);
        voEditText = v.findViewById(R.id.vo_text_view);
        voEditText.addTextChangedListener(voTextWatcher);
        domkEditText = v.findViewById(R.id.domk_text_view);
        return v;
    }

    public void beregn(){

        //SE se = new SEImpl();
        //KE ke = new KEimpl();

        //VE ve = new VEImpl();
        //ve.init(vo, x, se, ke);



        if(!Double.isNaN(x.getVaerdi()) && !Double.isNaN(vo.getVaerdi())){

            ve.setVaerdi(vo.getVaerdi() / x.getVaerdi());
            veEditText.setText(Double.toString(ve.getVaerdi()));

        }
    }

    TextWatcher xFieldWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.length() > 0){
                x.setVaerdi(Double.parseDouble(s.toString()));

                beregn();
            } else{
                x.setVaerdi(Double.NaN);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    TextWatcher voTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(s.length() > 0){
                vo.setVaerdi(Double.parseDouble(s.toString()));
                System.out.println(vo);
                beregn();
            } else{
                vo.setVaerdi(Double.NaN);
            }

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

 }
