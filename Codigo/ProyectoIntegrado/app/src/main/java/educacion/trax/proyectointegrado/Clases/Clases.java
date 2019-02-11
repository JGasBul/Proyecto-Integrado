package educacion.trax.proyectointegrado.Clases;

public class Clases {

    private String nombre;
    private String desc;
    private String hist;
    private int atq;
    private int sld;
    private int arm;

    public Clases(String nombre, String desc, String hist, int atq, int sld, int arm) {

        this.nombre=nombre;
        this.desc=desc;
        this.hist=hist;
        this.atq=atq;
        this.sld=sld;
        this.arm=arm;
    }

    public int getArm() {
        return arm;
    }

    public void setArm(int arm) {
        this.arm = arm;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHist() {
        return hist;
    }

    public void setHist(String hist) {
        this.hist = hist;
    }

    public int getAtq() {
        return atq;
    }

    public void setAtq(int atq) {
        this.atq = atq;
    }

    public int getSld() {
        return sld;
    }

    public void setSld(int sld) {
        this.sld = sld;
    }
}
