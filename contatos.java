import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class contatos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> contatos = new HashMap<>();
        contatos.put("JULIA", "19988862285");
        contatos.put("KETHELYN", "19988862289");
        contatos.put("BYANKA", "19988862295");
        contatos.put("JULIANA", "19968862285");
        contatos.put("VINICIUS", "19988832285");

        System.out.println("O que deseja fazer hoje?");
        while (true) {
            System.out.println();
            int op = menu(sc);
            if (op == 1) {
                System.out.println();
                mostraMenu(contatos);
            } else if (op == 2) {
                System.out.println("Digite o nome do novo contato: ");
                String nome = sc.next().toUpperCase();
                System.out.println("Digite o número do novo contato: ");
                String numero = sc.next();
                contatos.put(nome, numero);
                System.out.println("Contato adicionado!!");
                System.out.println("Lista atualizada: ");
                mostraMenu(contatos);
            } else if(op == 3) {
                System.out.println("Qual o nome do contato que você deseja remover?");
                String nomeRemove = sc.next().toUpperCase();
                contatos.remove(nomeRemove);
                System.out.println("Contato removido!!");
                System.out.println("Lista atualizada: ");
                mostraMenu(contatos);
            }
            else{
                break;
            }
        }
    }

    public static int menu(Scanner sc){
        System.out.println("[1] Lista de contatos\n[2] Adicionar contatos\n[3] Remover contatos\n[4] Sair");
        System.out.print(">>>: ");
        int op = sc.nextInt();
        return op;
    }
    public static void mostraMenu(Map<String, String> contatos){
        System.out.println("+-------------+-------------+");
        System.out.println("|     NOME    |    NÚMERO   |");
        System.out.println("+-------------+-------------+");
        for (Map.Entry<String, String> entrada : contatos.entrySet()) {
            String nome = entrada.getKey();
            String numero = entrada.getValue();
            System.out.printf("|%-13s|%-13s|\n", nome, numero);
        }
        System.out.println("+-----------+--------------+");
    }
}

