package observer;

import java.util.Observable;
import java.util.Observer;

public class Proprietario implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Proprietario(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void cadastrar(Modelo modelo) {
        modelo.addObserver(this);
    }

    public void update(Observable modelo, Object arg1) {
        this.ultimaNotificacao = this.nome + ", recall convocado no " + modelo.toString();
        // System.out.println(this.ultimaNotificacao);
    }
}
