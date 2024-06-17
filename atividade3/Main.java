public class Main {
    public static void main(String[] args){
        FachadaArquivo.lerProdutos();
        FachadaArquivo.lerClientes();

        //Prints da primeira linha dos arquivos produto.csv e client.csv
        String[] produto = FachadaArquivo.lerArquivoLinha(Constantes.caminhoProdutoCSV,1);
        String[] cliente = FachadaArquivo.lerArquivoLinha(Constantes.caminhoClienteCSV, 1);

        System.out.println("Dados da primeira linha dos dois arquivos:");

        for (String dado : produto) {
            System.out.print(dado + " ");
        }

        System.out.println();
        
        for (String dado : cliente) {
            System.out.print(dado + " ");
        }

        System.out.println("\n\nExecutando testes...\n");

        // Instancia a classe de teste
        FachadaArquivoTest testClass = new FachadaArquivoTest();

        // Executa os métodos de teste manualmente
        testClass.testLerArquivoLinha();
        testClass.testLerProdutos();
        testClass.testLerClientes();

        // Exibe mensagem de conclusão
        System.out.println("Testes concluídos.\nNenhum erro!");
    }
}
