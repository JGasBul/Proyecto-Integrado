package educacion.trax.proyectointegrado.Clases;

/**
 * Created by Pepeg on 06/02/2019.
 */

public class Usuario {
    private String email;
    private String NickName;

    public Usuario(String email, String nickName) {
        this.email = email;
        NickName = nickName;
    }

    public Usuario() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }
}
