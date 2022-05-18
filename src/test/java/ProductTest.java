import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    void setId() {
        Product product = new Product();
        product.setId(1);
        int expected = 1;
        int actual = product.getId();
        assertEquals(expected, actual);
    }

    @Test
    void setName() {
        Product product = new Product();
        product.setName("Одна на двоих");
        String expected = "Одна на двоих";
        String actual = product.getName();
        assertEquals(expected, actual);
    }

    @Test
    void setPrice() {
        Product product = new Product();
        product.setPrice(500);
        int expected = 500;
        int actual = product.getPrice();
        assertEquals(expected, actual);
    }

    @Test
    void equals1() {
        Product product1 = new Product(1, "Одна на двоих", 500);
        Product product2 = new Product(product1.getId(), product1.getName(), product1.getPrice());
        assertEquals(product1, product2);
    }

    @Test
    void equals2() {
        Product product1 = new Product(1, "Одна на двоих", 500);
        Product product2 = new Product();
        assertNotEquals(product1, product2);
    }

    @Test
    void equals3() {
        Product product1 = new Product(1, "Одна на двоих", 500);
        Object o = null;
        assertNotEquals(product1, o);
    }

    @Test
    void equals4() {
        Product product1 = new Product(1, "Одна на двоих", 500);
        Product product2 = new Product(product1.getPrice(), product1.getName(), product1.getId());
        assertNotEquals(product1, product2);
    }

    @Test
    void equals5() {
        Product product1 = new Product(1, "Одна на двоих", 500);
        Product product2 = new Product(1, "Одна на двоих", 400);
        assertNotEquals(product1, product2);
    }

    @Test
    void equals6() {
        Product product1 = new Product(1, "Одна на двоих", 500);
        Product product2 = new Product(1, "Эксплеты. Лебединая башня", 500);
        assertNotEquals(product1, product2);
    }

    @Test
    void equals7() {
        Product product1 = new Product(1, "Одна на двоих", 500);
        Object o = product1;
        assertEquals(product1, o);
    }

    @Test
    void toString1() {
        Product product = new Product(1, "Одна на двоих", 500);
        String string = product.toString();
        assertNotEquals(product, string);
    }

    @Test
    void hashCode1() {
        Product product1 = new Product(1, "Одна на двоих", 500);
        Product product2 = new Product(product1.getId(), product1.getName(), product1.getPrice());
        assertEquals(product1.hashCode(), product2.hashCode());
    }

    @Test
    void shouldReturnTrueName() {
        Product product = new Product(1, "Одна на двоих", 500);
        assertTrue(product.matches("Одна на двоих"));
    }

    @Test
    void shouldReturnTrueFalse() {
        Product product = new Product(1, "Одна на двоих", 500);
        assertFalse(product.matches("Эксплеты. Лебединая башня"));
    }
}