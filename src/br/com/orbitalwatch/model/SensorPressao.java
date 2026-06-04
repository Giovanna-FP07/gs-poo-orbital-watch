/**
 * Classe que representa um sensor de pressão.
 * Herda de ComponenteEspacial e implementa a interface Sensor.
 * 
 * Responsável por simular leituras de pressão e emitir alertas.
 */

package br.com.orbitalwatch.model;

import java.util.Random;

public class SensorPressao extends ComponenteEspacial implements Sensor {

    private double limiteAlerta;
    private Random random;

    public SensorPressao(int id, String nome, double limiteAlerta) {
        super(id, nome);
        this.limiteAlerta = limiteAlerta;
        this.random = new Random();
    }

/**
 * Gera uma leitura simulada de pressão utilizando valores aleatórios.
 */
    
    @Override
    public double lerValor() {
        return 80 + random.nextDouble() * 80;
    }

    @Override
    public boolean verificarFuncionamento() {
        return getStatus().equals("LIGADO");
    }

    @Override
    public String retornarTipo() {
        return "Sensor de Pressão";
    }

/**
 * Verifica o valor da pressão e exibe o nível de alerta correspondente:
 * NORMAL, ATENÇÃO, ALERTA ou CRÍTICO.
 */
    
    @Override
    public void verificarAlerta() {
        double valor = lerValor();

        System.out.println(retornarTipo() + ": " + valor + " kPa");

        if (valor >= limiteAlerta * 1.3) {
            System.out.println("CRÍTICO: Pressão extremamente acima do limite!");
        } else if (valor >= limiteAlerta) {
            System.out.println("ALERTA: Pressão acima do limite!");
        } else if (valor >= limiteAlerta * 0.7) {
            System.out.println("ATENÇÃO: Pressão se aproximando do limite.");
        } else {
            System.out.println("NORMAL: Pressão dentro dos parâmetros.");
        }
    }

    @Override
    public void verificarStatus() {
        System.out.println(getNome() + " está " + getStatus());
    }
}
