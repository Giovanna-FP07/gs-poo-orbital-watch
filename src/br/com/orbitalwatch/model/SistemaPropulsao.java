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

    public abstract void acelerar(double percentual);

    public abstract double calcularEmpuxo();

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