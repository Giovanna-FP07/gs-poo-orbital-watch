/**
 * Classe que representa um sensor de radiação.
 * Herda de ComponenteEspacial e implementa a interface Sensor.
 * 
 * Responsável por simular leituras de radiação e emitir alertas.
 */

package br.com.orbitalwatch.model;

import java.util.Random;

public class SensorRadiacao extends ComponenteEspacial implements Sensor {

    private double limiteAlerta;
    private Random random;

    public SensorRadiacao(int id, String nome, double limiteAlerta) {
        super(id, nome);
        this.limiteAlerta = limiteAlerta;
        this.random = new Random();
    }

/**
 * Gera uma leitura simulada de radiação utilizando valores aleatórios.
 */
    
    @Override
    public double lerValor() {
        return random.nextDouble() * 10;
    }

    @Override
    public boolean verificarFuncionamento() {
        return getStatus().equals("LIGADO");
    }

    @Override
    public String retornarTipo() {
        return "Sensor de Radiação";
    }

/**
 * Verifica o valor da radiação e exibe o nível de alerta correspondente:
 * NORMAL, ATENÇÃO, ALERTA ou CRÍTICO.
 */
    
    @Override
    public void verificarAlerta() {
        double valor = lerValor();

        System.out.println(retornarTipo() + ": " + valor + " mSv");

        if (valor >= limiteAlerta * 1.3) {
            System.out.println("CRÍTICO: Radiação extremamente acima do limite!");
        } else if (valor >= limiteAlerta) {
            System.out.println("ALERTA: Radiação acima do limite!");
        } else if (valor >= limiteAlerta * 0.7) {
            System.out.println("ATENÇÃO: Radiação se aproximando do limite.");
        } else {
            System.out.println("NORMAL: Radiação dentro dos parâmetros.");
        }
    }

    @Override
    public void verificarStatus() {
        System.out.println(getNome() + " está " + getStatus());
    }
}
