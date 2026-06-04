package br.com.orbitalwatch.model;

public interface Sensor {

    double lerValor();

    boolean verificarFuncionamento();

    String retornarTipo();

    void verificarAlerta();
}