package educacion.trax.proyectointegrado.Clases;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Toast;

/**
 * Created by Pepeg on 06/02/2019.
 */

public class Objetos implements Parcelable {
    private Integer lvl_arma;
    private Integer lvl_armadura;
    private Integer pociones;

    public Objetos(Integer lvl_arma, Integer lvl_armadura, Integer pociones) {
        this.lvl_arma = lvl_arma;
        this.lvl_armadura = lvl_armadura;
        if (pociones>3){
            this.pociones=3;
        }else {
            this.pociones = pociones;
        }
    }

    public Objetos() {
    }

    public Integer getLvl_arma() {
        return lvl_arma;
    }

    public void setLvl_arma(Integer lvl_arma) {
        this.lvl_arma = lvl_arma;
    }

    public Integer getLvl_armadura() {
        return lvl_armadura;
    }

    public void setLvl_armadura(Integer lvl_armadura) {
        this.lvl_armadura = lvl_armadura;
    }

    public Integer getPociones() {
        return pociones;
    }

    public void setPociones(Integer pociones) {
        if (pociones>3){
            this.pociones=3;
        }else {
            this.pociones = pociones;
        }
    }

    protected Objetos(Parcel in) {
        lvl_arma = in.readByte() == 0x00 ? null : in.readInt();
        lvl_armadura = in.readByte() == 0x00 ? null : in.readInt();
        pociones = in.readByte() == 0x00 ? null : in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (lvl_arma == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(lvl_arma);
        }
        if (lvl_armadura == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(lvl_armadura);
        }
        if (pociones == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(pociones);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Objetos> CREATOR = new Parcelable.Creator<Objetos>() {
        @Override
        public Objetos createFromParcel(Parcel in) {
            return new Objetos(in);
        }

        @Override
        public Objetos[] newArray(int size) {
            return new Objetos[size];
        }
    };
}