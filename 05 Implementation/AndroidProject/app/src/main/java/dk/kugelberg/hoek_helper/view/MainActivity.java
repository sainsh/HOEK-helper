package dk.kugelberg.hoek_helper.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.PopupWindow;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dk.kugelberg.hoek_helper.R;
import dk.kugelberg.hoek_helper.model.Controller;
import dk.kugelberg.hoek_helper.model.ControllerImpl;
import dk.kugelberg.hoek_helper.model.Raekke;
import dk.kugelberg.hoek_helper.model.Tabel;
import dk.kugelberg.hoek_helper.view.ViewModel.ModelViewModel;

/**
* Hvad er meningen med klassen?
*/
public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private Controller controller;
    private ModelViewModel viewModel;

    private RecyclerView recyclerView;
    private DataAdapter adapter;
        
    private TextView antalEnheder, vo, ve, domk, se, ke, ko, sto, gromk, oms, db;
    private EditText etRows, etAntal, etIncrement;
    private PopupWindow popupWindow;
    
    private String editTextChanged;
    double testX = 0;
    double testVO = 0;
    // NO CONSTRUCTOR HERE

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = ControllerImpl.getInstance();
        setupViewModel();

        antalEnheder = findViewById(R.id.tv_antal_enheder);
        vo = findViewById(R.id.tv_vo);
        ve = findViewById(R.id.tv_ve);
        domk = findViewById(R.id.tv_domk);
        se = findViewById(R.id.tv_se);
        ke = findViewById(R.id.tv_ke);
        ko = findViewById(R.id.tv_ko);
        sto = findViewById(R.id.tv_sto);
        gromk = findViewById(R.id.tv_gromk);
        oms = findViewById(R.id.tv_oms);
        db = findViewById(R.id.tv_db);
        recyclerView = findViewById(R.id.recyclerView_tasks);

        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Opgave X");
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new DataAdapter(this, viewModel);
        recyclerView.setAdapter(adapter);


        setupSharedPreferences();
        Tabel tabel = ControllerImpl.getInstance().getTabel();
        if(tabel.getTabelMld().getValue().size() == 0)
        {
        tabel.addRaekke(0);
        Raekke raekke = tabel.getRaekke(0);
        raekke.getX().setVaerdi(0);
        raekke.getKO().setVaerdi(0);
        raekke.getVO().setVaerdi(0);
        raekke.getSTO().setVaerdi(0);
        raekke.getDOMK().setVaerdi(0);
        raekke.getSE().setVaerdi(0);
        raekke.getGROMK().setVaerdi(0);
        raekke.getKE().setVaerdi(0);
        raekke.getVE().setVaerdi(0);
        raekke.getOMS().setVaerdi(0);
        raekke.getDB().setVaerdi(0);
        }
    }

    /**
    *
    */
    private void setupViewModel() {

        viewModel = ViewModelProviders.of(this).get(ModelViewModel.class);

        viewModel.getTable().observe(this, new Observer<ArrayList<Raekke>>() {

            @Override
            public void onChanged(@Nullable ArrayList<Raekke> raekker) {
                adapter.setTasks(raekker);
            }
        });
    }

    /**
     * The following code adds rows to the table
     */
    public void addRow(View view) {
        viewModel.addRow();
    }


    /**
    *
    */
    public void addRows(View view) {
        int width = GridLayout.LayoutParams.WRAP_CONTENT;
        int height = GridLayout.LayoutParams.WRAP_CONTENT;
        View v = LayoutInflater.from(this).inflate(R.layout.popup_layout, null, false);

        etRows = v.findViewById(R.id.et_popup_rows);
        etAntal = v.findViewById(R.id.et_popup_antal);
        etIncrement = v.findViewById(R.id.et_popup_increment);

        popupWindow = new PopupWindow(v, width, height, true);
        popupWindow.showAtLocation(this.findViewById(R.id.main_layout), Gravity.CENTER, 0, 0);
    }

    
    /**
    *
    */
    public void popupInsert(View view) {
        viewModel.popupInsert(popupWindow, etRows, etAntal, etIncrement);
    }

    
    /**
    *
    */
    public void popupCancel(View view) {
        viewModel.popupCancel(popupWindow);
    }

    /**
     * The following code deals with the top right menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /**
    *
    */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();

        if (itemThatWasClickedId == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        } else if (itemThatWasClickedId == R.id.indstillinger) {
            Intent i = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * The following code deals with changing of settings
     */
    private void visibility(SharedPreferences sharedPreferences) {
        if (sharedPreferences.getBoolean(getString(R.string.vis_antal_enheder_key), getResources().getBoolean(R.bool.vis_antal_enheder))) {
            antalEnheder.setVisibility(View.VISIBLE);
            adapter.setAntalEnhederVisible(true);
        } else {
            antalEnheder.setVisibility(View.GONE);
            adapter.setAntalEnhederVisible(false);
        }

        if (sharedPreferences.getBoolean(getString(R.string.vis_vo_key), getResources().getBoolean(R.bool.vis_vo))) {
            vo.setVisibility(View.VISIBLE);
            adapter.setVoVisible(true);
        } else {
            vo.setVisibility(View.GONE);
            adapter.setVoVisible(false);
        }

        if (sharedPreferences.getBoolean(getString(R.string.vis_ve_key), getResources().getBoolean(R.bool.vis_ve))) {
            ve.setVisibility(View.VISIBLE);
            adapter.setVeVisible(true);
        } else {
            ve.setVisibility(View.GONE);
            adapter.setVeVisible(false);
        }

        if (sharedPreferences.getBoolean(getString(R.string.vis_domk_key), getResources().getBoolean(R.bool.vis_domk))) {
            domk.setVisibility(View.VISIBLE);
            adapter.setDomkVisible(true);
        } else {
            domk.setVisibility(View.GONE);
            adapter.setDomkVisible(false);
        }
        if (sharedPreferences.getBoolean(getString(R.string.vis_domk_key), getResources().getBoolean(R.bool.vis_domk))) {
            domk.setVisibility(View.VISIBLE);
            adapter.setDomkVisible(true);
        } else {
            domk.setVisibility(View.GONE);
            adapter.setDomkVisible(false);
        }
        if (sharedPreferences.getBoolean(getString(R.string.vis_se_key), getResources().getBoolean(R.bool.vis_se))) {
            se.setVisibility(View.VISIBLE);
            adapter.setSeVisible(true);
        } else {
            se.setVisibility(View.GONE);
            adapter.setSeVisible(false);
        }
        if (sharedPreferences.getBoolean(getString(R.string.vis_ke_key), getResources().getBoolean(R.bool.vis_ke))) {
            ke.setVisibility(View.VISIBLE);
            adapter.setKeVisible(true);
        } else {
            ke.setVisibility(View.GONE);
            adapter.setKeVisible(false);
        }
        if (sharedPreferences.getBoolean(getString(R.string.vis_ko_key), getResources().getBoolean(R.bool.vis_ko))) {
            ko.setVisibility(View.VISIBLE);
            adapter.setKoVisible(true);
        } else {
            ko.setVisibility(View.GONE);
            adapter.setKoVisible(false);
        }
        if (sharedPreferences.getBoolean(getString(R.string.vis_sto_key), getResources().getBoolean(R.bool.vis_sto))) {
            sto.setVisibility(View.VISIBLE);
            adapter.setStoVisible(true);
        } else {
            sto.setVisibility(View.GONE);
            adapter.setStoVisible(false);
        }
        if (sharedPreferences.getBoolean(getString(R.string.vis_gromk_key), getResources().getBoolean(R.bool.vis_gromk))) {
            gromk.setVisibility(View.VISIBLE);
            adapter.setGromkVisible(true);
        } else {
            gromk.setVisibility(View.GONE);
            adapter.setGromkVisible(false);
        }
        if (sharedPreferences.getBoolean(getString(R.string.vis_oms_key), getResources().getBoolean(R.bool.vis_oms))) {
            oms.setVisibility(View.VISIBLE);
            adapter.setOmsVisible(true);
        } else {
            oms.setVisibility(View.GONE);
            adapter.setOmsVisible(false);
        }
        if (sharedPreferences.getBoolean(getString(R.string.vis_db_key), getResources().getBoolean(R.bool.vis_db))) {
            db.setVisibility(View.VISIBLE);
            adapter.setDbVisible(true);
        } else {
            db.setVisibility(View.GONE);
            adapter.setDbVisible(false);
        }

    }

    /**
     * 
     */
    private void setupSharedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        visibility(sharedPreferences);

        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    
    /**
     * The following code deals with changing of settings
     */
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        visibility(sharedPreferences);
    }

     /**
     * 
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);
    }

    /**
     * The following code deals with the hardware back button
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        NavUtils.navigateUpFromSameTask(this);
    }
    
    
    public void setEditTextChanged(String editTextChanged) {
        this.editTextChanged = editTextChanged;
    }

}
