public class Produto {
    
    private String nome;
    private String vendedor;                 
    private String tipo;
    private double preco;           
    private String dimensoes;
    private String marca;

    //Estarei utilizando um array "aleatório" de vendedores, já que não temos uma implementação de lojas
    private static final String[] ARRAY_VENDEDORES = {"Armazém do Roberto", "Creuza Utilidades", "Tem de Tudo", "Big Lar", "Shopping 24"};
    
    public Produto(String nome, int i, String tipo, double preco, String dimensoes, String marca){
        this.nome = nome;
        this.vendedor = ARRAY_VENDEDORES[i];
        this.tipo = tipo;
        this.preco = preco;
        this.dimensoes = dimensoes;
        this.marca = marca;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNome() {
        return this.nome;
    }
    public String getVendedor() {
        return this.vendedor;
    }
    public String getTipo() {
        return this.tipo;
    }
    public double getPreco() {
        return this.preco;
    }
    public String getMarca() {
        return this.marca;
    }
    public String getDimensoes() {
        return this.dimensoes;
    }
    
}