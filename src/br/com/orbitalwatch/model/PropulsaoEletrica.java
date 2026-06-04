package br.com.orbitalwatch.model;

public class PropulsaoEletrica extends SistemaPropulsao {

    private double eficienciaEnergetica;

    public PropulsaoEletrica(String nome, double eficienciaEnergetica) {
        super(nome);
        this.eficienciaEnergetica = eficienciaEnergetica;
    }

    @Override
    public void acelerar(double percentual) {
        if (!validarPotencia(percentual)) {
            return;
        }

        setPotenciaAtual(percentual);
        System.out.println(getNome() + " acelerando com propulsão elétrica em " + percentual + "%.");
    }

    @Override
    public double calcularEmpuxo() {
        return getPotenciaAtual() * eficienciaEnergetica * 6;
    }
}