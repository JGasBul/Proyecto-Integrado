package educacion.trax.proyectointegrado.clases;


import android.os.Parcel;
import android.os.Parcelable;

public class Personaje implements Parcelable {
    String nombre;

    Integer vidaHP;
    Integer ataquePuntos;
    Integer armaduraPuntos;


    String clase;
    Integer oro;
    Integer fase;
    Integer ronda;
    Integer faseTop;
    Integer rondaTop;



    Integer arma;
    Integer armaduraObjeto;
    Integer pocion;


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




    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getVidaHP() {
        return vidaHP;
    }

    public void setVidaHP(Integer vidaHP) {
        this.vidaHP = vidaHP;
    }

    public Integer getAtaquePuntos() {
        return ataquePuntos;
    }

    public void setAtaquePuntos(Integer ataquePuntos) {
        this.ataquePuntos = ataquePuntos;
    }

    public Integer getArmaduraPuntos() {
        return armaduraPuntos;
    }

    public void setArmaduraPuntos(Integer armaduraPuntos) {
        this.armaduraPuntos = armaduraPuntos;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Integer getOro() {
        return oro;
    }

    public void setOro(Integer oro) {
        this.oro = oro;
    }

    public Integer getFase() {
        return fase;
    }

    public void setFase(Integer fase) {
        this.fase = fase;
    }

    public Integer getRonda() {
        return ronda;
    }

    public void setRonda(Integer ronda) {
        this.ronda = ronda;
    }

    public Integer getFaseTop() {
        return faseTop;
    }

    public void setFaseTop(Integer faseTop) {
        this.faseTop = faseTop;
    }

    public Integer getRondaTop() {
        return rondaTop;
    }

    public void setRondaTop(Integer rondaTop) {
        this.rondaTop = rondaTop;
    }

    public Integer getArma() {
        return arma;
    }

    public void setArma(Integer arma) {
        this.arma = arma;
    }

    public Integer getArmaduraObjeto() {
        return armaduraObjeto;
    }

    public void setArmaduraObjeto(Integer armaduraObjeto) {
        this.armaduraObjeto = armaduraObjeto;
    }

    public Integer getPocion() {
        return pocion;
    }

    public void setPocion(Integer pocion) {
        this.pocion = pocion;
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