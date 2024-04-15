public class Produto{
    private String nome;
    private int peso; 
    private float preco;
    private String marca;
    private String modelo;

    


    public Produto(String nome, int preco, int peso, String marca, String modelo){
        this.nome = nome;
        this.peso = peso;
        this.preco = preco;
        this.marca = marca;
        this.modelo = modelo;
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
    public float getPreco() {
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


    @Override
    public String toString() {
        System.out.println("PRODUTO");
        return "|Nome: " + this.nome + "\n|Peso: " + this.peso + "g"+ "\n|Marca: " + this.marca + 
        "\n|Modelo: " + this.modelo;
    }

}