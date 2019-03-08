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

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dk.kugelberg.hoek_helper.R;
import dk.kugelberg.hoek_helper.view.database.AppDatabase;
import dk.kugelberg.hoek_helper.view.database.DataRow;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private TableLayout tableLayoutHeader;

    //    private String[] headerColumns = new String[11];
//    private String[] headerColumns = new String[5];
    private String[] headerColumns = new String[4];

    private int numberOfColumns = headerColumns.length;
    private TextView[] textViewsHeaders = new TextView[numberOfColumns];

    private int numberOfRows = 5;
    private TableRow tableRowArray[] = new TableRow[numberOfRows];

    private EditText[][] editTextsArray = new EditText[numberOfRows][numberOfColumns];

    private RecyclerView recyclerView;
    private DataAdapter adapter;

    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableLayoutHeader = findViewById(R.id.tableLayout_header);

//        headerColumns = new String[]{getString(R.string.antal_enheder), getString(R.string.vo), getString(R.string.ko), getString(R.string.so), getString(R.string.ve), getString(R.string.ke), getString(R.string.se), getString(R.string.domk), getString(R.string.doms), getString(R.string.gromk), getString(R.string.udvikling)};
//        headerColumns = new String[]{"ID", getString(R.string.antal_enheder), getString(R.string.vo), getString(R.string.ve), getString(R.string.domk)};
        headerColumns = new String[]{getString(R.string.antal_enheder), getString(R.string.vo), getString(R.string.ve), getString(R.string.domk)};

        drawTable();

        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Opgave X");
        }

        recyclerView = findViewById(R.id.recyclerView_tasks);
//        recyclerView.setHasFixedSize(true);

//        recyclerView.setNestedScrollingEnabled(false);

//        recyclerView.setItemViewCacheSize(20);
//        recyclerView.setDrawingCacheEnabled(true);
//        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.scrollToPositionWithOffset(2, 3);

        recyclerView.setLayoutManager(linearLayoutManager);

        int longestCell = findLongestCell();

        final float scale = getResources().getDisplayMetrics().density;
        int pixels = (int) ((longestCell * 14) * scale + 0.5f);

        adapter = new DataAdapter(this, pixels);
        recyclerView.setAdapter(adapter);

        appDatabase = AppDatabase.getInstance(this);

//        recyclerView.smoothScrollToPosition(50);

        setupViewModel();

        System.out.println("onCreate");

        setupSharedPreferences();
    }


    private void setupViewModel() {

        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        viewModel.getTasks().observe(this, new Observer<List<DataRow>>() {

            @Override
            public void onChanged(@Nullable List<DataRow> dataRows) {
//                Log.d(TAG, "Updating list of tasks from LiveData in ViewModel");

                System.out.println("Set tasks");

//                for (DataRow e : taskEntries) {
//                    System.out.println("ID1: " + e.getId());
//                }

//                adapter.setTasks(dataRows);
                adapter.setTasks(doMath(dataRows));
            }
        });
    }

    public List<DataRow> doMath(List<DataRow> dataRows) {

        // Metoden skal tjekke hvad der bliver ændret (via editTextChanged) og ud fra dette bestemme hvad der overskrives
        // Fx: Der indtastes VE -> VO skal overskrives
        // Fx: Der indtastes VO -> VE skal overskrives

        for (int i = 0; i < dataRows.size(); i++) {
            DataRow dataRow = dataRows.get(i);

            if (dataRow.getAntalEnheder() != 0 && dataRow.getVo() != 0) {
                dataRow.setVe(dataRow.getVo() / (double) dataRow.getAntalEnheder());

                if (i == 0)
                    dataRow.setDomk((dataRow.getVo() - 0) / (dataRow.getAntalEnheder() - 0));
                else {
                    DataRow dataRowAbove = dataRows.get(i - 1);

                    if (dataRowAbove.getVo() != 0 && dataRowAbove.getAntalEnheder() != 0)
                        dataRow.setDomk((dataRow.getVo() - dataRowAbove.getVo()) / (dataRow.getAntalEnheder() - dataRowAbove.getAntalEnheder()));
                }
            }
            else {
                dataRow.setVe(0);
                dataRow.setDomk(0);
            }
        }
        return dataRows;
    }

    private String editTextChanged;

    public void setEditTextChanged(String editTextChanged) {
        this.editTextChanged = editTextChanged;
    }

    /**
     * Two overloaded methods.
     * The first one finds the longest text in all the TextViews and EditTexts
     * The second one finds the longest text in the TextView and the EditTexts of a single column
     */

    public int findLongestCell() {
        int longestCell = 0;

        for (int i = 0; i < headerColumns.length; i++) {
            int cellLength = headerColumns[i].length();

            if (cellLength > longestCell)
                longestCell = cellLength;
        }

        for (int i = 0; i < editTextsArray.length; i++) {
            for (int j = 0; j < editTextsArray[i].length; j++) {
                if (editTextsArray[i][j] != null) {
                    int cellLength = editTextsArray[i][j].getText().length();

                    if (cellLength > longestCell)
                        longestCell = cellLength;
                }
            }
        }
        return longestCell;
    }

    public int findLongestCell(int column) {
        int longestCell = 0;

        int cellLength = headerColumns[column].length();

        if (cellLength > longestCell)
            longestCell = cellLength;

        for (int i = 0; i < editTextsArray.length; i++) {
            if (editTextsArray[i][column] != null) {
                int cellLength2 = editTextsArray[i][column].getText().length();

                if (cellLength2 > longestCell)
                    longestCell = cellLength2;
            }
        }
        return longestCell;
    }

    /**
     * The following code draws the table
     */

    public void drawTable() {
        tableLayoutHeader.removeAllViews();
//        tableLayoutData.removeAllViews();

        TableRow tableRowHeader = new TableRow(this);

        int longestCell = findLongestCell();

        final float scale = getResources().getDisplayMetrics().density;
        int pixels = (int) ((longestCell * 14) * scale + 0.5f);

        for (int i = 0; i < numberOfColumns; i++) {
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
//            layoutParams.setMargins(2, 2, 2, 2);

            TextView textView = new TextView(this);
            textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.border_gray_bg));
            textView.setText(headerColumns[i]);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f);
            textView.setTextColor(Color.BLACK);
            textView.setGravity(Gravity.CENTER);

            textView.setWidth(pixels);

            textView.setLayoutParams(layoutParams);

            tableRowHeader.addView(textView);
            textViewsHeaders[i] = textView;
        }

        tableLayoutHeader.addView(tableRowHeader);

    }

    /**
     * The following code updates the length of TextViews and EditTexts
     */

    public void updateCellLength(int currentColumn) {
        int longestCell = findLongestCell(currentColumn);

        final float scale = getResources().getDisplayMetrics().density;
        int pixels = (int) ((longestCell * 14) * scale + 0.5f);

        textViewsHeaders[currentColumn].setWidth(pixels);

        for (int i = 0; i < numberOfRows; i++) {
            editTextsArray[i][currentColumn].setWidth(pixels);
        }
    }

    /**
     * The following code adds rows to the table
     */

    public void addRow(View view) {

        for (int i = 0; i < 5; i++) {
            final DataRow dataRow = new DataRow(0, 0, 0, 0);

            AppExecutors.getInstance().diskIO().execute(new Runnable() {
                @Override
                public void run() {
                    appDatabase.taskDao().insertTask(dataRow);
                }
            });
        }

//        recyclerView.scrollToPosition(50);
//        recyclerView.smoothScrollToPosition(50);


//        AppExecutors.getInstance().diskIO().execute(new Runnable() {
//            @Override
//            public void run() {
//                List<DataRow> tasks = appDatabase.taskDao().loadAll();
//
//                for (int i = 0; i < tasks.size(); i++) {
//                    System.out.println(tasks.get(i).getId());
//                }
//            }
//        });
    }

    private PopupWindow popupWindow;
    private EditText etRows;
    private EditText etAntal;
    private EditText etIncrement;

    public void addRows(View view) {
        int width = GridLayout.LayoutParams.WRAP_CONTENT;
        int height = GridLayout.LayoutParams.WRAP_CONTENT;
        View v = LayoutInflater.from(this).inflate(R.layout.popup_layout, null, false);

//        TextView textView = (TextView)v.findViewById(R.id.tv_popup_antal);
//        System.out.println(textView.getText().toString());

        etRows = v.findViewById(R.id.et_popup_rows);
        etAntal = v.findViewById(R.id.et_popup_antal);
        etIncrement = v.findViewById(R.id.et_popup_increment);

//        System.out.println(etRows.getHint().toString());

        popupWindow = new PopupWindow(v, width, height, true);
        popupWindow.showAtLocation(this.findViewById(R.id.main_layout), Gravity.CENTER, 0, 0);
    }

    public void popupInsert(View view) {

        int rows = Integer.parseInt(etRows.getText().toString());
        int antal = Integer.parseInt(etAntal.getText().toString());
        int increment = Integer.parseInt(etIncrement.getText().toString());

        for (int i = 0; i < rows; i++) {
            final DataRow dataRow = new DataRow(antal, 0, 0, 0);

            AppExecutors.getInstance().diskIO().execute(new Runnable() {
                @Override
                public void run() {
                    appDatabase.taskDao().insertTask(dataRow);
                }
            });

            antal += increment;
        }
        popupWindow.dismiss();

//        System.out.println(etRows.getHint().toString());
    }

    public void popupCancel(View view) {
        popupWindow.dismiss();
    }

    int counter = 0;

    /**
     * The following code updates rows to the table
     */

    private int mTaskId;

    public void updateRow(View view) {
        final DataRow dataRow = new DataRow(0, 0, 0, 0);
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                dataRow.setId(mTaskId);
                appDatabase.taskDao().updateTask(dataRow);
            }
        });
    }


    /**
     * The following code deletes rows from the table
     */

    public void deleteRow() {
        --numberOfRows;
        tableRowArray = new TableRow[numberOfRows];
        editTextsArray = new EditText[numberOfRows][numberOfColumns];
        drawTable();
    }

    /**
     * The following code deals with the top right menu
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

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
            textViewsHeaders[0].setVisibility(View.VISIBLE);
            adapter.setAntalEnhederVisible(true);
        } else {
            textViewsHeaders[0].setVisibility(View.GONE);
            adapter.setAntalEnhederVisible(false);
        }

        if (sharedPreferences.getBoolean(getString(R.string.vis_vo_key), getResources().getBoolean(R.bool.vis_vo))) {
            textViewsHeaders[1].setVisibility(View.VISIBLE);
            adapter.setVoVisible(true);
        } else {
            textViewsHeaders[1].setVisibility(View.GONE);
            adapter.setVoVisible(false);
        }

        if (sharedPreferences.getBoolean(getString(R.string.vis_ve_key), getResources().getBoolean(R.bool.vis_ve))) {
            textViewsHeaders[2].setVisibility(View.VISIBLE);
            adapter.setVeVisible(true);
        } else {
            textViewsHeaders[2].setVisibility(View.GONE);
            adapter.setVeVisible(false);
        }

        if (sharedPreferences.getBoolean(getString(R.string.vis_domk_key), getResources().getBoolean(R.bool.vis_domk))) {
            textViewsHeaders[3].setVisibility(View.VISIBLE);
            adapter.setDomkVisible(true);
        } else {
            textViewsHeaders[3].setVisibility(View.GONE);
            adapter.setDomkVisible(false);
        }
    }

    private void setupSharedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        visibility(sharedPreferences);

        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

//        if (key.equals(getString(R.string.vis_antal_enheder_key))) {
//            System.out.println("Correct key");
        visibility(sharedPreferences);
//        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);
    }




}