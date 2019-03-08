//package dk.kugelberg.hoek_helper.view;
//
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.graphics.Color;
//import android.support.v7.app.AlertDialog;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.TypedValue;
//import android.view.Gravity;
//import android.view.View;
//import android.widget.ImageButton;
//import android.widget.TableLayout;
//import android.widget.TableRow;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AlertDialog;
//import dk.kugelberg.hoek_helper.R;
//
//public class MainScreen extends AppCompatActivity {
//
//    private TableLayout tableLayoutHeader;
//    private TableLayout tableLayoutData;
//
//    private String[] headerColumns = new String[4];
//
//    private int numberOfColumns = headerColumns.length;
//    private TextView[] textViewsHeaders = new TextView[numberOfColumns];
//
//    private int numberOfRows = 5;
//    private TableRow tableRowArray[] = new TableRow[numberOfRows];
//
//    private TextView [][] textViewsArray = new TextView [numberOfRows][numberOfColumns];
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        setTheme(R.style.AppTheme);
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_screen);
//
//        tableLayoutHeader = findViewById(R.id.tableLayout_header_main);
//        tableLayoutData = findViewById(R.id.tableLayout_opgaver);
//
//        headerColumns = new String[]{"ID", "Titel", "Oprettet", "Størrelse"};
//        drawTable();
////        setupSharedPreferences();
//
//    }
//
//    /**
//     * Two overloaded methods.
//     * The first one finds the longest text in all the TextViews
//     * The second one finds the longest text in the TextViews of a single column
//     */
//
//    public int findLongestCell() {
//        int longestCell = 0;
//
//        for (int i = 0; i < headerColumns.length; i++) {
//            int cellLength = headerColumns[i].length();
//
//            if (cellLength > longestCell)
//                longestCell = cellLength;
//        }
//
//        for (int i = 0; i < textViewsArray.length; i++) {
//            for (int j = 0; j < textViewsArray[i].length; j++) {
//                if (textViewsArray[i][j] != null) {
//                    int cellLength = textViewsArray[i][j].getText().length();
//
//                    if (cellLength > longestCell)
//                        longestCell = cellLength;
//                }
//            }
//        }
//        return longestCell;
//    }
//
//    public int findLongestCell(int column) {
//        int longestCell = 0;
//
//        int cellLength = headerColumns[column].length();
//
//        if (cellLength > longestCell)
//            longestCell = cellLength;
//
//        for (int i = 0; i < textViewsArray.length; i++) {
//            if (textViewsArray[i][column] != null) {
//                int cellLength2 = textViewsArray[i][column].getText().length();
//
//                if (cellLength2 > longestCell)
//                    longestCell = cellLength2;
//            }
//        }
//        return longestCell;
//    }
//
//    /**
//     * The following code draws the table
//     */
//
//    public void drawTable() {
//        tableLayoutHeader.removeAllViews();
//        tableLayoutData.removeAllViews();
//
//        TableRow tableRowHeader = new TableRow(this);
//
//        int longestCell = findLongestCell();
//
//        final float scale = getResources().getDisplayMetrics().density;
//        int pixels = (int) ((longestCell * 14) * scale + 0.5f);
//
//        for (int i = 0; i < numberOfColumns; i++) {
//            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.MATCH_PARENT);
////            layoutParams.setMargins(2, 2, 2, 2);
//
//            TextView textView = new TextView(this);
//            textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.border_gray_bg));
//            textView.setText(headerColumns[i]);
//            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
//            textView.setTextColor(Color.BLACK);
//            textView.setGravity(Gravity.CENTER);
//
//            textView.setWidth(pixels);
//
//            textView.setLayoutParams(layoutParams);
//
//            tableRowHeader.addView(textView);
//            textViewsHeaders[i] = textView;
//        }
//
//        tableLayoutHeader.addView(tableRowHeader);
//
//        for (int i = 0; i < numberOfRows; i++) {
//
//            // Create TableRows
//            TableRow tableRowData = new TableRow(this);
//            tableRowArray[i] = tableRowData;
//
//            // Create TextViews
//            for (int j = 0; j < numberOfColumns; j++) {
//                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
////                layoutParams.setMargins(2, 2, 2, 2);
//
//                TextView textView = new TextView(this);
//
//                if (i % 2 == 0)
//                    textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.border_white_bg));
//                else
//                    textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.border_light_gray_bg));
//
//                textView.setText(i + " " + j);
//                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
//                textView.setTextColor(Color.BLACK);
//                textView.setGravity(Gravity.CENTER);
////                textView.setPadding(0, 0, 0, 0);
////                textView.setSingleLine(true);
//
//                textView.setWidth(pixels);
//
//                textView.setLayoutParams(layoutParams);
//
//                final int id = i;
//                textView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View arg0) {
//                        openTask(id);
//                    }
//                });
//
//
//                tableRowArray[i].addView(textView);
//                textViewsArray[i][j] = textView;
//            }
//
//            // Create ImageButtons
//            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.MATCH_PARENT);
//            ImageButton imageButton = new ImageButton(this);
//            imageButton.setImageResource(android.R.drawable.ic_delete);
//            imageButton.setBackgroundColor(getResources().getColor(R.color.transparent));
//            imageButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View arg0) {
//                    deleteRow();
//                }
//            });
//
//            imageButton.setLayoutParams(layoutParams);
//
//            tableRowArray[i].addView(imageButton);
//
//            tableLayoutData.addView(tableRowArray[i]);
//        }
//
//    }
//
//    /**
//     * The following code updates the length of TextViews
//     */
//
//    public void updateCellLength(int currentColumn) {
//        int longestCell = findLongestCell(currentColumn);
//
//        final float scale = getResources().getDisplayMetrics().density;
//        int pixels = (int) ((longestCell * 14) * scale + 0.5f);
//
//        textViewsHeaders[currentColumn].setWidth(pixels);
//
//        for (int i = 0; i < numberOfRows; i++) {
//            textViewsArray[i][currentColumn].setWidth(pixels);
//        }
//    }
//
//    /**
//     * The following code adds rows to the table
//     */
//
//    public void addTask(View view) {
//        ++numberOfRows;
//        tableRowArray = new TableRow[numberOfRows];
//        textViewsArray = new TextView[numberOfRows][numberOfColumns];
//        drawTable();
//    }
//
//    /**
//     * The following code deletes rows from the table
//     */
//
//    public void deleteRow() {
//
//        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                switch (which){
//                    case DialogInterface.BUTTON_POSITIVE:
//                        //Yes button clicked
//                        --numberOfRows;
//                        tableRowArray = new TableRow[numberOfRows];
//                        textViewsArray = new TextView[numberOfRows][numberOfColumns];
//                        drawTable();
//                        break;
//
//                    case DialogInterface.BUTTON_NEGATIVE:
//                        //No button clicked
//                        break;
//                }
//            }
//        };
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage("Er du sikker på, at du vil slette opgaven?").setPositiveButton("Ja", dialogClickListener)
//                .setNegativeButton("Nej", dialogClickListener).show();
//
//
//    }
//
//    /**
//     * The following code opens a task
//     */
//
//    public void openTask(int id) {
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.putExtra("id", id);
//        startActivity(intent);
//    }
//
//}
