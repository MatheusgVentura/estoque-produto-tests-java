import br.com.javaemtudo.Estoque;
import br.com.javaemtudo.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstoqueTest {

    private Estoque estoque;

    @BeforeEach
    public void setUp() {
        estoque = new Estoque();
    }

    @Test
    public void testAdicionarProduto() {
        Produto produto = new Produto("Produto A", 10.0);
        assertTrue(estoque.adicionarProduto(produto));
    }

    @Test
    public void testAdicionarProdutoDuplicado() {
        Produto produto = new Produto("Produto B", 15.0);
        estoque.adicionarProduto(produto);
        assertFalse(estoque.adicionarProduto(produto), "Produto duplicado não deveria ser adicionado");
    }

    @Test
    public void testBuscarProdutoExistente() {
        Produto produto = new Produto("Produto C", 20.0);
        estoque.adicionarProduto(produto);
        assertEquals(produto, estoque.buscarProduto("Produto C"));
    }

    @Test
    public void testBuscarProdutoNaoExistente() {
        assertNull(estoque.buscarProduto("Produto Inexistente"));
    }

    @Test
    public void testRemoverProdutoExistente() {
        Produto produto = new Produto("Produto D", 25.0);
        estoque.adicionarProduto(produto);
        assertTrue(estoque.removerProduto("Produto D"));
        assertNull(estoque.buscarProduto("Produto D"));
    }

    @Test
    public void testRemoverProdutoNaoExistente() {
        assertFalse(estoque.removerProduto("Produto Inexistente"));
    }
}
