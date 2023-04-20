import java.util.Objects;
import java.util.Scanner;
public class tictactoe {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Jogo da velha\n");
            System.out.println("""
                _|_|_
                _|_|_
                 | |
                            """);
                                //0      1     2
            String[][] teste = {{"_|", "_|", "_"}, //0
                                {"_|", "_|", "_"}, //1
                                {" |", " |", " "}}; //2

            int vidas = 9;
            while (vidas > 0) {
                if (vidas % 2 == 0) {
                    while (true) {
                        System.out.println("Jogador X");
                        System.out.println("Digite o número da coluna");
                        int colunaX = sc.nextInt();
                        System.out.println("Digite o número da linha");
                        int linhaX = sc.nextInt();
                        if (Objects.equals(teste[linhaX][colunaX], "_|") || Objects.equals(teste[linhaX][colunaX], " |")) {
                            teste[linhaX][colunaX] = "X|";
                            for (int i = 0; i < 100; ++i)
                                System.out.println();
                            MostraJogo(teste);
                            System.out.println("\n");
                            vidas--;
                            break;
                        } else if (Objects.equals(teste[linhaX][colunaX], " ") || Objects.equals(teste[linhaX][colunaX], "_")) {
                            teste[linhaX][colunaX] = "X";
                            for (int i = 0; i < 100; ++i)
                                System.out.println();
                            MostraJogo(teste);
                            System.out.println("\n");
                            vidas--;
                            break;
                        } else {
                            System.out.println("Essa posição não está disponível");
                        }
                    }
                    if (ValidaVencedorX(teste)) {
                        System.out.println("Jogador X venceu!!!");
                        break;
                    }

                } else {
                    while (true) {
                        System.out.println("Jogador O:");
                        System.out.println("Digite o número da coluna: ");
                        int colunaO = sc.nextInt();
                        System.out.println("Digite o número da linha: ");
                        int linhaO = sc.nextInt();
                        if (Objects.equals(teste[linhaO][colunaO], "_|") || Objects.equals(teste[linhaO][colunaO], " |")) {
                            teste[linhaO][colunaO] = "O|";
                            for (int i = 0; i < 100; ++i)
                                System.out.println();
                            MostraJogo(teste);
                            System.out.println("\n");
                            vidas--;
                            break;
                        } else if (Objects.equals(teste[linhaO][colunaO], "|_") ||
                                Objects.equals(teste[linhaO][colunaO], " ") || Objects.equals(teste[linhaO][colunaO], "_")) {
                            teste[linhaO][colunaO] = "O";
                            for (int i = 0; i < 100; ++i)
                                System.out.println();
                            MostraJogo(teste);
                            System.out.println("\n");
                            vidas--;
                            break;
                        } else {
                            System.out.println("Essa posição não está disponível");
                        }
                    }
                    if (ValidaVencedorO(teste)) {
                        System.out.println("Jogador O venceu!!!");
                        break;
                    }
                }
            }
            if (ValidaVencedorX(teste) || ValidaVencedorO(teste)){
                System.out.println();
            }else{
                System.out.println("Deu velha!!");
            }
        }

        public static void MostraJogo(String[][] teste) {
            for (int j = 0; j < 3; j++) {
                System.out.println("\t");
                for (int i = 0; i < 3; i++) {
                    System.out.print(teste[j][i]);
                }
            }
        }

        public static boolean ValidaVencedorX(String[][] teste) {
            if (Objects.equals(teste[0][0], "X|") && Objects.equals(teste[0][1], "X|") && Objects.equals(teste[0][2], "X")) {
                return true;
            } else if (Objects.equals(teste[1][0], "X|") && Objects.equals(teste[1][1], "X|") && Objects.equals(teste[1][2], "X")) {
                return true;
            } else if (Objects.equals(teste[2][0], "X|") && Objects.equals(teste[2][1], "X|") && Objects.equals(teste[2][2], "X")) {
                return true;
            } else if (Objects.equals(teste[0][0], "X|") && Objects.equals(teste[1][0], "X|") && Objects.equals(teste[2][0], "X|")) {
                return true;
            } else if (Objects.equals(teste[0][1], "X|") && Objects.equals(teste[1][1], "X|") && Objects.equals(teste[2][1], "X|")) {
                return true;
            } else if (Objects.equals(teste[0][2], "X") && Objects.equals(teste[1][2], "X") && Objects.equals(teste[2][2], "X")) {
                return true;
            } else if (Objects.equals(teste[0][0], "X|") && Objects.equals(teste[1][1], "X|") && Objects.equals(teste[2][2], "X")) {
                return true;
            } else return Objects.equals(teste[0][2], "X") && Objects.equals(teste[1][1], "X|") && Objects.equals(teste[2][0], "X|");
        }

        public static boolean ValidaVencedorO(String[][] teste) {
            if (Objects.equals(teste[0][0], "O|") && Objects.equals(teste[0][1], "O|") && Objects.equals(teste[0][2], "O")) {
                return true;
            } else if (Objects.equals(teste[1][0], "O|") && Objects.equals(teste[1][1], "O|") && Objects.equals(teste[1][2], "O")) {
                return true;
            } else if (Objects.equals(teste[2][0], "O|") && Objects.equals(teste[2][1], "O|") && Objects.equals(teste[2][2], "O")) {
                return true;
            } else if (Objects.equals(teste[0][0], "O|") && Objects.equals(teste[1][0], "O|") && Objects.equals(teste[2][0], "O|")) {
                return true;
            } else if (Objects.equals(teste[0][1], "O|") && Objects.equals(teste[1][1], "O|") && Objects.equals(teste[2][1], "O|")) {
                return true;
            } else if (Objects.equals(teste[0][2], "O") && Objects.equals(teste[1][2], "O") && Objects.equals(teste[2][2], "O")) {
                return true;
            } else if (Objects.equals(teste[0][0], "O|") && Objects.equals(teste[1][1], "O|") && Objects.equals(teste[2][2], "O")) {
                return true;
            } else return Objects.equals(teste[0][2], "O") && Objects.equals(teste[1][1], "O|") && Objects.equals(teste[2][0], "O|");
        }
    }

