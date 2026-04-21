import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ComposicaoFerroviaria cf = new ComposicaoFerroviaria(200, "composicao.dat");

        int op;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Criar composição padrão");
            System.out.println("2 - Inserir vagão");
            System.out.println("3 - Remover vagão");
            System.out.println("4 - Diagnóstico");
            System.out.println("5 - Mostrar primeiro vagão");
            System.out.println("6 - Mostrar último vagão");
            System.out.println("7 - Sair");
            System.out.print("Escolha: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    cf.criarComposicaoPadrao();
                    System.out.println("Composição padrão criada.");
                    break;

                case 2:
                    System.out.println("1 - Inserir no início");
                    System.out.println("2 - Inserir no fim");
                    int pos = sc.nextInt();

                    System.out.println("1 - Locomotiva");
                    System.out.println("2 - Passageiro");
                    System.out.println("3 - Carga");
                    int tipo = sc.nextInt();

                    Vagao v = null;

                    if (tipo == 1) {
                        System.out.print("Comprimento (18 a 23): ");
                        double c = sc.nextDouble();

                        System.out.print("Peso (100 a 200): ");
                        double p = sc.nextDouble();

                        System.out.print("Potência (2000 a 6000): ");
                        double hp = sc.nextDouble();

                        if (c < 18 || c > 23) {
                            System.out.println("Comprimento inválido para locomotiva.");
                        } else if (p < 100 || p > 200) {
                            System.out.println("Peso inválido para locomotiva.");
                        } else if (hp < 2000 || hp > 6000) {
                            System.out.println("Potência inválida para locomotiva.");
                        } else {
                            v = new Locomotiva(c, p, hp);
                        }
                    }

                    else if (tipo == 2) {
                        System.out.print("Comprimento (22 a 26): ");
                        double c = sc.nextDouble();

                        System.out.print("Peso (30 a 50): ");
                        double p = sc.nextDouble();

                        System.out.print("Número de passageiros (0 a 50): ");
                        int n = sc.nextInt();

                        if (c < 22 || c > 26) {
                            System.out.println("Comprimento inválido para vagão de passageiros.");
                        } else if (p < 30 || p > 50) {
                            System.out.println("Peso inválido para vagão de passageiros.");
                        } else if (n < 0 || n > 50) {
                            System.out.println("Número de passageiros inválido.");
                        } else {
                            v = new Passageiro(c, p, n);
                        }
                    }

                    else if (tipo == 3) {
                        System.out.print("Comprimento (12 a 19): ");
                        double c = sc.nextDouble();

                        System.out.print("Peso (15 a 30): ");
                        double p = sc.nextDouble();

                        if (c < 12 || c > 19) {
                            System.out.println("Comprimento inválido para vagão de carga.");
                        } else if (p < 15 || p > 30) {
                            System.out.println("Peso inválido para vagão de carga.");
                        } else {
                            v = new Carga(c, p);
                        }
                    }

                    else {
                        System.out.println("Tipo de vagão inválido.");
                    }

                    if (v != null) {
                        if (pos == 1) {
                            cf.inserirInicio(v);
                            System.out.println("Vagão inserido no início.");
                        } else if (pos == 2) {
                            cf.inserirFim(v);
                            System.out.println("Vagão inserido no fim.");
                        } else {
                            System.out.println("Posição inválida.");
                        }
                    }

                    break;

                case 3:
                    System.out.println("1 - Remover do início");
                    System.out.println("2 - Remover do fim");
                    int r = sc.nextInt();

                    Vagao removido = null;

                    if (r == 1) {
                        removido = cf.removerInicio();
                    } else if (r == 2) {
                        removido = cf.removerFim();
                    } else {
                        System.out.println("Opção inválida.");
                    }

                    if (removido != null) {
                        System.out.println("Vagão removido:");
                        removido.imprime();
                    } else if (r == 1 || r == 2) {
                        System.out.println("Nenhum vagão removido.");
                    }

                    break;

                case 4:
                    cf.diagnostico();
                    break;

                case 5:
                    Vagao primeiro = cf.getPrimeiroVagao();
                    if (primeiro != null) {
                        System.out.println("Primeiro vagão:");
                        primeiro.imprime();
                    } else {
                        System.out.println("Composição vazia.");
                    }
                    break;

                case 6:
                    Vagao ultimo = cf.getUltimoVagao();
                    if (ultimo != null) {
                        System.out.println("Último vagão:");
                        ultimo.imprime();
                    } else {
                        System.out.println("Composição vazia.");
                    }
                    break;

                case 7:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (op != 7);

        sc.close();
    }
}