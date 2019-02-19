package educacion.trax.proyectointegrado.Clases;

import android.widget.Toast;

/**
 * Created by Pepeg on 06/02/2019.
 */

public class Objetos {
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
}


