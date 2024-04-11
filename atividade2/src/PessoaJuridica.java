public class PessoaJuridica extends Cliente{
    private String cnpj;
    private String fantasia;

    public PessoaJuridica(String nome, String email, String cnpj, String fantasia){
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
    public void boletim() {
        System.out.println("BOLETIM PESSOA JURIDICA");
        super.boletim();
        System.out.println("CNPJ = " + this.cnpj);
        System.out.println("Nome Fantasia = " + this.fantasia);
    }
}
