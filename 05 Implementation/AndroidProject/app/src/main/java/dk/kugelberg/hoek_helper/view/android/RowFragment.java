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

/**
 * A simple {@link Fragment} subclass.
 */
public class RowFragment extends Fragment {

    double x = Double.NaN;
    double vo = Double.NaN;
    double ve = Double.NaN;

    EditText xEditText;
    EditText voEditText;
    EditText veEditText;


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
        veEditText = v.findViewById(R.id.ve_text_view);
                return v;
    }

    public void beregn(){
        String nothing = "";
        if(nothing.equals(xEditText.getText().toString()) || nothing.equals(voEditText.getText().toString())){
            veEditText.setText("");
        }
        else{
            if(vo != Double.NaN && x != Double.NaN) {
                ve = vo / x;
                veEditText.setText(Double.toString(ve));
            }
        }
    }


    TextWatcher xFieldWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.length() > 0){
                x = Integer.parseInt(s.toString());
            } else{
                x = Double.NaN;
            }
            beregn();
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
                vo = Double.parseDouble(s.toString());
                System.out.println(vo);
            } else{
                vo = Double.NaN;
            }
            beregn();

        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };



 }
