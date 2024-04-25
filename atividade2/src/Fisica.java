public class Fisica extends Pessoa {
    private String cpf;
    private String telefone;

    public Fisica(String nome, String email, String cpf, String telefone){
        super(nome,email);
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        System.out.println("DETALHES DO CLIENTE");
        return super.toString() + "\tcpf: " + this.cpf + "\ttelefone: " + this.telefone;
    }

}