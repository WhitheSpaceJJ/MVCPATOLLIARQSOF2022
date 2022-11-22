
package dominio;

import java.io.Serializable;

public class Dado implements Serializable{
    private String cara;

    public Dado() {
    }

    public String getCara() {
        return cara;
    }

    public void setCara(String cara) {
        this.cara = cara;
    }
    public void cambiarCara(){
    }
}
