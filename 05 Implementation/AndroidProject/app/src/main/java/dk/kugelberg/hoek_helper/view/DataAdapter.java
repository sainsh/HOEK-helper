package dk.kugelberg.hoek_helper.view;

import android.content.Context;

import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import androidx.recyclerview.widget.RecyclerView;
import dk.kugelberg.hoek_helper.R;
import dk.kugelberg.hoek_helper.model.Controller;
import dk.kugelberg.hoek_helper.model.ControllerImpl;
import dk.kugelberg.hoek_helper.model.Raekke;
import dk.kugelberg.hoek_helper.view.database.AppDatabase;
import dk.kugelberg.hoek_helper.view.database.DataRow;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.RowViewHolder> {

    // Constant for date format
    private static final String DATE_FORMAT = "dd/MM/yyy";

    // Class variables for the List that holds task data and the Context
//    private List<DataRow> dataRows;
    private ArrayList<Raekke> dataRows;
    private Context context;

    // Date formatter
    private SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());

    private AppDatabase appDatabase;

    private int pixels;
    private int currentlyFocusedRow;
    private int currentlyFocusedColumn;

    private boolean antalEnhederVisible = true;
    private boolean voVisible = true;
    private boolean veVisible = true;
    private boolean domkVisible = true;

    public void setAntalEnhederVisible(boolean antalEnhederVisible) {
        this.antalEnhederVisible = antalEnhederVisible;
    }

    public void setVoVisible(boolean voVisible) {
        this.voVisible = voVisible;
    }

    public void setVeVisible(boolean veVisible) {
        this.veVisible = veVisible;
    }

    public void setDomkVisible(boolean domkVisible) {
        this.domkVisible = domkVisible;
    }

    public DataAdapter(Context context, int pixels) {
        this.context = context;
        this.pixels = pixels;
        appDatabase = AppDatabase.getInstance(context);
    }

    @Override
    public RowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false);

        return new RowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RowViewHolder holder, int position) {

        if (antalEnhederVisible)
            holder.antalEnheder.setVisibility(View.VISIBLE);
        else
            holder.antalEnheder.setVisibility(View.GONE);

        if (voVisible)
            holder.vo.setVisibility(View.VISIBLE);
        else
            holder.vo.setVisibility(View.GONE);

        if (veVisible)
            holder.ve.setVisibility(View.VISIBLE);
        else
            holder.ve.setVisibility(View.GONE);

        if (domkVisible)
            holder.domk.setVisibility(View.VISIBLE);
        else
            holder.domk.setVisibility(View.GONE);

//        DataRow dataRow = dataRows.get(position);
        Raekke dataRow = dataRows.get(position);

//        int idNum = dataRow.getId();
        double antalEnhederNum = dataRow.getX().getVaerdi();
        double voNum = dataRow.getVO().getVaerdi();
        double veNum = dataRow.getVE().getVaerdi();
        double domkNum = dataRow.getDOMK().getVaerdi();

//        if (holder.textWatcher != null)
//            holder.antalEnheder.removeTextChangedListener(holder.textWatcher);

//        holder.id.setText(String.valueOf(idNum));
        holder.antalEnheder.setText(String.valueOf(antalEnhederNum));
//        holder.vo.setText(String.valueOf(voNum));
        holder.vo.setText(String.format(Locale.GERMAN, "%,.2f", voNum));
        holder.ve.setText(String.valueOf(veNum));
//        holder.ve.setText(String.format("%.2f", veNum));
        holder.domk.setText(String.valueOf(domkNum));

        if (position == currentlyFocusedRow)
            if (holder.antalEnheder.getId() == currentlyFocusedColumn) {
                holder.antalEnheder.requestFocus();
                holder.antalEnheder.setSelection(holder.antalEnheder.getText().length());
            } else if (holder.vo.getId() == currentlyFocusedColumn) {
                holder.vo.requestFocus();
                holder.vo.setSelection(holder.vo.getText().length());
            } else if (holder.ve.getId() == currentlyFocusedColumn) {
                holder.ve.requestFocus();
                holder.ve.setSelection(holder.ve.getText().length());
            } else if (holder.domk.getId() == currentlyFocusedColumn) {
                holder.domk.requestFocus();
                holder.domk.setSelection(holder.domk.getText().length());
            }

//        if (holder.textWatcher != null)
//            holder.antalEnheder.addTextChangedListener(holder.textWatcher);

        if (position % 2 == 0) {
//            holder.id.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_white_bg));
            holder.antalEnheder.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_white_bg));
            holder.vo.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_white_bg));
            holder.ve.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_white_bg));
            holder.domk.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_white_bg));
        } else {
//            holder.id.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_light_gray_bg));
            holder.antalEnheder.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_light_gray_bg));
            holder.vo.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_light_gray_bg));
            holder.ve.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_light_gray_bg));
            holder.domk.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_light_gray_bg));
        }


    }

    int changeCounter = 0;

    @Override
    public int getItemCount() {
        if (dataRows == null) {
            return 0;
        }
        return dataRows.size();
    }

//    public List<DataRow> getTasks() {
//        return dataRows;
//    }

    public ArrayList<Raekke> getTasks() {
        return dataRows;
    }

//    public void setTasks(List<DataRow> dataRows) {
//        this.dataRows = dataRows;
//        notifyDataSetChanged();
//
//        // Use these
////        adapter.notifyItemRangeInserted(rangeStart, rangeEnd);
////        adapter.notifyItemRemoved(position);
////        adapter.notifyItemChanged(position);
////        adapter.notifyItemInserted(position);
//    }

    public void setTasks(ArrayList<Raekke> raekker) {
        this.dataRows = raekker;
        notifyDataSetChanged();
    }

    private boolean visible = true;

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    class RowViewHolder extends RecyclerView.ViewHolder {
//        TextView id;
        EditText antalEnheder;
        EditText vo;
        EditText ve;
        EditText domk;
        ImageButton imageButtonDelete;
        ImageButton imageButtonUp;
        ImageButton imageButtonDown;
        TextWatcher textWatcher;
        View.OnFocusChangeListener onFocusChangeListener;

        public RowViewHolder(View itemView) {
            super(itemView);

//            id = itemView.findViewById(R.id.text_view_id);
            antalEnheder = itemView.findViewById(R.id.edit_text_antal_enheder);
            vo = itemView.findViewById(R.id.edit_text_vo);
            ve = itemView.findViewById(R.id.edit_text_ve);
            domk = itemView.findViewById(R.id.edit_text_domk);

//            id.setWidth(pixels);
            antalEnheder.setWidth(pixels);
            vo.setWidth(pixels);
            ve.setWidth(pixels);
            domk.setWidth(pixels);

            imageButtonUp = itemView.findViewById(R.id.imageButtonUp);
            imageButtonUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    moveUp();
                }
            });

            imageButtonDown = itemView.findViewById(R.id.imageButtonDown);
            imageButtonDown.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    moveDown();
                }
            });

            imageButtonDelete = itemView.findViewById(R.id.imageButtonDelete);
            imageButtonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    deleteRow();
                }
            });

//            textWatcher = new TextWatcher() {
//                @Override
//                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start, int before, int count) {
//                }
//
//                @Override
//                public void afterTextChanged(Editable s) {
//                    final DataRow dataRow = dataRows.get(getAdapterPosition());
//
//                    AppExecutors.getInstance().diskIO().execute(new Runnable() {
//                        @Override
//                        public void run() {
//                            System.out.println("etf" + counter++);
//                            System.out.println("pos" + getAdapterPosition());
//
//                            dataRow.setAntalEnheder(Integer.parseInt(antalEnheder.getText().toString()));
////                            dataRow.setVo(Double.parseDouble(vo.getText().toString()));
////                            dataRow.setVe(Double.parseDouble(ve.getText().toString()));
////                            dataRow.setDomk(Double.parseDouble(domk.getText().toString()));
//
//                            appDatabase.taskDao().updateTask(dataRow);
//
//                            System.out.println("id" + dataRow.getId());
//                            System.out.println("ae" + antalEnheder.getText().toString());
//                            System.out.println("ae up" + dataRow.getAntalEnheder());
//
//                        }
//                    });
//                }
//            };

//            antalEnheder.addTextChangedListener(textWatcher);

            // Why does this fire 4 times when you click away from an EditText after changing it?
            // 1st fire = When another EditText is clicked and the first EditText loses focus
            // 2nd fire = When the other EditText receives focus
            // 3rd fire = When the other EditText loses focus because notifyDataSetChanged(); gets called
            // Note: This 4th fire only happens if holder.id.requestFocus(); is removed
            // 4th fire = When the other receives focus again after notifyDataSetChanged(); is finished
            onFocusChangeListener = new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean hasFocus) {
                    EditText editText = (EditText) view;

                    // https://stackoverflow.com/questions/9527067/android-edittext-in-listview-loses-focus-on-calling-notifydatachanged
                    if (hasFocus) {
                        currentlyFocusedRow = getAdapterPosition();
                        currentlyFocusedColumn = editText.getId();
                    }

                    System.out.println("FocusChanged" + counter++ + " Has focus: " + hasFocus + " Contents " + editText.getText().toString());

                    try {



                    if (getAdapterPosition() != -1 && !hasFocus) {

                        System.out.println("Adapter not -1, is " + getAdapterPosition());

                        final Raekke dataRow = dataRows.get(getAdapterPosition());

                        double currentAntalEnheder = dataRow.getX().getVaerdi();
                        double newAntalEnheder = Double.parseDouble(antalEnheder.getText().toString());

//                        String currentAntalEnhederString = String.valueOf(currentAntalEnheder);
//                        String newAntalEnhederString = antalEnheder.getText().toString();

//                        DecimalFormat decimalFormat = new DecimalFormat();
//                        DecimalFormatSymbols decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
//                        char decimalSeparator = decimalFormatSymbols.getDecimalSeparator();
                        double currentVo = dataRow.getVO().getVaerdi();
//                        double newVo = Double.parseDouble(vo.getText().toString());
                        double newVo = Double.parseDouble(vo.getText().toString().replace(".", "").replace(",", "."));
//                        double newVo;
//                        if (decimalSeparator == ',')
//                            newVo = Double.parseDouble(vo.getText().toString().replace(".", "").replace(",", "."));
//                        else
//                            newVo = Double.parseDouble(vo.getText().toString().replace(",", "").replace(".", ","));

//                        String currentVoString = String.format(Locale.GERMAN, "%,.2f", currentVo);
//                        String newVoString = vo.getText().toString();

                        double currentVe = dataRow.getVE().getVaerdi();
                        double newVe = Double.parseDouble(ve.getText().toString());

//                        String currentVeString = String.format(Locale.GERMAN, "%,.2f", currentVe);
//                        String newVeString = ve.getText().toString();

                        double currentDomk = dataRow.getDOMK().getVaerdi();
                        double newDomk = Double.parseDouble(domk.getText().toString());

//                        String currentDomkString = String.format(Locale.GERMAN, "%,.2f", currentDomk);
//                        String newDomkString = domk.getText().toString();

                        if (currentAntalEnheder != newAntalEnheder || currentVo != newVo || currentVe != newVe || currentDomk != newDomk) {
                            System.out.println("Something gets changed");

                            dataRow.getX().setVaerdi(newAntalEnheder);
                            dataRow.getVO().setVaerdi(newVo);
//                            dataRow.getVE().setVaerdi(newVe);
//                            dataRow.getDOMK().setVaerdi(newDomk);

                            dataRow.getVE().init(dataRow.getVO(), dataRow.getX(), dataRow.getSE(), dataRow.getKE());
                            dataRow.getVE().beregn();


                            ControllerImpl.getInstance().getTabel().getTabelMld().setValue(ControllerImpl.getInstance().getTabel().getTabelMld().getValue());
                            ControllerImpl.getInstance().getTabel().getTabelMld().setValue(dataRows);

//                            AppExecutors.getInstance().diskIO().execute(new Runnable() {
//                                @Override
//                                public void run() {
//                                    appDatabase.taskDao().updateTask(dataRow);
//                                }
//                            });


                        }

//                        if (!currentAntalEnhederString.equals(newAntalEnhederString)) {
//                            System.out.println("Antal enheder gets changed");
//
//                            MainActivity mainActivity = (MainActivity)context;
//                            mainActivity.setEditTextChanged("antalEnheder");
//
//                            dataRow.setAntalEnheder(newAntalEnheder);
//                            AppExecutors.getInstance().diskIO().execute(new Runnable() {
//                                @Override
//                                public void run() {
//                                    appDatabase.taskDao().updateTask(dataRow);
//                                }
//                            });
//                        }
                    }


                    } catch (NumberFormatException e) {
                        Toast toast = Toast.makeText(context, "Der skal stå et tal.", Toast.LENGTH_SHORT);
                        toast.show();
                    }

                }
            };

            antalEnheder.setOnFocusChangeListener(onFocusChangeListener);
            vo.setOnFocusChangeListener(onFocusChangeListener);
            ve.setOnFocusChangeListener(onFocusChangeListener);
            domk.setOnFocusChangeListener(onFocusChangeListener);

        }

        private void moveUp() {
//            if (getAdapterPosition() != 0) {
//                final DataRow dataRowCurrent = dataRows.get(getAdapterPosition());
//                final DataRow dataRowAbove = dataRows.get(getAdapterPosition() - 1);
//
//                int idCurrent = dataRowCurrent.getId();
//                int idAbove = dataRowAbove.getId();
//
//                dataRowCurrent.setId(idAbove);
//                dataRowAbove.setId(idCurrent);
//
//                AppExecutors.getInstance().diskIO().execute(new Runnable() {
//                    @Override
//                    public void run() {
//                        appDatabase.taskDao().updateTask(dataRowCurrent);
//                        appDatabase.taskDao().updateTask(dataRowAbove);
//                    }
//                });
//            }
        }

        private void moveDown() {
//            if (getAdapterPosition() != dataRows.size()) {
//                final DataRow dataRowCurrent = dataRows.get(getAdapterPosition());
//                final DataRow dataRowBelow = dataRows.get(getAdapterPosition() + 1);
//
//                int idCurrent = dataRowCurrent.getId();
//                int idBelow = dataRowBelow.getId();
//
//                dataRowCurrent.setId(idBelow);
//                dataRowBelow.setId(idCurrent);
//
//                AppExecutors.getInstance().diskIO().execute(new Runnable() {
//                    @Override
//                    public void run() {
//                        appDatabase.taskDao().updateTask(dataRowCurrent);
//                        appDatabase.taskDao().updateTask(dataRowBelow);
//                    }
//                });
//            }
        }

        private void deleteRow() {
//            final DataRow dataRow = dataRows.get(getAdapterPosition());
//
//            AppExecutors.getInstance().diskIO().execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("pos" + getAdapterPosition());
//                    System.out.println("size" + dataRows.size());
//                    System.out.println("ae" + dataRow.getAntalEnheder());
//                    System.out.println("id" + dataRow.getId());
//
//                    appDatabase.taskDao().deleteTask(dataRow);
//                }
//            });
        }

        private void deleteAll() {
//            for (int i = 0; i < dataRows.size(); i++) {
//                final DataRow dataRow = dataRows.get(i);
//
//                AppExecutors.getInstance().diskIO().execute(new Runnable() {
//                    @Override
//                    public void run() {
//                        appDatabase.taskDao().deleteTask(dataRow);
//                    }
//                });
//            }
        }
    }

    int counter = 0;

//    @Override
//    public long getItemId(int position) {
//
////        return super.getItemId(position);
//        return dataRows.get(position).hashCode(); //id()
//    }
}
