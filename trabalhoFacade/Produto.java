package trabalhoFacade;

public class Produto {
    private int idProduto;
    private String nome;
    private float preco;
    private int estoque;

    public Produto(int id, String nome, float preco, int estoque){
        this.idProduto = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public int getIdProduto() {
        return idProduto;
    }
    public String getNome() {
        return nome;
    }
    public float getPrecoProduto() {
        return preco;
    }
    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return this.nome;
    }

}
