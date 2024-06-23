package trabalhoFacade;

// OBS: para rodar o programa, lembre-se de mudar o caminho dos arquivos na classe Constantes. Se não funcionar com caminho relativo, tente com o absoluto

/* 
 * produto.csv: id, nome, preço, estoque
 * item.csv: id, quantidade, idProduto, preçoTotal
*/

public class Main {
    public static void main(String[] args) throws Exception {

        // Verifica se o arquivo item.csv está vazio. Se não estiver, apaga todas as informações
        FachadaArquivo.verificarEApagarItemCSV();
        
        // Roda toda a lógica do programa
        FachadaPedido.notaFiscal();
    }
}
