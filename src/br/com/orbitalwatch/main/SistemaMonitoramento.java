package br.com.orbitalwatch.main;

import java.util.Scanner;
import br.com.orbitalwatch.model.*;

public class SistemaMonitoramento {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SensorTemperatura sensorTemp =
                new SensorTemperatura(1, "TEMP-01", 70);

        SensorPressao sensorPressao =
                new SensorPressao(2, "PRESS-01", 120);

        SensorRadiacao sensorRadiacao =
                new SensorRadiacao(3, "RAD-01", 7);

        sensorTemp.ligar();
        sensorPressao.ligar();
        sensorRadiacao.ligar();

        DadosMissao missao = new DadosMissao(
                "Órbita Terrestre Baixa",
                "FIAP2026",
                65,
                "Terra -> Órbita",
                4
        );

        SistemaPropulsao propulsaoQuimica =
                new PropulsaoQuimica("Motor Químico X1", 12);

        SistemaPropulsao propulsaoEletrica =
                new PropulsaoEletrica("Motor Elétrico E1", 18);

        int opcao;

        do {
            System.out.println("\n================================");
            System.out.println(" ORBITAL WATCH");
            System.out.println(" Plataforma de Monitoramento");
            System.out.println("================================");
            System.out.println("1 - Verificar sensores");
            System.out.println("2 - Controlar propulsão");
            System.out.println("3 - Exibir dados da missão");
            System.out.println("4 - Simular alerta de combustível");
            System.out.println("5 - Exibir status completo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    verificarSensores(sensorTemp, sensorPressao, sensorRadiacao);
                    break;

                case 2:
                    controlarPropulsao(scanner, propulsaoQuimica, propulsaoEletrica);
                    break;

                case 3:
                    System.out.print("Digite o código de acesso: ");
                    String codigo = scanner.next();
                    missao.exibirResumo(codigo);
                    break;

                case 4:
                    simularAlertaCombustivel(scanner, missao);
                    break;

                case 5:
                    exibirStatusCompleto(
                            sensorTemp,
                            sensorPressao,
                            sensorRadiacao,
                            missao,
                            propulsaoQuimica,
                            propulsaoEletrica
                    );
                    break;

                case 0:
                    System.out.println("\nSistema encerrado.");
                    break;

                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    public static void verificarSensores(
            SensorTemperatura sensorTemp,
            SensorPressao sensorPressao,
            SensorRadiacao sensorRadiacao
    ) {
        System.out.println("\n=== VERIFICAÇÃO DOS SENSORES ===");

        sensorTemp.verificarAlerta();
        sensorPressao.verificarAlerta();
        sensorRadiacao.verificarAlerta();
    }

    public static void controlarPropulsao(
            Scanner scanner,
            SistemaPropulsao propulsaoQuimica,
            SistemaPropulsao propulsaoEletrica
    ) {
        System.out.println("\n=== CONTROLE DE PROPULSÃO ===");
        System.out.println("1 - Propulsão Química");
        System.out.println("2 - Propulsão Elétrica");
        System.out.print("Escolha o tipo de propulsão: ");

        int tipo = scanner.nextInt();

        SistemaPropulsao propulsaoEscolhida;

        if (tipo == 1) {
            propulsaoEscolhida = propulsaoQuimica;
        } else if (tipo == 2) {
            propulsaoEscolhida = propulsaoEletrica;
        } else {
            System.out.println("Tipo de propulsão inválido.");
            return;
        }

        propulsaoEscolhida.ligar();

        System.out.print("Digite a potência desejada (0 a 100): ");
        double potencia = scanner.nextDouble();

        propulsaoEscolhida.acelerar(potencia);

        System.out.println("Empuxo gerado: " + propulsaoEscolhida.calcularEmpuxo());
    }

    public static void simularAlertaCombustivel(
            Scanner scanner,
            DadosMissao missao
    ) {
        System.out.println("\n=== SIMULAÇÃO DE COMBUSTÍVEL ===");
        System.out.print("Digite o novo nível de combustível (0 a 100): ");

        double combustivel = scanner.nextDouble();

        missao.setNivelCombustivel(combustivel);
    }

    public static void exibirStatusCompleto(
            SensorTemperatura sensorTemp,
            SensorPressao sensorPressao,
            SensorRadiacao sensorRadiacao,
            DadosMissao missao,
            SistemaPropulsao propulsaoQuimica,
            SistemaPropulsao propulsaoEletrica
    ) {
        System.out.println("\n=== STATUS COMPLETO DO SISTEMA ===");

        System.out.println("\nSensores:");
        sensorTemp.verificarStatus();
        sensorPressao.verificarStatus();
        sensorRadiacao.verificarStatus();

        missao.exibirResumo("FIAP2026");

        System.out.println("\nPropulsão:");
        System.out.println(propulsaoQuimica.getNome() + " - " + propulsaoQuimica.getStatus());
        System.out.println("Potência: " + propulsaoQuimica.getPotenciaAtual() + "%");
        System.out.println("Empuxo: " + propulsaoQuimica.calcularEmpuxo());

        System.out.println();

        System.out.println(propulsaoEletrica.getNome() + " - " + propulsaoEletrica.getStatus());
        System.out.println("Potência: " + propulsaoEletrica.getPotenciaAtual() + "%");
        System.out.println("Empuxo: " + propulsaoEletrica.calcularEmpuxo());
    }
}