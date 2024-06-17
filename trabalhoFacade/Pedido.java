package trabalhoFacade;

import java.util.List;

public class Pedido {
    private int id;
    private List<Integer> idItens;
    private Cliente cliente;
    private float valorTotalPedido = 0;

    private static int contadorPedido = 6500;


    /*
     * Aumenta a contagem do contador de pedido
    */
    protected static int iteraContadorPedido(){
        Pedido.contadorPedido += 1;
        return contadorPedido;
    }

    public Pedido(int id, List<Integer> idItens, Cliente cliente){
        this.id = id;
        this.idItens = idItens;
        this.cliente = cliente;
    }


    /*
     * Percorre todos os itens por ID em idItens, lê o valor total do item em item.csv e soma todos esses valores para atribuir o valor total do pedido
    */
    public void setValorTotalPedido() {
        float soma = 0;
        for(Integer id : idItens){
            soma += Float.parseFloat(FachadaArquivo.lerArquivoLinha(Constantes.caminhoItemCSV, id)[3]);
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


    /*
     * Exibe algumas informações importantes do pedido tal qual uma nota fiscal
    */
    @Override
    public String toString() {
        // Cria uma instância de um construtor de String que vai guardar toda a nota fiscal
        StringBuilder sb = new StringBuilder();

        // Guarda o toString() do cliente
        sb.append(getCliente().toString());
        
        sb.append("\nPEDIDO ").append(getId()).append(":\n");

        int aux = 1; // Variável que conta o id dos itens

        for(Integer itemId : idItens){
            sb.append("\tItem ").append(aux).append("\n");

            // Acessando informações do item no arquivo
            String temp[] = FachadaArquivo.lerArquivoLinha(Constantes.caminhoItemCSV, (int) itemId);
            // qtd = temp[1]
            // idProduto = temp[2]
            // precoTotalItem = temp[3]

            // Acessando arquivo produto.csv para capturar o nome
            String prodNome = FachadaArquivo.lerArquivoLinha(Constantes.caminhoProdutoCSV, Integer.parseInt(temp[2]))[1];

            sb.append(String.format("\t\tID%-10s NOME%-10s QUANTIDADE%-10s TOTAL\n", "", "", ""));
            sb.append(String.format("\t\t%-12d %-14s %-20s R$%s\n", (int)itemId, prodNome, temp[1], String.format("%.2f", Float.parseFloat(temp[3]))));

            aux += 1;
        }
    
        sb.append("\n_________________________________________________________________________________________________\n");
        sb.append("Preço total: R$").append(String.format("%.2f", getValorTotalPedido()));
        sb.append("\n_________________________________________________________________________________________________\n");
        sb.append("Obrigado pela preferência!");

        return sb.toString();
    }
}