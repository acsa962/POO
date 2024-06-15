package atividade3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FachadaArquivo {

    public static String[] lerArquivoLinha(String caminhoArquivo, int linhaQuery){
        BufferedReader leitor = null;
        String stringBuffer;
        String[] linhaBuffer = null;
        int i = 1;
        try{
            leitor = new BufferedReader(new FileReader(caminhoArquivo));
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

    protected static List<Produto> lerProdutos() {
        List<Produto> produtos = new ArrayList<Produto>();

        try (BufferedReader leitor = new BufferedReader(new FileReader("C:\\Users\\vitor\\OneDrive\\Área de Trabalho\\Códigos\\Java\\POO\\atividade3\\produto.csv"))){
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(",");
                int idProduto = Integer.parseInt(dados[0]);
                String nome = dados[1];
                float preco = Float.parseFloat(dados[2]);
                int estoque = Integer.parseInt(dados[3]);
                Produto produto = new Produto(idProduto, nome, preco, estoque);
                produtos.add(produto);
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

    public static void escreverArquivo(String caminhoArquivo, String linhaTexto){

        FileWriter escritor = null;

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
        finally {
            if (escritor != null) {
                try {
                    escritor.close(); // Fecha o FileWriter após a operação
                } catch (IOException e) {
                    FachadaJOptionsPane.exibirMensagemError("Erro ao fechar o arquivo.", null);
                    e.printStackTrace(); // Mostra o rastreamento da exceção para diagnóstico
                }
            }
        }
    }
}
