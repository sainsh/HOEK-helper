package dk.kugelberg.hoek_helper.view.database;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "data_row")
public class DataRow {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int antalEnheder;
    private double vo;
    private double ve;
    private double domk;

    @Ignore
    public DataRow(int antalEnheder, double vo, double ve, double domk) {
        this.antalEnheder = antalEnheder;
        this.vo = vo;
        this.ve = ve;
        this.domk = domk;
    }

    public DataRow(int id, int antalEnheder, double vo, double ve, double domk) {
        this.id = id;
        this.antalEnheder = antalEnheder;
        this.vo = vo;
        this.ve = ve;
        this.domk = domk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAntalEnheder() {
        return antalEnheder;
    }

    public void setAntalEnheder(int antalEnheder) {
        this.antalEnheder = antalEnheder;
    }

    public double getVo() {
        return vo;
    }

    public void setVo(double vo) {
        this.vo = vo;
    }

    public double getVe() {
        return ve;
    }

    public void setVe(double ve) {
        this.ve = ve;
    }

    public double getDomk() {
        return domk;
    }

    public void setDomk(double domk) {
        this.domk = domk;
    }
}
