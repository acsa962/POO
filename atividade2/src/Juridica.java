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

    @Override
    public String toString() {
        return super.toString() + "\tcnpj: " + this.cnpj + "\tnome fantasia: " + this.fantasia;
    }
}
