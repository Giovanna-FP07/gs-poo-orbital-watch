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