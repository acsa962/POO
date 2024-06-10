public class Fisica extends Pessoa {

    private String cpf;

    public Fisica(String nome, String email, String telefone, String cpf){
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
        return super.toString() + "\nCPF: " + this.cpf + "\n____________________________________________________________";
    }
}
