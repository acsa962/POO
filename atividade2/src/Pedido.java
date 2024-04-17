import java.util.ArrayList;
import java.util.Scanner;

public class Pedido {
    private float precoTot;
    private String transportadora;
    private  ArrayList<Item> itens = new ArrayList<>();

    public Pedido(String transportadora, Item item){
        this.precoTot += item.getPreco();
        this.transportadora = transportadora;
        itens.add(item);
    }

    public void addItem(Item item){
        itens.add(item);
        precoTot += item.getPreco();
    }

    public void removeItem(Item item){
        itens.remove(item);
        precoTot -= item.getPreco();
    }
    public float getPrecoTot() {
        return precoTot;
    }
    public String getTransportadora() {
        return transportadora;
    }
    public void setPrecoTot(int precoTot) {
        this.precoTot = precoTot;
    }
    public void setTransportadora(String transportadora) {
        this.transportadora = transportadora;
    }

    public static Pedido prodBuilder(){
        Item item = Item.itemBuilder(); 
        Scanner scan = new Scanner(System.in);
        String transportadora = scan.nextLine();
        Pedido pedido = new Pedido(transportadora, item);
        System.out.println("Deseja acrescentar um novo item(0 = sim/1 = não)");
        String aux;
        aux = "a";
        do{
            aux = scan.nextLine();
            System.out.println("Digite 0 para sim ou 1 para não: ");
        } while(aux != "0" | aux!="1");
        
        if(aux == "0") {
            
        }

        scan.close();
        return pedido;
    }


    @Override
    public String toString() {
        System.out.println("PEDIDO");
        int aux = 1;
        for(Item item : itens){
            System.out.printf("ITEM %d\n", aux);
            System.out.println(item + "\n");
            aux+=1;
        }
        System.out.println("\n\nDETALHES DO PEDIDO");
        return "Preco total: R$" + this.precoTot + "\tTransportadora: " + this.transportadora;
    }
    
}


