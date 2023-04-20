package exercicios;
import java.util.*;
public class midia_social {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> seguidores_total = new ArrayList<>(Arrays.asList("JULIA", "KETHELYN", "JULIANA", "LUIS", "MATHEUS"));
        System.out.println("Bem vindo a sua conta do Instagram!!");
        System.out.println("O que deseja fazer hoje?");
        while (true) {
            int option = MostraMenu(sc);
            if (option == 1) {
                MostraSeguidor(seguidores_total);
                System.out.println();
            } else if (option == 2) {
                AdicionarSeguidor(sc, seguidores_total);
                System.out.println();
                MostraSeguidor(seguidores_total);
            } else if (option == 3){
                RemoveSeguidor(sc, seguidores_total);
                MostraSeguidor(seguidores_total);
            } else if (option == 4) {
                System.out.println("Você tem " + seguidores_total.size() + " seguidores atualmente.\n");
            } else if (option == 5){
                PesquisaSeguidor(sc, seguidores_total);
            } else{
                break;
            }
        }
    }
    public static void MostraSeguidor(List<String> seguidores_total){

        for(String seguidor : seguidores_total) {
            System.out.printf("|%-11s|\n", seguidor);
        }

    }
    public static int MostraMenu(Scanner sc){
        System.out.println("""
                [1] Ver seguidores
                [2] Adicionar seguidor
                [3] Remover seguidor
                [4] Número de seguidores
                [5] Pesquisar seguidor
                [6] Sair
                """);
        System.out.print(">>>>>>: ");
        return sc.nextInt();
    }
    public static void AdicionarSeguidor(Scanner sc, List<String> seguidores_total){
        System.out.println("Digite o nome do seu novo seguidor: ");
        seguidores_total.add(sc.next().toUpperCase());
    }

    public static void RemoveSeguidor (Scanner sc, List<String> seguidores_total){
        System.out.println("Digite o nome do seguidor que deseja excluir: ");
        while (true) {
            String nomeSeguidor = sc.next().toUpperCase();
            if (seguidores_total.contains(nomeSeguidor)) {
                seguidores_total.remove(nomeSeguidor);
                System.out.println("Seguidor removido com sucesso!!");
                return;
            } else {
                System.out.println("Desculpe, essa pessoa não te segue!!");
                System.out.print("Digite o nome de um seguidor válido: ");
            }
        }
    }
    public static void PesquisaSeguidor(Scanner sc, List<String> seguidores_total){
        System.out.println("Digite o nome do seguidor que você deseja pesquisar");
        if (seguidores_total.contains(sc.next().toUpperCase())){
            System.out.println("Essa pessoa te segue!!!");
        }else {
            System.out.println("Essa pessoa aí não te segue!!");
        }
    }
}