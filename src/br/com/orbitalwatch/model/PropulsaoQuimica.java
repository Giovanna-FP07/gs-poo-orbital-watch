package br.com.orbitalwatch.model;

public class PropulsaoQuimica extends SistemaPropulsao {

    private double consumoCombustivelPorSegundo;

    public PropulsaoQuimica(String nome, double consumoCombustivelPorSegundo) {
        super(nome);
        this.consumoCombustivelPorSegundo = consumoCombustivelPorSegundo;
    }

    @Override
    public void acelerar(double percentual) {
        if (!validarPotencia(percentual)) {
            return;
        }

        setPotenciaAtual(percentual);
        System.out.println(getNome() + " acelerando com propulsão química em " + percentual + "%.");
    }

    @Override
    public double calcularEmpuxo() {
        return getPotenciaAtual() * consumoCombustivelPorSegundo * 10;
    }
}