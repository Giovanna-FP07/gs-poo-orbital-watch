/**
 * Classe que representa um sistema de propulsão elétrica.
 * Herda de SistemaPropulsao e implementa regras específicas de aceleração e empuxo.
 */

package br.com.orbitalwatch.model;

public class PropulsaoEletrica extends SistemaPropulsao {

    private double eficienciaEnergetica;

    public PropulsaoEletrica(String nome, double eficienciaEnergetica) {
        super(nome);
        this.eficienciaEnergetica = eficienciaEnergetica;
    }

/**
 * Acelera o motor elétrico após validar a potência informada.
 */
    
    @Override
    public void acelerar(double percentual) {
        if (!validarPotencia(percentual)) {
            return;
        }

        setPotenciaAtual(percentual);
        System.out.println(getNome() + " acelerando com propulsão elétrica em " + percentual + "%.");
    }

/**
 * Calcula o empuxo gerado pela propulsão elétrica.
 */
    
    @Override
    public double calcularEmpuxo() {
        return getPotenciaAtual() * eficienciaEnergetica * 6;
    }
}
