import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class FachadaArquivoTest {

    @Test
    public void testLerArquivoLinha() {
        String[] linha = FachadaArquivo.lerArquivoLinha(Constantes.caminhoProdutoCSV, 1);
        
        assertNotNull(linha);
        assertEquals(5, linha.length); // Assumindo que a linha tem 5 campos
        assertEquals("1", linha[0]); // Verifique se o primeiro campo é igual ao esperado
    }


    /*
    * Testa a saída para o primeiro produto
    */
    @Test
    public void testLerProdutos() {
        List<Produto> produtos = FachadaArquivo.lerProdutos();

        assertNotNull(produtos);
        assertFalse(produtos.isEmpty());
        
        Produto primeiroProduto = produtos.get(0);
        assertEquals(1, primeiroProduto.getIdProduto());
        assertEquals("Celular", primeiroProduto.getNome());
    }


    /*
    * Testa a saída para o primeiro cliente
    */
    @Test
    public void testLerClientes() {
        List<Cliente> clientes = FachadaArquivo.lerClientes();

        assertNotNull(clientes);
        assertFalse(clientes.isEmpty());
        
        Cliente primeiroCliente = clientes.get(0);
        assertEquals(1, primeiroCliente.getIdCliente());
        assertEquals("João Silva", primeiroCliente.getNome());
    }
}
