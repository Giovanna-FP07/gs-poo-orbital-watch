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

    public String getCoordenadas(String codigoInformado) {
        if (this.codigoAcesso.equals(codigoInformado)) {
            return this.coordenadas;
        }

        return "Acesso negado: código inválido.";
    }

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

    public void exibirResumo(String codigoInformado) {
        System.out.println("\n=== DADOS DA MISSÃO ===");
        System.out.println("Coordenadas: " + getCoordenadas(codigoInformado));
        System.out.println("Combustível: " + this.nivelCombustivel + "%");
        System.out.println("Trajetória: " + this.trajetoria);
        System.out.println("Tripulantes: " + this.numeroTripulantes);
    }
}