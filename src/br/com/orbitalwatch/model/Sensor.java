/**
 * Interface que define o contrato obrigatório para todos os sensores.
 * Toda classe que implementar Sensor deve possuir métodos de leitura,
 * verificação de funcionamento, retorno de tipo e alerta.
 */

package br.com.orbitalwatch.model;

public interface Sensor {

    double lerValor();

    boolean verificarFuncionamento();

    String retornarTipo();

    void verificarAlerta();
}
