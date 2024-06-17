package trabalhoFacade;

public class Fisico extends Cliente {

    private String cpf;

    public Fisico(String nome, String email, String telefone, String cpf){
        super(nome, email, telefone);
        this.cpf = cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }
    
    public String getCPF() {
        return this.cpf;
    }

    @Override
    public String toString() {
        return super.toString() + "CPF: " + this.cpf + "\n_________________________________________________________________________________________________";
    }
}

