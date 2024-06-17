import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FachadaArquivo {
    /*
     * Lê a linha especificada do arquivo especificado, retornando um Array com os dados já separados a cada vírgula
    */
    public static String[] lerArquivoLinha(String caminhoArquivo, int linhaQuery){
        // Cria as variáveis e objetos necessários
        String stringBuffer;
        String[] linhaBuffer = null;
        int i = 1;

        try(BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo))){

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
            System.out.println("Arquivo não encontrado!");
        }
        catch(IOException e){
            System.out.println("Erro ao manusear arquivo.");
        }
        catch(Exception e){
            System.out.println("Erro!!!!");
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
                String descricao = dados[2];                // Passa a terceira posição como descrição
                float preco = Float.parseFloat(dados[3]);   // Passa a qquarta como float para o preco
                int estoque = Integer.parseInt(dados[4]);   // Passa a última posição como inteiro para a quantidade de estoque
                Produto produto = new Produto(idProduto, nome, descricao, preco, estoque); // Cria um produto com as informações lidas
                produtos.add(produto);                      // Adciona o produto criado à lista de produtos
            }
        } catch(FileNotFoundException e){
            System.out.println("Arquivo não encontrado!");
        }
        catch(IOException e){
            System.out.println("Erro ao manusear arquivo.");
        }
        catch(Exception e){
            System.out.println("Erro!");
        }
        
        return produtos;
    }

    
    /*
     * Cria uma lista de itens, lê com BufferedReader o arquivo client.csv e cria instâncias de Item com as informações do arquivo.
     * Então adiciona os itens na lista de itens, que é retornada
    */
    protected static List<Cliente> lerClientes() {
        //Criação da lista de produtos
        List<Cliente> clientes = new ArrayList<Cliente>();

        // Cria os leitores
        try (BufferedReader leitor = new BufferedReader(new FileReader(Constantes.caminhoClienteCSV))){
            String linha;
            
            // Executa o while até o leitor chegar em null, ou seja, o final do arquivo.
            // Portanto, lê cada linha do arquivo produto.csv e cria um produto com as informações lidas
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(",");    // Separa dados por vírgula
                int idCliente = Integer.parseInt(dados[0]); // Passa o ID como inteiro
                String nome = dados[1];   
                String email = dados[2];                      // Pega a segunda posição como nome
                String endereco = dados[3];
                String telefone = dados[4];
                String userName = dados[5];
                String password = dados[6];
                Cliente cliente = new Cliente(idCliente, nome, email, endereco, telefone, userName, password);
                clientes.add(cliente);                      // Adciona o produto criado à lista de produtos
            }
        } catch(FileNotFoundException e){
            System.out.println("Arquivo não encontrado!");
        }
        catch(IOException e){
            System.out.println("Erro ao manusear arquivo.");
        }
        catch(Exception e){
            System.out.println("Erro!");
        }
        return clientes;
    }
}