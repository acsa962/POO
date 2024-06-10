import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Pedido implements IUtil{
    Random aleatorio = new Random();

    private Pessoa comprador;
    private int idPedido = aleatorio.nextInt(999) + 1;
    private double valorTotal;
    private Item item;
    private ArrayList<Item> listaItens = new ArrayList<>();
    private String data;
    private String metodoPagamento;

    public Pedido(){}

    public void setComprador(String nome, String email, String telefone, String aux, boolean decisao) {
        if (decisao){
            this.comprador = new Juridica(nome, email, telefone, aux);
        }
        else{
            this.comprador = new Fisica(nome, email, telefone, aux);
        }
    }
    public void setData(String data) {
        this.data = data;
    }
    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Pessoa getComprador(){
        return this.comprador;
    }
    public int getIdPedido() {
        return this.idPedido;
    }
    public double getValorTotal() {
        return this.valorTotal;
    }
    public ArrayList<Item> getListaItens() {
        return this.listaItens;
    }
    public Item getItem(int i){
        return this.listaItens.get(i);
    }
    public String getData() {
        return this.data;
    }
    public String getMetodoPagamento() {
        return this.metodoPagamento;
    }

    public void constroiItem(){
        Scanner scan = IUtil.open();
        int aux = 0;

        System.out.println("Por favor, digite a quantidade desejada:");
        
        aux = scan.nextInt();
        scan.nextLine();
        item = new Item(aux);
        item.setProduto(item.constroiProduto());
        listaItens.add(item);
    }

    public static boolean escolha(){
        Scanner scan  = IUtil.open();
        int aux = -1;
        aux = scan.nextInt();
        scan.nextLine();
        while(aux != 1 && aux != 0){
            System.out.println("Por favor, digite 0 ou 1!");
            aux = scan.nextInt();
            scan.nextLine();
        }
        
        if(aux == 1) return true;
        else return false;
    }

    private double calculoValorTotal(){
        double aux = 0;
        if(this.listaItens.isEmpty()){
            aux = 0;
        }
        else{
            for(Item item :listaItens){
                aux += item.getValor();
            }
        }
        return aux;
    }

    @Override
    public String toString(){
        this.valorTotal = calculoValorTotal();
        System.out.println("____________________________________________________________");
        System.out.println("Pedido: " + this.idPedido + "\t\tData: " + this.data + "\n");
        System.out.println("Vendedor: " + item.getProduto().getVendedor());
        for(Item item : listaItens){
            System.out.println(item);
        }
        return"------------------------------------------------------------";

    }

}
