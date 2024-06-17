package trabalhoFacade;

public class Cliente {
    protected String nome;
    protected String email;
    protected String telefone;

    public Cliente(String nome, String email, String telefone){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return this.nome;
    }
    public String getEmail() {
        return this.email;
    }
    public String getTelefone() {
        return this.telefone;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString(){
        return "_________________________________________________________________________________________________\n"+
        "Cliente: \n" + 
        String.format("%-20s",this.nome) + String.format("%-35s",this.email) + "\t";
    }
    
}
