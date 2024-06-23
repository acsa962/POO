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
     * Utiliza HTML para melhorar a visibilidade na janela do JOptionsPane
    */
    @Override
    public String toString() {

        // Cria uma instância de um construtor de String que vai guardar toda a nota fiscal, adicionando cada String separadamente com o método .append()
        StringBuilder sb = new StringBuilder();

        // Início do HTML
        sb.append("<html>");
        sb.append("<style>")
        .append("table { width: 100%; border-collapse: collapse; }")
        .append("th, td { border: 1px solid black; padding: 8px; text-align: left; }")
        .append("th { background-color: #f2f2f2; }")
        .append("</style>");

        // Guarda o toString() do cliente, substituindo quebras de linha por <br> para HTML
        sb.append(getCliente().toString().replace("\n", "<br>"));
        
        sb.append("<br><br>PEDIDO ").append(getId()).append(":<br><br>");

        // Cabeçalho da tabela
        sb.append("<table>")
        .append("<tr>")
        .append("<th>ID</th>")
        .append("<th>NOME</th>")
        .append("<th>QUANTIDADE</th>")
        .append("<th>TOTAL</th>")
        .append("</tr>");

        for (Integer itemId : idItens) {

            // Acessando informações do item no arquivo
            String temp[] = FachadaArquivo.lerArquivoLinha(Constantes.caminhoItemCSV, itemId);
            // qtd = temp[1]
            // idProduto = temp[2]
            // precoTotalItem = temp[3]

            // Acessando arquivo produto.csv para capturar o nome
            String prodNome = FachadaArquivo.lerArquivoLinha(Constantes.caminhoProdutoCSV, Integer.parseInt(temp[2]))[1];

            // Adição das informações dos itens na tabela
            sb.append("<tr>")
            .append("<td>").append(itemId).append("</td>")
            .append("<td>").append(prodNome).append("</td>")
            .append("<td>").append(temp[1]).append("</td>")
            .append("<td>").append("R$").append(String.format("%.2f", Float.parseFloat(temp[3]))).append("</td>")
            .append("</tr>");
        }

        // Fechamento da tabela e adição do preço total
        sb.append("</table>");
        
        sb.append("<br>_________________________________________________________________________________________________<br>");
        sb.append("Preço total: R$").append(String.format("%.2f", getValorTotalPedido()));
        sb.append("<br>_________________________________________________________________________________________________<br>");
        sb.append("Agradecemos pela preferência!");

        // Fechamento do HTML
        sb.append("</html>");

        return sb.toString();
    }

}