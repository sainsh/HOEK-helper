package dk.kugelberg.hoek_helper.view.android;



import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import androidx.fragment.app.FragmentTransaction;
import dk.kugelberg.hoek_helper.R;
import dk.kugelberg.hoek_helper.view.viewmodel.Main;
import dk.kugelberg.hoek_helper.view.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    ArrayList<RowFragment> rows;

    Main viewModel = new MainViewModel();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rows = new ArrayList<>();


    }

    public void addRowClicked(View view) {
        RowFragment rf = new RowFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.main_activity, rf);
        rows.add(rf);
        rf.setRaekkenummer(rows.size());
        viewModel.addRow();
        ft.commit();
    }
}
