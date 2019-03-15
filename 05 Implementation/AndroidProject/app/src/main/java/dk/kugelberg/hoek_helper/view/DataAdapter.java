package dk.kugelberg.hoek_helper.view;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import dk.kugelberg.hoek_helper.R;
import dk.kugelberg.hoek_helper.model.ControllerImpl;
import dk.kugelberg.hoek_helper.model.KO;
import dk.kugelberg.hoek_helper.model.NegativVaerdiException;
import dk.kugelberg.hoek_helper.model.Raekke;
import dk.kugelberg.hoek_helper.view.ViewModel.ModelViewModel;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.RowViewHolder> {

    private ArrayList<Raekke> raekkeArrayList;
    private Context context;
    private ModelViewModel viewModel;

    private int widthInPixels;
    private int currentlyFocusedRow;
    private int currentlyFocusedColumn;
    private int selection;

    private boolean antalEnhederVisible = true;
    private boolean voVisible = true;
    private boolean veVisible = true;
    private boolean domkVisible = true;
    private boolean seVisible = true;
    private boolean keVisible = true;
    private boolean koVisible = true;
    private boolean stoVisible = true;
    private boolean gromkVisible = true;
    private boolean omsVisible = true;
    private boolean dbVisible = true;

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

    public void setSeVisible(boolean seVisible) {
        this.seVisible = seVisible;
    }

    public void setKeVisible(boolean keVisible) {
        this.keVisible = keVisible;
    }

    public void setKoVisible(boolean koVisible) {
        this.koVisible = koVisible;
    }

    public void setStoVisible(boolean stoVisible) {
        this.stoVisible = stoVisible;
    }

    public void setGromkVisible(boolean gromkVisible) {
        this.gromkVisible = gromkVisible;
    }

    public void setOmsVisible(boolean omsVisible) {
        this.omsVisible = omsVisible;
    }

    public void setDbVisible(boolean dbVisible) {
        this.dbVisible = dbVisible;
    }

    public DataAdapter(Context context, ModelViewModel viewModel) {
        this.context = context;
        this.viewModel = viewModel;

        int widthInDp = 180;
        final float scale = context.getResources().getDisplayMetrics().density;
        widthInPixels = (int) (widthInDp * scale + 0.5f);
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

        if (seVisible)
            holder.se.setVisibility(View.VISIBLE);
        else
            holder.se.setVisibility(View.GONE);

        if (keVisible)
            holder.ke.setVisibility(View.VISIBLE);
        else
            holder.ke.setVisibility(View.GONE);

        if (koVisible)
            holder.ko.setVisibility(View.VISIBLE);
        else
            holder.ko.setVisibility(View.GONE);

        if (stoVisible)
            holder.sto.setVisibility(View.VISIBLE);
        else
            holder.sto.setVisibility(View.GONE);

        if (gromkVisible)
            holder.gromk.setVisibility(View.VISIBLE);
        else
            holder.gromk.setVisibility(View.GONE);

        if (omsVisible)
            holder.oms.setVisibility(View.VISIBLE);
        else
            holder.oms.setVisibility(View.GONE);

        if (dbVisible)
            holder.db.setVisibility(View.VISIBLE);
        else
            holder.db.setVisibility(View.GONE);

        Raekke raekke = raekkeArrayList.get(position);


        double antalEnhederNum = raekke.getX().getVaerdi();
        double voNum = raekke.getVO().getVaerdi();
        double veNum = raekke.getVE().getVaerdi();
        double domkNum = raekke.getDOMK().getVaerdi();
        double dbNum = raekke.getDB().getVaerdi();
        double gromkNum = raekke.getGROMK().getVaerdi();
        double keNum = raekke.getKE().getVaerdi();
        double koNum = raekke.getKO().getVaerdi();
        double omsNum = raekke.getOMS().getVaerdi();
        double seNum = raekke.getSE().getVaerdi();
        double stoNum = raekke.getSTO().getVaerdi();

        // if (!Double.isNaN(antalEnhederNum))
        holder.antalEnheder.setText(String.valueOf(antalEnhederNum));
//       holder.vo.setText(String.valueOf(voNum));
        // if (!Double.isNaN(voNum))
        holder.vo.setText(String.format(Locale.GERMAN, "%,.2f", voNum));
        // if (!Double.isNaN(veNum))
        holder.ve.setText(String.valueOf(veNum));
//        holder.ve.setText(String.format("%.2f", veNum));
        // if (!Double.isNaN(domkNum))
        holder.domk.setText(String.valueOf(domkNum));
        // if (!Double.isNaN(dbNum))
        holder.db.setText(String.valueOf(dbNum));
        // if (!Double.isNaN(gromkNum))
        holder.gromk.setText(String.valueOf(gromkNum));
        //  if (!Double.isNaN(keNum))
        holder.ke.setText(String.valueOf(keNum));
        //  if (!Double.isNaN(koNum))
        holder.ko.setText(String.valueOf(koNum));
        //  if (!Double.isNaN(omsNum))
        holder.oms.setText(String.valueOf(omsNum));
        // if (!Double.isNaN(seNum))
        holder.se.setText(String.valueOf(seNum));
        // if (!Double.isNaN(stoNum))
        holder.sto.setText(String.valueOf(stoNum));

        // This places the cursor back where it belongs when the table is redrawn upon changes.
        if (position == currentlyFocusedRow) {
            if (holder.antalEnheder.getId() == currentlyFocusedColumn) {
                holder.antalEnheder.requestFocus();
//                holder.antalEnheder.setSelection(holder.antalEnheder.getText().length());
                holder.antalEnheder.setSelection(selection);
            } else if (holder.vo.getId() == currentlyFocusedColumn) {
                holder.vo.requestFocus();
//                holder.vo.setSelection(holder.vo.getText().length());
                holder.vo.setSelection(selection);
            } else if (holder.ve.getId() == currentlyFocusedColumn) {
                holder.ve.requestFocus();
//                holder.ve.setSelection(holder.ve.getText().length());
                holder.ve.setSelection(selection);
            } else if (holder.domk.getId() == currentlyFocusedColumn) {
                holder.domk.requestFocus();
//                holder.domk.setSelection(holder.domk.getText().length());
                holder.domk.setSelection(selection);
            } else if (holder.db.getId() == currentlyFocusedColumn) {
                holder.db.requestFocus();
                holder.db.setSelection(selection);
            } else if (holder.gromk.getId() == currentlyFocusedColumn) {
                holder.gromk.requestFocus();
                holder.gromk.setSelection(selection);
            } else if (holder.ke.getId() == currentlyFocusedColumn) {
                holder.ke.requestFocus();
                holder.ke.setSelection(selection);
            } else if (holder.ko.getId() == currentlyFocusedColumn) {
                holder.ko.requestFocus();
                holder.ko.setSelection(selection);
            } else if (holder.oms.getId() == currentlyFocusedColumn) {
                holder.oms.requestFocus();
                holder.oms.setSelection(selection);
            } else if (holder.se.getId() == currentlyFocusedColumn) {
                holder.se.requestFocus();
                holder.se.setSelection(selection);
            } else if (holder.sto.getId() == currentlyFocusedColumn) {
                holder.sto.requestFocus();
                holder.sto.setSelection(selection);
            }
        }

        if (position % 2 == 0) {
            holder.antalEnheder.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_white_bg));
            holder.vo.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_white_bg));
            holder.ve.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_white_bg));
            holder.domk.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_white_bg));
            holder.gromk.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_white_bg));
            holder.db.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_white_bg));
            holder.ke.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_white_bg));
            holder.ko.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_white_bg));
            holder.oms.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_white_bg));
            holder.se.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_white_bg));
            holder.sto.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_white_bg));
        } else {
            holder.antalEnheder.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_light_gray_bg));
            holder.vo.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_light_gray_bg));
            holder.ve.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_light_gray_bg));
            holder.domk.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_light_gray_bg));
            holder.gromk.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_light_gray_bg));
            holder.db.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_light_gray_bg));
            holder.ke.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_light_gray_bg));
            holder.ko.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_light_gray_bg));
            holder.oms.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_light_gray_bg));
            holder.se.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_light_gray_bg));
            holder.sto.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_light_gray_bg));
        }
    }

    @Override
    public int getItemCount() {
        if (raekkeArrayList == null) {
            return 0;
        }
        return raekkeArrayList.size();
    }

    public ArrayList<Raekke> getTasks() {
        return raekkeArrayList;
    }


    public void setTasks(ArrayList<Raekke> raekker) {
        this.raekkeArrayList = raekker;
        notifyDataSetChanged();

        // Use these
//        adapter.notifyItemRangeInserted(rangeStart, rangeEnd);
//        adapter.notifyItemRemoved(position);
//        adapter.notifyItemChanged(position);
//        adapter.notifyItemInserted(position);
    }

    private int pos = -2;
    private int id = 0;

    class RowViewHolder extends RecyclerView.ViewHolder {
        private EditText antalEnheder;
        private EditText vo;
        private EditText ve;
        private EditText domk;
        private EditText db;
        private EditText gromk;
        private EditText ke;
        private EditText ko;
        private EditText oms;
        private EditText se;
        private EditText sto;
        private ImageButton imageButtonDelete;
        private ImageButton imageButtonUp;
        private ImageButton imageButtonDown;
        private View.OnFocusChangeListener onFocusChangeListener;

        public RowViewHolder(View itemView) {
            super(itemView);

            // Initialize the EditTexts
            antalEnheder = itemView.findViewById(R.id.edit_text_antal_enheder);
            vo = itemView.findViewById(R.id.edit_text_vo);
            ve = itemView.findViewById(R.id.edit_text_ve);
            domk = itemView.findViewById(R.id.edit_text_domk);
            db = itemView.findViewById(R.id.edit_text_db);
            gromk = itemView.findViewById(R.id.edit_text_gromk);
            ke = itemView.findViewById(R.id.edit_text_ke);
            ko = itemView.findViewById(R.id.edit_text_ko);
            oms = itemView.findViewById(R.id.edit_text_oms);
            se = itemView.findViewById(R.id.edit_text_se);
            sto = itemView.findViewById(R.id.edit_text_sto);

            // Set the width of the EditTexts
            antalEnheder.setWidth(widthInPixels);
            vo.setWidth(widthInPixels);
            ve.setWidth(widthInPixels);
            domk.setWidth(widthInPixels);
            db.setWidth(widthInPixels);
            gromk.setWidth(widthInPixels);
            ke.setWidth(widthInPixels);
            ko.setWidth(widthInPixels);
            oms.setWidth(widthInPixels);
            se.setWidth(widthInPixels);
            sto.setWidth(widthInPixels);


            // Initialize the ImageButtons and set their OnClickListeners
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


            onFocusChangeListener = new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean hasFocus) {

                    EditText editText = null;
                    if (view instanceof EditText)
                        editText = (EditText) view;

                    // Get the right position for the cursor.
                    if (getAdapterPosition() != -1 && hasFocus && (pos != getAdapterPosition() || id != editText.getId())) {
                        currentlyFocusedRow = getAdapterPosition();
                        currentlyFocusedColumn = editText.getId();
                        selection = editText.getSelectionStart();
                        pos = getAdapterPosition();
                        id = editText.getId();
//                        System.out.println("start " + selection);
//                        System.out.println("pos " + pos);
                    }

//                    System.out.println("FocusChanged" + counter++ + " Has focus: " + hasFocus + " Contents " + editText.getText().toString() + " ID: " + editText.getId() + " Pos: " + getAdapterPosition());

                    try {
                        if (getAdapterPosition() != -1 && !hasFocus) {

//                            System.out.println("Adapter not -1, is " + getAdapterPosition());

                            final Raekke raekke = raekkeArrayList.get(getAdapterPosition());

                            double currentAntalEnheder = raekke.getX().getVaerdi();
                            double newAntalEnheder = Double.parseDouble(antalEnheder.getText().toString());

//                        String currentAntalEnhederString = String.valueOf(currentAntalEnheder);
//                        String newAntalEnhederString = antalEnheder.getText().toString();

//                        DecimalFormat decimalFormat = new DecimalFormat();
//                        DecimalFormatSymbols decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
//                        char decimalSeparator = decimalFormatSymbols.getDecimalSeparator();
                            double currentVo = raekke.getVO().getVaerdi();
//                        double newVo = Double.parseDouble(vo.getText().toString());
                            double newVo = Double.parseDouble(vo.getText().toString().replace(".", "").replace(",", "."));
//                        double newVo;
//                        if (decimalSeparator == ',')
//                            newVo = Double.parseDouble(vo.getText().toString().replace(".", "").replace(",", "."));
//                        else
//                            newVo = Double.parseDouble(vo.getText().toString().replace(",", "").replace(".", ","));

//                        String currentVoString = String.format(Locale.GERMAN, "%,.2f", currentVo);
//                        String newVoString = vo.getText().toString();

                            double currentVe = raekke.getVE().getVaerdi();
                            double newVe = Double.parseDouble(ve.getText().toString());

//                        String currentVeString = String.format(Locale.GERMAN, "%,.2f", currentVe);
//                        String newVeString = ve.getText().toString();

                            double currentDomk = raekke.getDOMK().getVaerdi();
                            double newDomk = Double.parseDouble(domk.getText().toString());

//                        String currentDomkString = String.format(Locale.GERMAN, "%,.2f", currentDomk);
//                        String newDomkString = domk.getText().toString();

                            double currentDB = raekke.getDB().getVaerdi();
                            double newDB = Double.parseDouble(db.getText().toString());

                            double currentGromk = raekke.getGROMK().getVaerdi();
                            double newGROMK = Double.parseDouble(gromk.getText().toString());

                            double currentKE = raekke.getKE().getVaerdi();
                            double newKE = Double.parseDouble(ke.getText().toString());

                            double currentKO = raekke.getKO().getVaerdi();
                            double newKO = Double.parseDouble(ko.getText().toString());

                            double currentOMS = raekke.getOMS().getVaerdi();
                            double newOMS = Double.parseDouble(oms.getText().toString());

                            double currentSE = raekke.getSE().getVaerdi();
                            double newSE = Double.parseDouble(se.getText().toString());

                            double currentSTO = raekke.getSTO().getVaerdi();
                            double newSTO = Double.parseDouble(sto.getText().toString());


                            if (currentAntalEnheder != newAntalEnheder && !Double.isNaN(newAntalEnheder)) {
                                System.out.println("X gets changed");
                                raekke.getX().setVaerdi(newAntalEnheder);

                                raekke.getVE().beregn();
                                raekke.getVO().beregn();
                                raekke.getKE().beregn();
                                raekke.getSTO().beregn();
                                raekke.getKO().beregn();
                                raekke.getSE().beregn();


                                if (getAdapterPosition() != 0) {
                                    //TODO TJEK OM RaekkeUnder fungere, ellers fix med en ny if statement.

                                    raekke.getKO().beregn();

                                    raekke.getVO().beregn();

                                    raekke.getSTO().beregn();

                                    raekke.getGROMK().beregn();

                                    raekke.getDOMK().beregn();
                                }

                                new Handler().post(new Runnable() {
                                    @Override
                                    public void run() {
                                        ControllerImpl.getInstance().getTabel().getTabelMld().setValue(raekkeArrayList);
                                    }
                                });
                            }

                            if (currentVo != newVo && !Double.isNaN(newVo)) {
                                System.out.println("VO gets changed");
                                raekke.getVO().setVaerdi(newVo);

                                raekke.getVE().beregn();

                                if (getAdapterPosition() != raekkeArrayList.size() - 1) {
                                    raekke.getX().beregn();
                                    raekke.getKO().beregn();
                                    raekke.getX().beregn();
                                }
                                if (getAdapterPosition() != 0) {
                                    raekke.getSTO().beregn();
                                    raekke.getDOMK().beregn();
                                    raekke.getX().beregn();

                                }


                                new Handler().post(new Runnable() {
                                    @Override
                                    public void run() {
                                        ControllerImpl.getInstance().getTabel().getTabelMld().setValue(raekkeArrayList);
                                    }
                                });
                            }

                            if (currentVe != newVe && !Double.isNaN(newVe)) {
                                System.out.println("VE gets changed");
                                raekke.getVE().setVaerdi(newVe);

                                raekke.getKE().beregn();
                                raekke.getSE().beregn();
                                raekke.getX().beregn();
                                raekke.getVO().beregn();
                                raekke.getSE().beregn();
                                if (getAdapterPosition() != 0) {
                                }

                                new Handler().post(new Runnable() {
                                    @Override
                                    public void run() {
                                        ControllerImpl.getInstance().getTabel().getTabelMld().setValue(raekkeArrayList);
                                    }
                                });
                            }

                            if (currentDomk != newDomk && !Double.isNaN(newDomk)) {
                                System.out.println("DOMK gets changed");
                                raekke.getDOMK().setVaerdi(newDomk);

                                if (getAdapterPosition() != 0) {
                                    raekke.getX().beregn();
                                    raekke.getVO().beregn();
                                }

                                new Handler().post(new Runnable() {
                                    @Override
                                    public void run() {
                                        ControllerImpl.getInstance().getTabel().getTabelMld().setValue(raekkeArrayList);
                                    }
                                });
                            }

                            if (currentDB != newDB && !Double.isNaN(newDB)) {
                                System.out.println("DB gets changed");
                                raekke.getDB().setVaerdi(newDB);


                                if (getAdapterPosition() != 0) {
                                    raekke.getVO().beregn();
                                }


                                new Handler().post(new Runnable() {
                                    @Override
                                    public void run() {
                                        ControllerImpl.getInstance().getTabel().getTabelMld().setValue(raekkeArrayList);
                                    }
                                });
                            }
                            if (currentGromk != newGROMK && !Double.isNaN(newGROMK)) {
                                System.out.println("GROMK gets changed");
                                raekke.getGROMK().setVaerdi(newGROMK);

                                raekke.getSTO().beregn();


                                new Handler().post(new Runnable() {
                                    @Override
                                    public void run() {
                                        ControllerImpl.getInstance().getTabel().getTabelMld().setValue(raekkeArrayList);
                                    }
                                });
                            }

                            if (currentKE != newKE && !Double.isNaN(newKE)) {
                                System.out.println("KE gets changed");
                                raekke.getKE().setVaerdi(newKE);

                                raekke.getKO().beregn();
                                raekke.getX().beregn();
                                raekke.getSE().beregn();
                                raekke.getVE().beregn();

                                new Handler().post(new Runnable() {
                                    @Override
                                    public void run() {
                                        ControllerImpl.getInstance().getTabel().getTabelMld().setValue(raekkeArrayList);
                                    }
                                });
                            }

                            if (currentKO != newKO && !Double.isNaN(newKO)) {
                                System.out.println("KO gets changed");
                                raekke.getKO().setVaerdi(newKO);

                                raekke.getX().beregn();
                                raekke.getKE().beregn();
                                raekke.getSTO().beregn();
                                raekke.getVO().beregn();

                                new Handler().post(new Runnable() {
                                    @Override
                                    public void run() {
                                        ControllerImpl.getInstance().getTabel().getTabelMld().setValue(raekkeArrayList);
                                    }
                                });
                            }

                            if (currentOMS != newOMS && !Double.isNaN(newOMS)) {
                                System.out.println("OMS gets changed");
                                raekke.getOMS().setVaerdi(newOMS);

                                raekke.getVO().beregn();

                                new Handler().post(new Runnable() {
                                    @Override
                                    public void run() {
                                        ControllerImpl.getInstance().getTabel().getTabelMld().setValue(raekkeArrayList);
                                    }
                                });
                            }

                            if (currentSE != newSE && !Double.isNaN(newSE)) {
                                System.out.println("SE gets changed");
                                raekke.getSE().setVaerdi(newSE);

                                raekke.getSTO().beregn();
                                raekke.getX().beregn();
                                raekke.getVE().beregn();
                                raekke.getKE().beregn();


                                new Handler().post(new Runnable() {
                                    @Override
                                    public void run() {
                                        ControllerImpl.getInstance().getTabel().getTabelMld().setValue(raekkeArrayList);
                                    }
                                });
                            }

                            if (currentSTO != newSTO && !Double.isNaN(newSTO)) {
                                System.out.println("STO gets changed");
                                raekke.getSTO().setVaerdi(newSTO);

                                raekke.getX().beregn();
                                raekke.getKO().beregn();
                                raekke.getSE().beregn();
                                if (getAdapterPosition() != 0) {
                                    raekke.getGROMK().beregn();
                                }

                                new Handler().post(new Runnable() {
                                    @Override
                                    public void run() {
                                        ControllerImpl.getInstance().getTabel().getTabelMld().setValue(raekkeArrayList);
                                    }
                                });
                            }


                        }
                    } catch (NumberFormatException e) {
                        Toast toast = Toast.makeText(context, "Der skal stå et tal.", Toast.LENGTH_SHORT);
                        toast.show();
                    } catch (NegativVaerdiException e) {
                        Toast toast = Toast.makeText(context, "Tallet skal være positivt.", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            };

            antalEnheder.setOnFocusChangeListener(onFocusChangeListener);
            vo.setOnFocusChangeListener(onFocusChangeListener);
            ve.setOnFocusChangeListener(onFocusChangeListener);
            domk.setOnFocusChangeListener(onFocusChangeListener);
            db.setOnFocusChangeListener(onFocusChangeListener);
            gromk.setOnFocusChangeListener(onFocusChangeListener);
            ke.setOnFocusChangeListener(onFocusChangeListener);
            ko.setOnFocusChangeListener(onFocusChangeListener);
            oms.setOnFocusChangeListener(onFocusChangeListener);
            se.setOnFocusChangeListener(onFocusChangeListener);
            sto.setOnFocusChangeListener(onFocusChangeListener);


        }

        private void moveUp() {
            viewModel.moveUp(getAdapterPosition());
        }

        private void moveDown() {
            viewModel.moveDown(getAdapterPosition());
        }

        private void deleteRow() {
            if (getAdapterPosition() != -1)
                viewModel.deleteRow(getAdapterPosition());
        }

        private void deleteAll() {
            viewModel.deleteAll();
        }

    }

    int counter = 0;
}
