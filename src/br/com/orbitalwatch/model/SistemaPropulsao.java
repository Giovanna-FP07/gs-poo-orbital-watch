/**
 * Classe abstrata que representa um sistema de propulsão genérico.
 * 
 * Serve como base para diferentes tipos de propulsão e demonstra
 * herança, métodos concretos e métodos abstratos.
 */

package br.com.orbitalwatch.model;

public abstract class SistemaPropulsao {

    private String nome;
    private String status;
    private double potenciaAtual;

    public SistemaPropulsao(String nome) {
        this.nome = nome;
        this.status = "DESLIGADO";
        this.potenciaAtual = 0.0;
    }

    public void ligar() {
        this.status = "LIGADO";
        System.out.println(this.nome + " ligado.");
    }

    public void desligar() {
        this.status = "DESLIGADO";
        this.potenciaAtual = 0.0;
        System.out.println(this.nome + " desligado.");
    }

/**
 * Método abstrato que obriga cada tipo de propulsão a implementar
 * sua própria forma de aceleração.
 */
    
    public abstract void acelerar(double percentual);

/**
 * Método abstrato que obriga cada tipo de propulsão a calcular
 * o empuxo de acordo com sua própria regra.
 */
    
    public abstract double calcularEmpuxo();

/**
 * Valida se a potência informada está dentro do intervalo permitido de 0 a 100%.
 */
    
    protected boolean validarPotencia(double percentual) {
        if (percentual < 0 || percentual > 100) {
            System.out.println("Erro: potência deve estar entre 0 e 100%.");
            return false;
        }

        return true;
    }

    public String getNome() {
        return this.nome;
    }

    public String getStatus() {
        return this.status;
    }

    public double getPotenciaAtual() {
        return this.potenciaAtual;
    }

    protected void setPotenciaAtual(double potenciaAtual) {
        this.potenciaAtual = potenciaAtual;
    }
}
