import java.util.Scanner;

public class Main implements IUtil{
    public static void main(String[] args){
        Pedido pedido = new Pedido();
        Scanner scan = IUtil.open();

        String nome, email, telefone, aux = "";

        System.out.println("Olá, seja bem-vindo à nossa loja!");
        System.out.print("Deseja se cadastrar como uma Pessoa Jurídica ou uma Pessoa Física?\nDigite 0 para PJ e 1 para PF: ");
        boolean decisao = Pedido.escolha();

        System.out.println("Digite o nome:");
        nome = scan.nextLine();

        System.out.println("Digite o e-mail:");
        email = scan.nextLine();
        System.out.println("Digite o telefone:");
        telefone = scan.nextLine();
        
        if(decisao){
            System.out.println("Digite o CPF:");
            aux = scan.nextLine();
            Fisico novoPF = new Fisico(nome, email, telefone, aux);
            pedido.setComprador(nome, email, telefone, aux, decisao);
            System.out.println(novoPF.toString());
            System.out.println();
            System.out.printf("Obrigado por se cadastrar conosco, %s!", novoPF.getNome());
        } 
        else{
            System.out.println("Digite o CNPJ:");
            aux = scan.nextLine();
            Juridica novoPJ = new Juridica(nome, email, telefone, aux);
            pedido.setComprador(nome, email, telefone, aux, decisao);
            System.out.println(novoPJ);
            System.out.println();
            System.out.printf("Obrigado por cadastrar a empresa %s conosco!", novoPJ.getNome());
        }

        System.out.println("\nDeseja comprar algum produto? Responda 1 para SIM ou 0 para NAO:");
        if(!Pedido.escolha()){
            System.out.println("\nObrigado pelo cadastro!");
        }
        else{
            System.out.println("\nPor favor, digite a data de hoje e o método de pagamento, separados por Enter:");
            pedido.setData(scan.nextLine());
            pedido.setMetodoPagamento(scan.nextLine());

            do{
            pedido.constroiItem();
            System.out.println("\nDeseja adicionar outro item? Responda 1 para SIM ou 0 para NAO:");
            }while(Pedido.escolha());

            System.out.println("\nMuito obrigado por comprar conosco!");
            System.out.println(pedido);
            System.out.println("Comprador: " + pedido.getComprador().getNome() + "\t\tE-mail: " + pedido.getComprador().getEmail());
            System.out.println("Método de Pagamento: " + pedido.getMetodoPagamento() + "\t\tValor total: " + String.format("%.2f", pedido.getPrecoTotalItem()) + 
            "\n____________________________________________________________");
        }
        
        IUtil.close();
    }
}
