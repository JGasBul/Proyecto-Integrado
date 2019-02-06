package educacion.trax.proyectointegrado.Clases;

import android.os.Parcel;
import android.os.Parcelable;

public class Personaje implements Parcelable {
   private String nombre;
   private Integer vidaHP;
   private Integer ataquePuntos;
   private Integer armaduraPuntos;
   private String clase;
   private Integer oro;
   private  Integer fase;
   private  Integer ronda;
   private  Integer faseTop;
   private Integer rondaTop;
   private  Integer arma;
   private Integer armaduraObjeto;
   private Integer pocion;

    public Personaje() {

    }

    public Personaje(String nombre, String clase) {
        this.nombre = nombre;
        this.clase = clase;
        if(clase.equals("Warrior")){
            this.vidaHP=100;
            this.ataquePuntos=100;

        }else if (clase.equals("Assassin")){
            this.vidaHP=80;
            this.ataquePuntos=120;
        }else if (clase.equals("Tank")){
            this.vidaHP=120;
            this.ataquePuntos=80;
        }
        this.armaduraPuntos=0;
        this.oro=0;
        this.faseTop=0;
        this.fase=0;
        this.rondaTop=0;
        this.ronda=0;
        this.arma=0;
        this.armaduraObjeto=0;
        this.pocion=0;
    }

    protected Personaje(Parcel in) {
        nombre = in.readString();
        vidaHP = in.readByte() == 0x00 ? null : in.readInt();
        ataquePuntos = in.readByte() == 0x00 ? null : in.readInt();
        armaduraPuntos = in.readByte() == 0x00 ? null : in.readInt();
        clase = in.readString();
        oro = in.readByte() == 0x00 ? null : in.readInt();
        fase = in.readByte() == 0x00 ? null : in.readInt();
        ronda = in.readByte() == 0x00 ? null : in.readInt();
        faseTop = in.readByte() == 0x00 ? null : in.readInt();
        rondaTop = in.readByte() == 0x00 ? null : in.readInt();
        arma = in.readByte() == 0x00 ? null : in.readInt();
        armaduraObjeto = in.readByte() == 0x00 ? null : in.readInt();
        pocion = in.readByte() == 0x00 ? null : in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        if (vidaHP == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(vidaHP);
        }
        if (ataquePuntos == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(ataquePuntos);
        }
        if (armaduraPuntos == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(armaduraPuntos);
        }
        dest.writeString(clase);
        if (oro == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(oro);
        }
        if (fase == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(fase);
        }
        if (ronda == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(ronda);
        }
        if (faseTop == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(faseTop);
        }
        if (rondaTop == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(rondaTop);
        }
        if (arma == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(arma);
        }
        if (armaduraObjeto == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(armaduraObjeto);
        }
        if (pocion == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(pocion);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Personaje> CREATOR = new Parcelable.Creator<Personaje>() {
        @Override
        public Personaje createFromParcel(Parcel in) {
            return new Personaje(in);
        }

        @Override
        public Personaje[] newArray(int size) {
            return new Personaje[size];
        }
    };
}