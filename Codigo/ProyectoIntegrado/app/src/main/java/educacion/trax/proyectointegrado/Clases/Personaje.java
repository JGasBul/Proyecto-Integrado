package educacion.trax.proyectointegrado.Clases;

import android.os.Parcel;
import android.os.Parcelable;

public class Personaje implements Parcelable {

    private String nombre;
    private String nombreClase;
    private int vida;
    private int danyo;
    private int armadura;
    private int clase;
    private Integer dinero;
    private Integer fase;
    private Integer fase_max;
    private Integer ronda;
    private Objetos obj;

    public Personaje(int clase) {
        this.nombre=null;
        this.clase = clase;
        this.vida=100;
        switch (this.clase){
            case 0: {
                this.danyo = 10;
                this.armadura = 10;
            }break;
            case 1:{
                this.danyo=20;
                this.armadura=0;
            }break;
            case 2:{
                this.danyo=5;
                this.armadura=20;
            }break;
            default:{
                this.danyo = 10;
                this.armadura = 10;
            }
        }
        this.dinero = 0;
        this.fase = 0;
        this.fase_max = 0;
        this.ronda = 0;
        Objetos obj=new Objetos(0,0,0);
        this.obj = obj;
    }

    public Personaje() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDaño() {
        return danyo;
    }

    public void setDaño(int daño) {
        this.danyo = daño;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public String getClase() {
        switch (this.clase){
            case 0: {
                return "Warrior";
            }
            case 1:{
                return "Rogue";
            }
            case 2: {
                return "Tank";
            }
            default:{
                return "Warrior";
            }
        }

    }

    public void setClase(String clase) {
        this.nombreClase = clase;
    }

    public Integer getDinero() {
        return dinero;
    }

    public void setDinero(Integer dinero) {
        this.dinero = dinero;
    }

    public Integer getFase() {
        return fase;
    }

    public void setFase(Integer fase) {
        this.fase = fase;
    }

    public Integer getFase_max() {
        return fase_max;
    }

    public void setFase_max(Integer fase_max) {
        this.fase_max = fase_max;
    }

    public Integer getRonda() {
        return ronda;
    }

    public void setRonda(Integer ronda) {
        this.ronda = ronda;
    }

    public Objetos getObj() {
        return obj;
    }

    public void setObj(Objetos obj) {
        this.obj = obj;
    }

    protected Personaje(Parcel in) {
        nombre = in.readString();
        nombreClase = in.readString();
        vida = in.readInt();
        danyo = in.readInt();
        armadura = in.readInt();
        clase = in.readInt();
        dinero = in.readByte() == 0x00 ? null : in.readInt();
        fase = in.readByte() == 0x00 ? null : in.readInt();
        fase_max = in.readByte() == 0x00 ? null : in.readInt();
        ronda = in.readByte() == 0x00 ? null : in.readInt();
        obj = (Objetos) in.readValue(Objetos.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(nombreClase);
        dest.writeInt(vida);
        dest.writeInt(danyo);
        dest.writeInt(armadura);
        dest.writeInt(clase);
        if (dinero == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(dinero);
        }
        if (fase == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(fase);
        }
        if (fase_max == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(fase_max);
        }
        if (ronda == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(ronda);
        }
        dest.writeValue(obj);
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