import java.util.Scanner;

public class Item implements Estilo{
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

    public static  Item itemBuilder(){
        Produto produto = Produto.produtoBuider(); 
        Scanner scan = Estilo.abrirScan();
        System.out.println("Insira dos dados do item:");
        int qtd = 0;
        int estoque = 0;
        while(qtd>estoque){
            System.out.print("Estoque:");
            estoque = scan.nextInt();
            scan.nextLine();
            System.out.print("Quantidade:");
            qtd = scan.nextInt();
            scan.nextLine();
        }
        Item item = new Item(qtd, Juridica.vendedorBuilder(), estoque, produto);
        return item;
    }


    @Override
    public String toString() {
        System.out.println(produto);
        System.out.println("\nDETALHES DO ITEM");
        //System.out.println("Vendedor-> " + ((Juridica)vendedor));
        return "Quantidade: " + this.qtd + "\tEstoque: " + this.estoque + "\n||||||||||||||||||||||||||";
    }
}