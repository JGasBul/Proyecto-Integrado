package educacion.trax.proyectointegrado.Clases;

public class Personaje {
private String clase;
private Integer dinero;
private Integer fase;
private Integer fase_max;
private Integer ronda;
private Objetos obj;

    public Personaje(String clase, Integer dinero, Integer fase, Integer fase_max, Integer ronda) {
        this.clase = clase;
        this.dinero = dinero;
        this.fase = fase;
        this.fase_max = fase_max;
        this.ronda = ronda;
        Objetos obj=new Objetos(0,0,0);
        this.obj = obj;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
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
}