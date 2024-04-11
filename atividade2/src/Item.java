public class Item {
    private int qtd;
    private String vendedor;
    private int estoque;
    private String avaliacoes;
    private Produto produto;

    public Item(int qtd, String vendedor, int estoque, String avaliacoes, Produto produto){
        this.qtd = qtd;
        this.vendedor = vendedor;
        this.estoque = estoque;
        this.avaliacoes = avaliacoes;
        this.produto = produto;
    }
    
    public int getPreco() {
        return produto.getPreco()*qtd;
    }
    public String getVendedor() {
        return vendedor;
    }
    public int getEstoque() {
        return estoque;
    }
    public String getAvaliacoes() {
        return avaliacoes;
    }
    public Produto getProduto() {
        return produto;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
    public void setAvaliacoes(String avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}