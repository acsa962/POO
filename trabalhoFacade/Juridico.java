package trabalhoFacade;

public class Juridico extends Cliente {

    private String cnpj;
    
    public Juridico(String nome, String email, String telefone, String cnpj){
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
        return super.toString() + "CNPJ: " + this.cnpj + "\n_________________________________________________________________________________________________";
    }
}
