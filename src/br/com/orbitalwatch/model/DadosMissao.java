/**
 * Classe responsável por armazenar e proteger os dados da missão espacial.
 * 
 * Demonstra o conceito de encapsulamento utilizando atributos privados,
 * validações em setters e proteção de coordenadas por código de acesso.
 */

package br.com.orbitalwatch.model;

public class DadosMissao {

    private String coordenadas;
    private String codigoAcesso;
    private double nivelCombustivel;
    private String trajetoria;
    private int numeroTripulantes;

    public DadosMissao(String coordenadas, String codigoAcesso, double nivelCombustivel,
                       String trajetoria, int numeroTripulantes) {
        this.codigoAcesso = codigoAcesso;
        setCoordenadas(coordenadas, codigoAcesso);
        setNivelCombustivel(nivelCombustivel);
        setTrajetoria(trajetoria);
        setNumeroTripulantes(numeroTripulantes);
    }

/**
 * Retorna as coordenadas da missão apenas se o código de acesso informado for válido.
 */
    
    public String getCoordenadas(String codigoInformado) {
        if (this.codigoAcesso.equals(codigoInformado)) {
            return this.coordenadas;
        }

        return "Acesso negado: código inválido.";
    }

/**
 * Altera as coordenadas da missão somente após validação do código de acesso.
 */
    
    public void setCoordenadas(String coordenadas, String codigoInformado) {
        if (!this.codigoAcesso.equals(codigoInformado)) {
            System.out.println("Acesso negado: não foi possível alterar as coordenadas.");
            return;
        }

        if (coordenadas == null || coordenadas.trim().isEmpty()) {
            System.out.println("Erro: coordenadas inválidas.");
            return;
        }

        this.coordenadas = coordenadas;
    }

/**
 * Atualiza o nível de combustível com validação e emite alertas automáticos
 * quando o combustível estiver abaixo dos limites definidos.
 */
    
    public double getNivelCombustivel() {
        return this.nivelCombustivel;
    }

    public void setNivelCombustivel(double nivelCombustivel) {
        if (nivelCombustivel < 0 || nivelCombustivel > 100) {
            System.out.println("Erro: combustível deve estar entre 0 e 100%.");
            return;
        }

        this.nivelCombustivel = nivelCombustivel;

        if (this.nivelCombustivel < 20) {
            System.out.println("CRÍTICO: Combustível abaixo de 20%!");
        } else if (this.nivelCombustivel < 50) {
            System.out.println("ATENÇÃO: Combustível abaixo de 50%.");
        }
    }

    public String getTrajetoria() {
        return this.trajetoria;
    }

    public void setTrajetoria(String trajetoria) {
        if (trajetoria == null || trajetoria.trim().isEmpty()) {
            System.out.println("Erro: trajetória inválida.");
            return;
        }

        this.trajetoria = trajetoria;
    }

    public int getNumeroTripulantes() {
        return this.numeroTripulantes;
    }

    public void setNumeroTripulantes(int numeroTripulantes) {
        if (numeroTripulantes < 0) {
            System.out.println("Erro: número de tripulantes não pode ser negativo.");
            return;
        }

        this.numeroTripulantes = numeroTripulantes;
    }

/**
 * Exibe um resumo dos dados da missão, respeitando a proteção das coordenadas.
 */
    
    public void exibirResumo(String codigoInformado) {
        System.out.println("\n=== DADOS DA MISSÃO ===");
        System.out.println("Coordenadas: " + getCoordenadas(codigoInformado));
        System.out.println("Combustível: " + this.nivelCombustivel + "%");
        System.out.println("Trajetória: " + this.trajetoria);
        System.out.println("Tripulantes: " + this.numeroTripulantes);
    }
}
