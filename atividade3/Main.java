public class Main {
    public static void main(String[] args){
        FachadaArquivo.lerProdutos();
        FachadaArquivo.lerClientes();

        String[] produto = FachadaArquivo.lerArquivoLinha(Constantes.caminhoProdutoCSV,1);
        String[] cliente = FachadaArquivo.lerArquivoLinha(Constantes.caminhoClienteCSV, 1);

        for (String dado : produto) {
            System.out.print(dado + " ");
        }

        System.out.println();
        
        for (String dado : cliente) {
            System.out.print(dado + " ");
        }
    }
}
