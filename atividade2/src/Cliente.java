public class Cliente {
    private String nome;
    private String email;


    public Cliente(String nome, String email){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void boletim(){
        System.out.println("Nome = " + this.nome);
        System.out.println("Email = " + this.email);
    }


}
