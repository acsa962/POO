public class Produto {
    private int idProduto;
    private String nome;
    private String descricao;
    private float preco;
    private int estoque;

    public Produto(int id, String nome, String descricao, float preco, int estoque){
        this.idProduto = id;
        this.nome = nome;
        this.descricao = descricao;
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
        return "Produto{" +
                "idProduto=" + idProduto +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", estoque=" + estoque +
                '}';
    }

}
