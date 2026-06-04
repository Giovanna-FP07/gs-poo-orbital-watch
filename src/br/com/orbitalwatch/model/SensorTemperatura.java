/**
 * Classe que representa um sensor de temperatura.
 * Herda de ComponenteEspacial e implementa a interface Sensor.
 * 
 * Responsável por simular leituras de temperatura e emitir alertas.
 */

package br.com.orbitalwatch.model;

import java.util.Random;

public class SensorTemperatura extends ComponenteEspacial implements Sensor {

    private double limiteAlerta;
    private Random random;

    public SensorTemperatura(int id, String nome, double limiteAlerta) {
        super(id, nome);
        this.limiteAlerta = limiteAlerta;
        this.random = new Random();
    }

/**
 * Gera uma leitura simulada de temperatura utilizando valores aleatórios.
 */
    
    @Override
    public double lerValor() {
        double valor = -20 + random.nextDouble() * 120;
        setTemperatura(valor);
        return valor;
    }

    @Override
    public boolean verificarFuncionamento() {
        return getStatus().equals("LIGADO");
    }

    @Override
    public String retornarTipo() {
        return "Sensor de Temperatura";
    }

/**
 * Verifica o valor da temperatura e exibe o nível de alerta correspondente:
 * NORMAL, ATENÇÃO, ALERTA ou CRÍTICO.
 */
    
    @Override
    public void verificarAlerta() {
        double valor = lerValor();

        System.out.println(retornarTipo() + ": " + valor + " °C");

        if (valor >= limiteAlerta * 1.3) {
            System.out.println("CRÍTICO: Temperatura extremamente acima do limite!");
        } else if (valor >= limiteAlerta) {
            System.out.println("ALERTA: Temperatura acima do limite!");
        } else if (valor >= limiteAlerta * 0.7) {
            System.out.println("ATENÇÃO: Temperatura se aproximando do limite.");
        } else {
            System.out.println("NORMAL: Temperatura dentro dos parâmetros.");
        }
    }

    @Override
    public void verificarStatus() {
        System.out.println(getNome() + " está " + getStatus());
    }
}
