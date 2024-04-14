import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        
        Pessoa cliente = new Fisica(scan.nextLine(), scan.nextLine(),scan.nextLine(), scan.nextLine());

        Pessoa vendedor = new Juridica(scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine());
        System.out.println("\n\n");
    
        System.out.println("CLIENTE");
        System.out.println(cliente);
        System.out.println("\n#######################\n");


        Produto p1 = new Produto(scan.nextLine(), Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), scan.nextLine(), scan.nextLine());
        Item i1 = new Item(Integer.parseInt(scan.nextLine()), vendedor, Integer.parseInt(scan.nextLine()), p1);
        Produto p2 = new Produto(scan.nextLine(), Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), scan.nextLine(), scan.nextLine());
        Item i2 = new Item(Integer.parseInt(scan.nextLine()), vendedor, Integer.parseInt(scan.nextLine()), p2);

        Pedido pedido = new Pedido(001, scan.nextLine(), i1);
        pedido.addItem(i2);

        System.out.println(pedido);
        
        scan.close();
    }
}
