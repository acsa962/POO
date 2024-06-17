package trabalhoFacade;

public class Item {
    private int id;
    private Produto produto;
    private int quantidade;

    private static int contadorItem = 0;
    

    /*
     * Aumenta a contagem da variável de classe contadorItem, que é utilizada como ID dos itens de um pedido
    */
    protected static int iteraContadorItem(){
        Item.contadorItem +=1;
        return contadorItem;
    }

    public Item(int id, Produto produto, int quantidade){
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
    }
    
    public int getId() {
        return id;
    }
    public Produto getProduto() {
        return produto;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public float getPrecoTotalItem() {
        return quantidade*produto.getPrecoProduto();
    }

}
