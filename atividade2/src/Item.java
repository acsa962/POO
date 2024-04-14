public class Item {
    private int qtd;
    private Pessoa vendedor;
    private int estoque;
    private Produto produto;

    public Item(int qtd, Pessoa vendedor, int estoque, Produto produto){
        this.qtd = qtd;
        this.vendedor = vendedor;
        this.estoque = estoque - qtd;
        this.produto = produto;
    }

    
    public float getPreco() {
        return produto.getPreco()*qtd;
    }
    public Pessoa getVendedor() {
        return vendedor;
    }
    public int getEstoque() {
        return estoque;
    }
    public Produto getProduto() {
        return produto;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }


    @Override
    public String toString() {
        System.out.println(produto);
        System.out.println("\nDETALHES DO ITEM");
        System.out.println("Vendedor-> " + vendedor);
        return "Quantidade: " + this.qtd + "\tEstoque: " + this.estoque + "\n||||||||||||||||||||||||||";
    }
}