/**
 * Classe que representa um sistema de propulsão química.
 * Herda de SistemaPropulsao e implementa regras específicas de aceleração e empuxo.
 */

package br.com.orbitalwatch.model;

public class PropulsaoQuimica extends SistemaPropulsao {

    private double consumoCombustivelPorSegundo;

    public PropulsaoQuimica(String nome, double consumoCombustivelPorSegundo) {
        super(nome);
        this.consumoCombustivelPorSegundo = consumoCombustivelPorSegundo;
    }

/**
 * Acelera o motor químico após validar a potência informada.
 */
    
    @Override
    public void acelerar(double percentual) {
        if (!validarPotencia(percentual)) {
            return;
        }

        setPotenciaAtual(percentual);
        System.out.println(getNome() + " acelerando com propulsão química em " + percentual + "%.");
    }

/**
 * Calcula o empuxo gerado pela propulsão química.
 */
    
    @Override
    public double calcularEmpuxo() {
        return getPotenciaAtual() * consumoCombustivelPorSegundo * 10;
    }
}
