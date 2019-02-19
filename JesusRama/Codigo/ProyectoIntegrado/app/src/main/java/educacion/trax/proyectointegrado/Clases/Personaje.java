package educacion.trax.proyectointegrado.Clases;

public class Personaje{

private String nombre;

private int vida;
private int daño;
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
                this.daño = 10;
                this.armadura = 10;
            }break;
            case 1:{
                this.daño=20;
                this.armadura=0;
            }break;
            case 2:{
                this.daño=5;
                this.armadura=20;
            }break;
            default:{
                this.daño = 10;
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
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
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

    public void setClase(int clase) {
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