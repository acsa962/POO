import java.util.Scanner;

public class Juridica extends Pessoa{
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
        Scanner scan = new Scanner(System.in);
        String nome = scan.nextLine(); 
        String email = scan.nextLine();
        String cnpj = scan.nextLine();
        String fantasia = scan.nextLine();
        Juridica vendedor = new Juridica(nome, email, cnpj, fantasia);
        scan.close();
        return vendedor;
    }

    @Override
    public String toString() {
        return super.toString() + "\tcnpj: " + this.cnpj + "\tnome fantasia: " + this.fantasia;
    }
}
