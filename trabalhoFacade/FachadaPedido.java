package trabalhoFacade;

import java.util.ArrayList;
import java.util.List;

public class FachadaPedido{

    private static Item item = null;
    private static Produto produto = null;
    private static Pedido pedido = null;
    

    /*
     * Retorna uma janela com a sequência de produtos já lidos do arquivo produto.csv
    */
    private static Produto produtoBuilder(){
        return FachadaJOptionsPane.selecionaProduto(FachadaArquivo.lerProdutos());
    }


    /*
     * Cria um produto pelo método produtoBuilder(), recebe a quantidade do produto e cria um item com essas informações
     * Após isso, escreve as informações do item no arquivo item.csv
    */
    private static void itemBuilder(){
        
        // Constrói um produto
        produto = produtoBuilder();
        
        int quantidade = FachadaJOptionsPane.lerInteiro("Quantidade:");

        // Verifica se a quantidade digitada é maior que a quantidade presente no estoque
        if (quantidade < 1) FachadaJOptionsPane.finalizarPrograma("Quantidade inválida!" , "Erro");
        else if (quantidade > produto.getEstoque())FachadaJOptionsPane.finalizarPrograma("Tente novamente mais tarde.", "Estoque insuficiente");

        // Cria a instância de Item
        item = new Item(Item.iteraContadorItem(), produto, quantidade);
        
        // Monta a string de escrita no arquivo item.csv
        String itemStringCSV = item.getId() + "," + item.getQuantidade() + "," + item.getProduto().getIdProduto() + "," + item.getPrecoTotalItem() + "\n";
        
        // Adiciona a linha do novo item no final do arquivo item.csv
        FachadaArquivo.escreverArquivo(Constantes.caminhoItemCSV, itemStringCSV);
    }


    /*
     * Cria uma lista de ID dos itens selecionados para a compra, e cria o pedido com esses itens
    */
    private static void pedidoBuilder(){

        // Cria uma lista que guarda o ID dos itens
        List<Integer> idItens = new ArrayList<Integer>(); 

        // Pergunta se quer adicionar mais um item
        do{
            // Constrói mais um item
            itemBuilder();

            // Adiciona o ID do item construído na lista de ID
            idItens.add(item.getId());

        }while(FachadaJOptionsPane.exibirMensagemBotao("Deseja adicionar um novo item?", "Não", "Sim", "Confirmação") == 1);


        // Cria a instância do pedido
        pedido = new Pedido(Pedido.iteraContadorPedido(), idItens, FachadaCliente.clienteBuilder());
        pedido.setValorTotalPedido();
    }


    /*
     * Imprime sequências de informações sobre o pedido, semelhante à uma nota fiscal, utilizando os métodos toString do cliente e do pedido
    */ 
    public static void notaFiscal(){

        // Constrói o pedido
        pedidoBuilder();

        FachadaJOptionsPane.finalizarPrograma(pedido.toString(), "Pedido finalizado!");
    }
}
