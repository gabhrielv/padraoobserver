package observer;

import java.util.Observable;

public class Modelo extends Observable {

    private Integer ano;
    private String montadora;
    private String nomeModelo;
    private String versao;

    public Modelo(Integer ano, String montadora, String nomeModelo, String versao) {
        this.ano = ano;
        this.montadora = montadora;
        this.nomeModelo = nomeModelo;
        this.versao = versao;
    }

    public void convocarRecall() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Modelo{" +
                "ano=" + ano +
                ", montadora='" + montadora + '\'' +
                ", nomeModelo='" + nomeModelo + '\'' +
                ", versao='" + versao + '\'' +
                '}';
    }
}
