import java.util.Scanner;

public class Juridica extends Pessoa implements Estilo{
    private String cnpj;
    private String fantasia;

    public Juridica(String nome, String email, String cnpj, String fantasia){
        super(nome, email);
        this.cnpj = cnpj;
        this.fantasia = fantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public static Juridica vendedorBuilder(){
        Scanner scan = Estilo.abrirScan();
        System.out.println("Dados pessoa Jurídica");
        System.out.print("Nome:");
        String nome = scan.nextLine();
        System.out.print("Email:"); 
        String email = scan.nextLine();
        System.out.print("CNPJ:");
        String cnpj = scan.nextLine();
        System.out.print("Nome fantasia:");
        String fantasia = scan.nextLine();
        Juridica vendedor = new Juridica(nome, email, cnpj, fantasia);
        return vendedor;
    }

    @Override
    public String toString() {
        return super.toString() + "\tcnpj: " + this.cnpj + "\tnome fantasia: " + this.fantasia;
    }
}