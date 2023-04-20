package exercicios;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class inventario {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Produto> produtoMap = new HashMap<>();
        Produto inicio = new Produto(10.5F, 5);
        produtoMap.put("Arroz", inicio);
        Produto inicio2 = new Produto(20.1F, 2);
        produtoMap.put("Sabão em pó", inicio2);
        while (true) {
            System.out.println();
            System.out.println("""
                    =========Menu=========
                    [1] Exibir inventário
                    [2] Pesquisar produto
                    [3] Adicionar produto
                    [4] Atualizar preço
                    [5] Atualizar quantidade
                    [6] Sair
                    """);
            int op = sc.nextInt();
            if (op == 1) {
                MostraInventario(produtoMap);
            } else if (op == 2) {
                System.out.println("Digite o nome do produto que deseja procurar: ");
                String procuraProduto = sc.next();
                if (produtoMap.containsKey(procuraProduto)) {
                    Produto produto = produtoMap.get(procuraProduto);
                    System.out.println("Nome do produto: " + procuraProduto);
                    System.out.println("Preço: " + produto.getPreco());
                    System.out.println("Quantidade: " + produto.getQuantidade());
                } else {
                    MsgErro();
                }
            } else if (op == 3) {
                System.out.println("Digite o nome do produto que deseja adicionar");
                String nomeProduto = sc.next();
                System.out.println("Digite a quantidade do produto: ");
                int qtdProduto = sc.nextInt();
                System.out.println("Digite o preço do produto: ");
                float precoProduto = sc.nextFloat();
                Produto add = new Produto(precoProduto, qtdProduto);
                produtoMap.put(nomeProduto, add);
                MostraInventario(produtoMap);
            } else if (op == 4) {
                System.out.println("Digite o nome do produto que deseja alterar o preço: ");
                String nomeProduto = sc.next();
                if (produtoMap.containsKey(nomeProduto)) {
                    System.out.println("Digite o novo preço: ");
                    float preco = sc.nextFloat();
                    Produto produto = produtoMap.get(nomeProduto);
                    produto.setPreco(preco);
                    System.out.println("Preço alterado com sucesso!");
                    MostraInventario(produtoMap);
                }
            } else if (op == 5) {
                System.out.println("Digite o nome do produto que deseja alterar a quantidade: ");
                String nomeProduto = sc.next();
                if (produtoMap.containsKey(nomeProduto)) {
                    System.out.println("Digite a quantidade: ");
                    int quantidade = sc.nextInt();
                    Produto produto = produtoMap.get(nomeProduto);
                    produto.setQuantidade(quantidade);
                    System.out.println("Quantidade alterada com sucesso!");
                    MostraInventario(produtoMap);
                }
            } else if (op == 6) {
                break;
            }else{
                System.out.println("Digite uma opção válida! ");
            }
        }
    }
    public static void MostraInventario(Map<String, Produto> produtoMap){
        for (Map.Entry<String, Produto> entry : produtoMap.entrySet()) {
            String nome = entry.getKey();
            Produto produto = entry.getValue();
            System.out.println("Nome produto: " + nome + "\nPreço: " + produto.getPreco() + "\nQuantidade: " + produto.getQuantidade());
            System.out.println("____________________");
        }
    }
    public static void MsgErro(){
        System.out.println("Este produto não está incluso.");
    }
}
class Produto{
    private float preco;
    private int quantidade;

    public Produto(float preco, int quantidade) {
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public void setPreco(float preco){
        this.preco = preco;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
