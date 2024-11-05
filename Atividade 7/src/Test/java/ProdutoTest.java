import br.com.javaemtudo.Produto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    @Test
    public void testCriarProduto() {
        Produto produto = new Produto("Produto X", 30.0);
        assertEquals("Produto X", produto.getNome());
        assertEquals(30.0, produto.getPreco());
    }

    @Test
    public void testEqualsMesmoNome() {
        Produto produto1 = new Produto("Produto Y", 35.0);
        Produto produto2 = new Produto("Produto Y", 40.0);
        assertEquals(produto1, produto2, "Produtos com o mesmo nome devem ser iguais");
    }

    @Test
    public void testHashCodeMesmoNome() {
        Produto produto1 = new Produto("Produto Z", 45.0);
        Produto produto2 = new Produto("Produto Z", 50.0);
        assertEquals(produto1.hashCode(), produto2.hashCode(), "Produtos com o mesmo nome devem ter o mesmo hashCode");
    }

    @Test
    public void testCompareToPrecoMenor() {
        Produto produto1 = new Produto("Produto A", 15.0);
        Produto produto2 = new Produto("Produto B", 25.0);
        assertTrue(produto1.compareTo(produto2) < 0, "Produto com preço menor deve ser considerado menor");
    }

    @Test
    public void testCompareToPrecoMaior() {
        Produto produto1 = new Produto("Produto A", 35.0);
        Produto produto2 = new Produto("Produto B", 20.0);
        assertTrue(produto1.compareTo(produto2) > 0, "Produto com preço maior deve ser considerado maior");
    }

    @Test
    public void testCompareToPrecoIgual() {
        Produto produto1 = new Produto("Produto A", 30.0);
        Produto produto2 = new Produto("Produto A", 30.0);
        assertEquals(0, produto1.compareTo(produto2), "Produtos com o mesmo preço devem ser considerados iguais");
    }
}
