package br.com.orbitalwatch.model;

public abstract class ComponenteEspacial {

    private int id;
    private String nome;
    private String status;
    private double temperatura;

    public ComponenteEspacial(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.status = "DESLIGADO";
        this.temperatura = 0.0;
    }

    public void ligar() {
        this.status = "LIGADO";
    }

    public void desligar() {
        this.status = "DESLIGADO";
    }

    public abstract void verificarStatus();

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getStatus() {
        return status;
    }

    public double getTemperatura() {
        return temperatura;
    }

    protected void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
}