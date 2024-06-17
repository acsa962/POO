package trabalhoFacade;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
