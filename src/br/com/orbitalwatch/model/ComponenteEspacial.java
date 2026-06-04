/**
 * Classe abstrata que representa um componente espacial genérico.
 * Serve como base para os sensores do sistema Orbital Watch.
 * 
 * Demonstra o uso de classe abstrata, atributos comuns e métodos concretos.
 */

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
    
/**
 * Método abstrato que obriga as classes filhas a implementarem
 * sua própria forma de verificar o status do componente.
 */
    
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
