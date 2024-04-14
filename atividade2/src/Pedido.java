import java.util.ArrayList;

public class Pedido {
    private int id;
    private float precoTot;
    private String transportadora;
    private  ArrayList<Item> itens = new ArrayList<>();

    public Pedido(int id, String transportadora, Item item){
        this.id = id;
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

    public int getId() {
        return id;
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
    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        System.out.println("PEDIDO " + id);
        int aux = 1;
        for(Item item : itens){
            System.out.printf("ITEM %d\n", aux);
            System.out.println(item + "\n");
            aux+=1;
        }
        System.out.println("DETALHES DO PEDIDO");
        return "Preco total: R$" + this.precoTot + "\tTransportadora: " + this.transportadora;
    }
    
}


