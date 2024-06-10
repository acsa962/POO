public class Juridica extends Pessoa {

    private String cnpj;
    
    public Juridica(String nome, String email, String telefone, String cnpj){
        super(nome, email, telefone);
        this.cnpj = cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCNPJ: " + this.cnpj + "\n____________________________________________________________";
    }
}
