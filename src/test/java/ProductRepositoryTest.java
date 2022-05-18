import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductRepositoryTest {
    private final ProductRepository repository = new ProductRepository();
    private final Book book1 = new Book(1, "Одна на двоих", 500, "Франческа Кейт");
    private final Book book2 = new Book(2, "Эксплеты. Лебединая башня", 800, "Ирина Фуллер");
    private final Smartphone smartphone1 = new Smartphone(3, "Galaxy S21 5G", 60000, "Samsung");
    private final Smartphone smartphone2 = new Smartphone(4, "P40 Lite", 20000, "Huawei");

    @BeforeEach
    void prepareManager() {
        repository.save(book1);
        repository.save(book2);
        repository.save(smartphone1);
        repository.save(smartphone2);
    }

    @Test
    public void shouldSaveOneItem() {
        Product[] expected = new Product[]{book1, book2, smartphone1, smartphone2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByFalseId() {
        Assertions.assertThrows(NotFoundException.class, () -> repository.removeById(5));
    }

    @Test
    public void shouldRemoveByTrueId() {
        repository.removeById(1);
    }
}