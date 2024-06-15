import java.util.Scanner;

public class Main implements EstiloI{
    public static void main(String[] args) throws Exception {
        Scanner scan = EstiloI.abrirScan();
        System.out.println("Dados do Cliente");
        System.out.print("Nome:"); 
        String nome = scan.nextLine();
        System.out.print("Email:");
        String email = scan.nextLine();
        System.out.print("CPF:");
        String cpf = scan.nextLine();
        System.out.print("Telefone:");
        String telefone = scan.nextLine();

        Pessoa cliente = new Fisica(nome, email, cpf, telefone);
    
        System.out.println("\n#######################\n");
        System.out.println("Insira as informações dos produtos");
        
        System.out.println("CLIENTE");
        System.out.println(((Fisica)cliente));
        System.out.println("\n\n");
        System.out.println(Pedido.pedidoBuilder());
        
        EstiloI.fecharScan(scan);
    }
}