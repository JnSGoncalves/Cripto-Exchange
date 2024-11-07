package model.moedas;

public class Moedas {
    private String nomeMoeda;
    private int idMoeda;

    public Moedas(String nomeMoeda, int idMoeda) {
        this.nomeMoeda = nomeMoeda;
        this.idMoeda = idMoeda;
    }

    public String getNomeMoeda() {
        return nomeMoeda;
    }
    public void setNomeMoeda(String nomeMoeda) {
        this.nomeMoeda = nomeMoeda;
    }

    public int getIdMoeda() {
        return idMoeda;
    }
    public void setIdMoeda(int idMoeda) {
        this.idMoeda = idMoeda;
    }
}
