import java.util.Scanner;
import java.util.Random;

public class Item implements IUtil{
    
    private Produto produto;
    private int qtdProduto;
    private double valor;
    private static final double DESCONTO = 0.15;

    public Item(int qtdProduto){
        this.qtdProduto = qtdProduto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public Produto getProduto() {
        return this.produto;
    }
    public int getQtdProduto() {
        return this.qtdProduto;
    }
    public double getValor() {
        return this.valor;
    }
    public double getDesconto() {
        return Item.DESCONTO;
    }

    public Produto constroiProduto(){
        Scanner scan = IUtil.open();
        Random aleatorio = new Random();

        System.out.println("Por favor, digite o nome, tipo, dimensões e marca do produto desejado, separados por Enter:");
        produto = new Produto(scan.nextLine(), aleatorio.nextInt(5), scan.nextLine(), ((aleatorio.nextInt(5000) + 1) * aleatorio.nextDouble()) , scan.nextLine(), scan.nextLine());
        this.valor = produto.getPreco() * (1 - Item.DESCONTO) * this.qtdProduto;
    
        return produto;
    }
    
    @Override
    public String toString(){
        return "\t" + this.produto.getNome() + "\t\tR$" + String.format("%.2f", this.valor);
    }
}
