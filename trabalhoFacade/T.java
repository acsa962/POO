package trabalhoFacade;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Cliente {
    protected String nome;
    protected String email;
    protected String telefone;

    public Cliente(String nome, String email, String telefone){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return this.nome;
    }
    public String getEmail() {
        return this.email;
    }
    public String getTelefone() {
        return this.telefone;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString(){
        return "____________________________________________________________\n"+
        "Cliente: \n" + 
        this.nome + "\t" + this.email + "\t";
    }
    
}

public class Constantes {

    public static final String caminhoProdutoCSV = "C:\\Users\\vitor\\OneDrive\\Área de Trabalho\\Códigos\\Java\\atividade3\\produto.csv";

    public static final String caminhoItemCSV = "C:\\Users\\vitor\\OneDrive\\Área de Trabalho\\Códigos\\Java\\atividade3\\item.csv";

}

public class FachadaArquivo {


    /*
     * Lê a linha especificada do arquivo especificado, retornando um Array com os dados já separados a cada vírgula
    */
    public static String[] lerArquivoLinha(String caminhoArquivo, int linhaQuery){
        // Cria as variáveis e objetos necessários
        BufferedReader leitor = null;
        String stringBuffer;
        String[] linhaBuffer = null;
        int i = 1;

        try{
            // Cria um objeto leitor com BufferedReader
            leitor = new BufferedReader(new FileReader(caminhoArquivo));

            // Lê a linha especificada no parâmetro e separa os dados por vírgula, cada dado em uma posição do Array
            while(true){
                if(i == linhaQuery){
                    stringBuffer = leitor.readLine();
                    linhaBuffer = stringBuffer.split(",");
                    break;
                }
                i++;
            }
        }
        catch(FileNotFoundException e){
            FachadaJOptionsPane.exibirMensagemError("Arquivo não encontrado!", null);
        }
        catch(IOException e){
            FachadaJOptionsPane.exibirMensagemError("Erro ao manusear arquivo.", null);
        }
        catch(Exception e){
            FachadaJOptionsPane.exibirMensagemError("Erro!!!!", null);
        }
        finally{
            try{
                leitor.close();
            }
            catch(IOException e){
                FachadaJOptionsPane.exibirMensagemError("Erro ao manusear arquivo.", null);
            }  
        }
        return linhaBuffer;
    }


    /*
     * Cria uma lista de produtos, lê com BufferedReader o arquivo produto.csv e cria instâncias de Produto com as informações do arquivo.
     * Então adiciona os produtos na lista de produtos, que é retornada 
    */
    protected static List<Produto> lerProdutos() {
        //Criação da lista de produtos
        List<Produto> produtos = new ArrayList<Produto>();

        // Cria os leitores
        try (BufferedReader leitor = new BufferedReader(new FileReader(Constantes.caminhoProdutoCSV))){
            String linha;
            
            // Executa o while até o leitor chegar em null, ou seja, o final do arquivo.
            // Portanto, lê cada linha do arquivo produto.csv e cria um produto com as informações lidas
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(",");    // Separa dados por vírgula
                int idProduto = Integer.parseInt(dados[0]); // Passa o ID como inteiro
                String nome = dados[1];                     // Pega a segunda posição como nome
                float preco = Float.parseFloat(dados[2]);   // Passa a terceira como float para o preco
                int estoque = Integer.parseInt(dados[3]);   // Passa a última posição como inteiro para a quantidade de estoque
                Produto produto = new Produto(idProduto, nome, preco, estoque); // Cria um produto com as informações lidas
                produtos.add(produto);                      // Adciona o produto criado à lista de produtos
            }
        } catch(FileNotFoundException e){
            FachadaJOptionsPane.exibirMensagemError("Arquivo não encontrado!", null);
        }
        catch(IOException e){
            FachadaJOptionsPane.exibirMensagemError("Erro ao manusear arquivo.", null);
        }
        catch(Exception e){
            FachadaJOptionsPane.exibirMensagemError("Erro!", null);
        }
        return produtos;
    }


    /*
     * Adiciona a linha de texto passada como parâmetro na última linha do arquivo presente no caminho passado como parâmetro
    */
    public static void escreverArquivo(String caminhoArquivo, String linhaTexto){

        FileWriter escritor = null;

        // Criação da instância do FileWriter e escrita na última linha do arquivo
        try{
            escritor = new FileWriter(caminhoArquivo, true);
            escritor.append(linhaTexto);
        }
        catch(FileNotFoundException e){
            FachadaJOptionsPane.exibirMensagemError("Arquivo não encontrado!", null);
        }
        catch(IOException e){
            FachadaJOptionsPane.exibirMensagemError("Erro ao manusear arquivo.", null);
        }
        catch(Exception e){
            FachadaJOptionsPane.exibirMensagemError("Erro!", null);
        }
        finally{
            if (escritor != null){
                try {
                    escritor.close(); // Fecha o FileWriter após a operação
                } 
                catch (IOException e){
                    FachadaJOptionsPane.exibirMensagemError("Erro ao fechar o arquivo.", null);
                    e.printStackTrace(); // Mostra o rastreamento da exceção para diagnóstico
                }
            }
        }
    }
}


public class FachadaCliente {


    /*
     * Utiliza das janelas da JOptionsPane para receber informações do cliente e criar uma instância de Cliente Físico ou Jurídico, decidido pelo usuário
    */
    public static Cliente clienteBuilder(){
        Cliente cliente;

        int tipo = FachadaJOptionsPane.exibirMensagemBotao("Como deseja se cadastrar?", "Pessoa Física", "Pessoa Jurídica", "Tipo de cadastro");
        //0-> fisica     1-> jurídica
        
        String nome = FachadaJOptionsPane.lerStrings("Nome: ");
        String email = FachadaJOptionsPane.lerStrings("Email: ");
        String telefone = FachadaJOptionsPane.lerStrings("Telefone: ");

        if(tipo == 0){
            String cpf = FachadaJOptionsPane.lerStrings("Informe o CPF:");
            cliente = new Fisico(nome, email, telefone, cpf);
        } else {
            String cnpj = FachadaJOptionsPane.lerStrings("Informe o CNPJ:");
            cliente = new Juridico(nome, email, telefone, cnpj);
        }

        return cliente;
    }

}


public class FachadaJOptionsPane {

    /*
     * Exibe uma janela comum com uma mensagem e título desejados
    */
    public static void exibirMensagemComum(String mensagem, String titulo){
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.PLAIN_MESSAGE);
    }


    /*
     * Exibe uma janela com uma mensagem e título desejados e um ícone de aviso
    */
    public static void exibirMensagemWarning(String mensagem, String titulo){
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.WARNING_MESSAGE);
    }


    /*
     * Exibe uma janela com uma mensagem e título desejados e um ícone de erro
    */
    public static void exibirMensagemError(String mensagem, String titulo){
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
    }


    /*
     * Exibe uma janela com uma mensagem desejada e recebe a entrada do usuário
    */
    public static String lerStrings(String mensagem){
        return JOptionPane.showInputDialog(mensagem);
    }


    /*
     * Verifica se o usuário fechou a janela ou clicou em "Cancel" e, se não, retorna o valor inteiro digitado pelo usuário
    */
    public static int lerInteiro(String mensagem){
        int opcao = 0;
        boolean opcaoValida = false;
        
        while (!opcaoValida){
            String input = JOptionPane.showInputDialog(mensagem);
            
            // Verifica se o input é null (usuário clicou em "Cancel" ou fechou a caixa de diálogo)
            if (input == null){
                FachadaJOptionsPane.finalizarPrograma("Encerrando pedido...", "Encerrando"); // Retorna null se o usuário cancelou a operação
                return -1; // Retorna um valor indicativo de cancelamento
            } 
            else {
                try {
                    opcao = Integer.parseInt(input);
                    opcaoValida = true;
                } 
                catch (NumberFormatException e){
                    exibirMensagemWarning("Por favor, digite um número inteiro válido.", null);
            }
            }
        }
        return opcao;
    }


    /*
     * Exibe uma janela com uma mensagem desejada e converte a entrada do usuário para float
    */
    public static float lerFloat(String mensagem){
        String input = JOptionPane.showInputDialog(mensagem);
        return Float.parseFloat(input);
    }


    /*
     * Exibe uma sequência de produtos para a escolha do usuário. Se o usuário escolher, retorna um objeto Produto, mas se o usuário cancelar, retorna null 
    */
    public static Produto selecionaProduto(List<Produto> produtos){
        Object produtoSelecionado  = JOptionPane.showInputDialog(null, "Escolha um produto", "Opção", JOptionPane.PLAIN_MESSAGE, null, produtos.toArray(), produtos.get(0));
        if (produtoSelecionado instanceof Produto) {
            return (Produto) produtoSelecionado;   // Converte para Produto se foi selecionado
        } else {
            FachadaJOptionsPane.finalizarPrograma("Encerrando pedido...", "Encerrando");   // Retorna null se o usuário cancelou a operação
            return null;
        }
    }


    /*
     * Exibe uma janela com as opções de botões desejadas
    */
    public static int exibirMensagemBotao(String mensagem, String botao1, String botao2, String titulo){
        String[] respostas = {botao1, botao2};
        return JOptionPane.showOptionDialog(null, mensagem, titulo, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, respostas, 0);
    }


    /*
     * Exibe uma janela com o texto desejado e finaliza o programa com status 0
    */
    public static void finalizarPrograma(String mensagem, String titulo){
        FachadaJOptionsPane.exibirMensagemComum(mensagem, titulo);
        System.exit(0);
    }
}


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
        
        //Constrói um produto
        produto = produtoBuilder();
        
        int quantidade = FachadaJOptionsPane.lerInteiro("Quantidade:");

        //Verifica se a quantidade digitada é maior que a quantidade presente no estoque
        if (quantidade < 1) FachadaJOptionsPane.finalizarPrograma("Quantidade inválida!" , "Erro");
        else if (quantidade > produto.getEstoque())FachadaJOptionsPane.finalizarPrograma("Tente novamente mais tarde.", "Estoque insuficiente");

        //Cria a instância de Item
        item = new Item(Item.iteraContadorItem(), produto, quantidade);
        
        //Monta a string de escrita no arquivo item.csv
        String itemStringCSV = item.getId() + "," + item.getQuantidade() + "," + item.getProduto().getIdProduto() + "," + item.getPrecoTotalItem() + "\n";
        
        //Adiciona a linha do novo item no final do arquivo item.csv
        FachadaArquivo.escreverArquivo(Constantes.caminhoItemCSV, itemStringCSV);
    }


    /*
     * Cria uma lista de ID dos itens selecionados para a compra, e cria o pedido com esses itens
    */
    private static void pedidoBuilder(){

        //Cria uma lista que guarda o ID dos itens
        List<Integer> idItens = new ArrayList<Integer>(); 

        //Pergunta se quer adicionar mais um item
        do{
            //Constrói mais um item
            itemBuilder();

            //Adiciona o ID do item construído na lista de ID
            idItens.add(item.getId());

        }while(FachadaJOptionsPane.exibirMensagemBotao("Deseja adicionar um novo item?", "Não", "Sim", "Confirmação") == 1);


        //Cria a instância do pedido
        pedido = new Pedido(Pedido.iteraContadorPedido(), idItens, FachadaCliente.clienteBuilder());
    }


    /*
     * Imprime sequências de informações sobre o pedido, semelhante à uma nota fiscal, utilizando os métodos toString do cliente e do pedido
    */ 
    public static void notaFiscal(){

        //Constrói o pedido
        pedidoBuilder();

        //Printa os toStrings com informações do cliente e do pedido
        pedido.getCliente().toString();
        pedido.toString();
        
        FachadaJOptionsPane.finalizarPrograma("Obrigado por comprar conosco. Volte sempre!", "Pedido finalizado");
    }
}


public class Fisico extends Cliente {

    private String cpf;

    public Fisico(String nome, String email, String telefone, String cpf){
        super(nome, email, telefone);
        this.cpf = cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }
    
    public String getCPF() {
        return this.cpf;
    }

    @Override
    public String toString() {
        return super.toString() + "CPF: " + this.cpf + "\n____________________________________________________________\n";
    }
}


public class Item {
    private int id;
    private Produto produto;
    private int quantidade;

    private static int contadorItem = 0;
    

    /*
     * Aumenta a contagem da variável de classe contadorItem, que é utilizada como ID dos itens de um pedido
    */
    protected static int iteraContadorItem(){
        Item.contadorItem +=1;
        return contadorItem;
    }

    public Item(int id, Produto produto, int quantidade){
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
    }
    
    public int getId() {
        return id;
    }
    public Produto getProduto() {
        return produto;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public float getPrecoTotalItem() {
        return quantidade*produto.getPrecoProduto();
    }

}


public class Juridico extends Cliente {

    private String cnpj;
    
    public Juridico(String nome, String email, String telefone, String cnpj){
        super(nome, email, telefone);
        this.cnpj = cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    @Override
    public String toString() {
        return super.toString() + "CNPJ: " + this.cnpj + "\n____________________________________________________________\n";
    }
}


public class Main {
    public static void main(String[] args) throws Exception {
        
        FachadaPedido.notaFiscal();
    }
}


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
    public void setValorTotalPedido(float valorTotalPedido) {
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
        System.out.println("\n\nPEDIDO " + getId());

        int aux = 1; //Variável que conta o id dos itens

        for(Object id : idItens){
            System.out.printf("ITEM %d\n", aux);

            //Acessando informações do item no arquivo
            String temp[] = FachadaArquivo.lerArquivoLinha(Constantes.caminhoItemCSV, (int) id);
            //qtd = temp[1]
            //precoTotalItem = temp[3]

            //Acessando arquivo produto.csv para capturar o nome
            String prodNome = FachadaArquivo.lerArquivoLinha(Constantes.caminhoProdutoCSV, (int) id)[1];

            System.out.printf("ID%-10s NOME%-10s QUANTIDADE%-10s PREÇO TOTAL DO ITEM\n", "", "", "");
            System.out.printf("%-12d %-14s %-20s R$%s0\n", (int)id, prodNome, temp[1], temp[3]);//id item

            aux += 1;
        }
        
        return "Preco total: R$" + this.valorTotalPedido;
    }
}