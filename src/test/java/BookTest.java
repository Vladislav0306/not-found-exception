import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    @Test
    void setAuthor() {
        Book book = new Book();
        book.setAuthor("Франческа Кейт");
        String expected = "Франческа Кейт";
        String actual = book.getAuthor();
        assertEquals(expected, actual);
    }

    @Test
    void equals1() {
        Book book1 = new Book(1, "Одна на двоих", 500, "Франческа Кейт");
        Book book2 = new Book(book1.getId(), book1.getName(), book1.getPrice(), book1.getAuthor());
        assertEquals(book1, book2);
    }

    @Test
    void equals2() {
        Book book1 = new Book(1, "Одна на двоих", 500, "Франческа Кейт");
        Book book2 = new Book();
        assertNotEquals(book1, book2);
    }

    @Test
    void equals3() {
        Book book1 = new Book(1, "Одна на двоих", 500, "Франческа Кейт");
        Object o = null;
        assertNotEquals(book1, o);
    }

    @Test
    void equals4() {
        Book book1 = new Book(1, "Одна на двоих", 500, "Франческа Кейт");
        Book book2 = new Book(book1.getPrice(), book1.getAuthor(), book1.getId(), book1.getName());
        assertNotEquals(book1, book2);
    }

    @Test
    void equals5() {
        Book book1 = new Book(1, "Одна на двоих", 500, "Франческа Кейт");
        Book book2 = new Book(2, "Одна на двоих", 500, "Франческа Кейт");
        assertNotEquals(book1, book2);
    }

    @Test
    void equals6() {
        Book book1 = new Book(1, "Одна на двоих", 500, "Франческа Кейт");
        Book book2 = new Book(2, "Эксплеты. Лебединая башня", 500, "Ирина Фуллер");
        assertNotEquals(book1, book2);
    }

    @Test
    void equals7() {
        Book book1 = new Book(1, "Одна на двоих", 500, "Франческа Кейт");
        Object o = book1;
        assertEquals(book1, o);
    }

    @Test
    void toString1() {
        Book book = new Book(1, "Одна на двоих", 500, "Франческа Кейт");
        String string = book.toString();
        assertNotEquals(book, string);
    }

    @Test
    void hashCode1() {
        Book book1 = new Book(1, "Одна на двоих", 500, "Франческа Кейт");
        Book book2 = new Book(book1.getId(), book1.getName(), book1.getPrice(), book1.getAuthor());
        assertEquals(book1.hashCode(), book2.hashCode());
    }

    @Test
    void shouldReturnTrueOnBookName() {
        Book book = new Book(1, "Одна на двоих", 500, "Франческа Кейт");
        assertTrue(book.matches("Одна на двоих"));
    }

    @Test
    void shouldReturnFalseOnBookName() {
        Book book = new Book(1, "Одна на двоих", 500, "Франческа Кейт");
        assertFalse(book.matches("Незабываемый вечер"));
    }

    @Test
    void shouldReturnTrueOnBookAuthor() {
        Book book = new Book(1, "Одна на двоих", 500, "Франческа Кейт");
        assertTrue(book.matches("Франческа Кейт"));
    }

    @Test
    void shouldReturnFalseOnBookAuthor() {
        Book book = new Book(1, "Одна на двоих", 500, "Франческа Кейт");
        assertFalse(book.matches("Ирина Фуллер"));
    }
}