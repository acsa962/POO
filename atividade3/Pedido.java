package atividade3;

import java.util.List;

public class Pedido {
    private int id;
    private List<Integer> idItens;
    private Cliente cliente;
    private float valorTotalPedido = 0;

    private static int contadorPedido = 2000;
    private static int contadorQuantidadeItens = 0;

    protected static int iteraContadorPedido(){
        Pedido.contadorPedido += 1;
        return contadorPedido;
    }
    protected static int iteraContadorQuantidadeItens(){
        Pedido.contadorQuantidadeItens += 1;
        return contadorQuantidadeItens;
    }

    public Pedido(int id, List<Integer> idItens, Cliente cliente){
        this.id = id;
        this.idItens = idItens;
        this.cliente = cliente;
    }

    public void setValorTotalPedido(float valorTotalPedido) {
        float soma = 0;
        for(Integer id : idItens){
            soma += Float.parseFloat(FachadaArquivo.lerArquivoLinha("C:\\Users\\vitor\\OneDrive\\Área de Trabalho\\Códigos\\Java\\POO\\atividade3\\item.csv", id)[3]);
        }
        this.valorTotalPedido = soma;
    }

    public int getId() {
        return id;
    }
    public Object[] getArrayIdItem() {
        return idItens.toArray();
    }
    public Cliente getCliente() {
        return cliente;
    }
    public float getValorTotalPedido() {
        return valorTotalPedido;
    }
}
