package dk.kugelberg.hoek_helper.view;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import androidx.recyclerview.widget.RecyclerView;
import dk.kugelberg.hoek_helper.R;
import dk.kugelberg.hoek_helper.model.ControllerImpl;
import dk.kugelberg.hoek_helper.model.NegativVaerdiException;
import dk.kugelberg.hoek_helper.model.Raekke;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.RowViewHolder> {

    private ArrayList<Raekke> raekkeArrayList;
    private Context context;

    private int widthInPixels;
    private int currentlyFocusedRow;
    private int currentlyFocusedColumn;
    private int selection;

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

    public DataAdapter(Context context) {
        this.context = context;

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

        Raekke raekke = raekkeArrayList.get(position);

        double antalEnhederNum = raekke.getX().getVaerdi();
        double voNum = raekke.getVO().getVaerdi();
        double veNum = raekke.getVE().getVaerdi();
        double domkNum = raekke.getDOMK().getVaerdi();

        holder.antalEnheder.setText(String.valueOf(antalEnhederNum));
//        holder.vo.setText(String.valueOf(voNum));
        holder.vo.setText(String.format(Locale.GERMAN, "%,.2f", voNum));
        holder.ve.setText(String.valueOf(veNum));
//        holder.ve.setText(String.format("%.2f", veNum));
        holder.domk.setText(String.valueOf(domkNum));

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
            }
        }

        if (position % 2 == 0) {
            holder.antalEnheder.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_white_bg));
            holder.vo.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_white_bg));
            holder.ve.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_white_bg));
            holder.domk.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_white_bg));
        } else {
            holder.antalEnheder.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_light_gray_bg));
            holder.vo.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_light_gray_bg));
            holder.ve.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_light_gray_bg));
            holder.domk.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_light_gray_bg));
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

            // Set the width of the EditTexts
            antalEnheder.setWidth(widthInPixels);
            vo.setWidth(widthInPixels);
            ve.setWidth(widthInPixels);
            domk.setWidth(widthInPixels);

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
                    EditText editText = (EditText) view;

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

                            if (currentAntalEnheder != newAntalEnheder && !Double.isNaN(newAntalEnheder)) {
                                System.out.println("X gets changed");

                                raekke.getX().setVaerdi(newAntalEnheder);

                                raekke.getVE().init(raekke.getVO(), raekke.getX(), raekke.getSE(), raekke.getKE());
                                raekke.getVE().beregn();

                                if (getAdapterPosition() != 0) {
                                    raekke.getDOMK().init(raekke.getVO(), raekke.getSTO(), raekke.getKO(), raekke.getVE(), raekke.getX());
                                    Raekke raekkeOver = raekkeArrayList.get(getAdapterPosition() - 1);
                                    raekke.getDOMK().initOver(raekkeOver.getVO(), raekkeOver.getX(), raekkeOver.getDOMK());
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

                                raekke.getVE().init(raekke.getVO(), raekke.getX(), raekke.getSE(), raekke.getKE());
                                raekke.getVE().beregn();

                                if (getAdapterPosition() != 0) {
                                    raekke.getDOMK().init(raekke.getVO(), raekke.getSTO(), raekke.getKO(), raekke.getVE(), raekke.getX());
                                    Raekke raekkeOver = raekkeArrayList.get(getAdapterPosition() - 1);
                                    raekke.getDOMK().initOver(raekkeOver.getVO(), raekkeOver.getX(), raekkeOver.getDOMK());
                                    raekke.getDOMK().beregn();
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
        }

        private void moveUp() {
            if (getAdapterPosition() != 0) {
                Collections.swap(raekkeArrayList, getAdapterPosition(), getAdapterPosition() - 1);
                ControllerImpl.getInstance().getTabel().getTabelMld().setValue(raekkeArrayList);
            }
        }

        private void moveDown() {
            if (getAdapterPosition() != raekkeArrayList.size() - 1) {
                Collections.swap(raekkeArrayList, getAdapterPosition(), getAdapterPosition() + 1);
                ControllerImpl.getInstance().getTabel().getTabelMld().setValue(raekkeArrayList);
            }
        }

        private void deleteRow() {
            raekkeArrayList.remove(getAdapterPosition());
            ControllerImpl.getInstance().getTabel().getTabelMld().setValue(raekkeArrayList);
        }

        private void deleteAll() {
            raekkeArrayList.clear();
            ControllerImpl.getInstance().getTabel().getTabelMld().setValue(raekkeArrayList);
        }
    }

    int counter = 0;


}
