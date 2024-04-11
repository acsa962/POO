import java.util.ArrayList;

public class Pedido {
    private int precoTot;
    private int frete;
    private String transportadora;
    private boolean conf_pag; //confirmação de pagamento
    private  ArrayList<Item> itens = new ArrayList<>();

    public Pedido(int precoTot, int frete, String transportadora, boolean conf_pag, Item item){
        this.precoTot = precoTot;
        this.frete = frete;
        this.transportadora = transportadora;
        this.conf_pag = conf_pag;
        itens.add(item);
    }

    public addItem(Item item){
        itens.add(item);
    }

    public removeItem(Item item){
        itens.remove(item);
    }

    public int getFrete() {
        return frete;
    }
    public int getPrecoTot() {
        return precoTot;
    }
    public String getTransportadora() {
        return transportadora;
    }
    public void setConf_pag(boolean conf_pag) {
        this.conf_pag = conf_pag;
    }
    public void setFrete(int frete) {
        this.frete = frete;
    }
    public void setPrecoTot(int precoTot) {
        this.precoTot = precoTot;
    }
    public void setTransportadora(String transportadora) {
        this.transportadora = transportadora;
    }


    
}


