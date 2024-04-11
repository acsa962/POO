public class Produto{
    private String nome;
    private int peso; 
    private int preco;
    private String marca;
    private String modelo;
    private String detalhes;


    public Produto(String nome, int preco, int peso, String marca, String modelo, String detalhes){
        this.nome = nome;
        this.peso = peso;
        this.preco = preco;
        this.marca = marca;
        this.modelo = modelo;
        this.detalhes = detalhes;
    }  


    public String getNome() {
        return nome;
    }
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public int getPeso() {
        return peso;
    }
    public String getDetalhes() {
        return detalhes;
    }
    public int getPreco() {
        return preco;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
    public void setPreco(int preco) {
        this.preco = preco;
    }

}