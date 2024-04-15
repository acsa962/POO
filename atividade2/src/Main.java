import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        String nome = scan.nextLine();
        String email = scan.nextLine();
        String cpf = scan.nextLine();
        String telefone = scan.nextLine();

        Pessoa cliente = new Fisica(nome, email, cpf, telefone);

        Pessoa vendedor = new Juridica(scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine());
        System.out.println("\n\n");
    
        System.out.println("CLIENTE");
        System.out.println(((Fisica)cliente));
        System.out.println("\n#######################\n");
        System.out.println("Insira as informações dos produtos");

        //Produto(String nome, int preco, int peso, String marca, String modelo)
        nome = scan.nextLine();
        int preco = scan.nextInt();
        int peso = scan.nextInt();
        String marca = scan.nextLine();
        String modelo = scan.nextLine(); 

        Produto p1 = new Produto(nome, preco, peso, marca, modelo);

        //Item(int qtd, Pessoa vendedor, int estoque, Produto produto)
        int qtd = scan.nextInt();
        int estoque = scan.nextInt();
        Item i1 = new Item(qtd, vendedor, estoque, p1);

        String nomeP2 = scan.nextLine();
        preco = scan.nextInt();
        peso = scan.nextInt();
        marca = scan.nextLine();
        modelo = scan.nextLine(); 
        Produto p2 = new Produto(nome, preco, peso, marca, modelo);

        qtd = scan.nextInt();
        estoque = scan.nextInt();        
        Item i2 = new Item(qtd, vendedor,estoque, p2);

        String transp = scan.nextLine();
        Pedido pedido = new Pedido(001,transp, i1);
        pedido.addItem(i2);

        System.out.println(pedido);
        
        scan.close();
    }
}
