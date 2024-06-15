package atividade3;

import java.util.ArrayList;
import java.util.List;

public class FachadaPedido implements IUtil{

    private static Item item = null;
    private static Produto produto = null;
    private static Pedido pedido = null;

    private static Produto produtoBuilder(){
        //Lê o produto do arquivo csv e constroi o objeto produto
        //fazer o seleciona produto e a partir do vaor selecionado passar como parametro
        //do ler arquivo que retorna o vetor com as infos do produto
        return FachadaJOptionsPane.selecionaProduto(FachadaArquivo.lerProdutos());

    }

    private static void itemBuilder(){

        //JOption: escolhe o produto pela caixa de diálogo
        //Leitura de cada atributo do produto pelo arquivo csv
        //Construção do produto
        
        produto = produtoBuilder();
        
        int quantidade = FachadaJOptionsPane.lerInteiro("Quantidade:");
        //verificação de estoque
        if(quantidade <1) FachadaJOptionsPane.finalizarPrograma("Quantidade inválida!" , "Erro");
        else if (quantidade > produto.getEstoque())FachadaJOptionsPane.finalizarPrograma("Tente novamente mais tarde.", "Estoque insuficiente");
        //inicializa o item
        item = new Item(Item.iteraContadorItem(), produto, quantidade);
        
        //montando a string de escrita no arquivo item.csv
        String itemStringCSV = item.getId() + "," + item.getQuantidade() + "," + item.getProduto().getIdProduto() + "," + item.getPrecoTotalItem() + "\n";
        
        //adicionando a linha do novo item no final do arquivo item.csv
        FachadaArquivo.escreverArquivo("C:\\Users\\vitor\\OneDrive\\Área de Trabalho\\Códigos\\Java\\POO\\atividade3\\item.csv", itemStringCSV);
        
    }

    private static void pedidoBuilder(){
        List<Integer> idItens = new ArrayList<Integer>(); 
        //pergunta se quer adicionar mais um item
        do{
            itemBuilder();
            //itera o vetor de id do item 
            idItens.add(item.getId());
        }while(FachadaJOptionsPane.exibirMensagemBotao("Deseja adicionar um novo item?", "Não", "Sim", "Confirmação") == 1);


        //inicializando a construção do pedido
        pedido = new Pedido(Pedido.iteraContadorPedido(), idItens, FachadaCliente.clienteBuilder());
        }
        
    public static void finalizaPrograma(){

        pedidoBuilder();

        /* 
        String clientePrint = "_________________________________________________\n"+
                            "Cliente: \n" + 
                            pedido.getCliente().getNome() + "\t" + pedido.getCliente().getEmail() + "\n" +
                            "_________________________________________________\n";
        System.out.println(clientePrint);
        System.out.println("ITENS");
        for(Object id : pedido.getArrayIdItem()){
            //pegar valorTot item e id produto
            String temp[] = FachadaArquivo.lerArquivoLinha("C:\\Users\\vitor\\OneDrive\\Área de Trabalho\\Códigos\\Java\\POO\\atividade3\\item.csv", (int) id);
            String valorTotItem = temp[4];
            String prodNome = FachadaArquivo.lerArquivoLinha("C:\\Users\\vitor\\OneDrive\\Área de Trabalho\\Códigos\\Java\\POO\\atividade3\\produto.csv", (int) id)[1];
            System.out.println();
        }
        */
        
        FachadaJOptionsPane.finalizarPrograma("Obrigado por comprar conosco. Volte sempre!", "Pedido finalizado");
    }
    

}
