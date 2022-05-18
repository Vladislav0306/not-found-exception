import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartphoneTest {
    @Test
    void setManufacturer() {
        Smartphone smartphone = new Smartphone();
        smartphone.setManufacturer("Huawei");
        String expected = "Huawei";
        String actual = smartphone.getManufacturer();
        assertEquals(expected, actual);
    }

    @Test
    void equals1() {
        Smartphone smartphone1 = new Smartphone(4, "P40 Lite", 20000, "Huawei");
        Smartphone smartphone2 = new Smartphone(smartphone1.getId(), smartphone1.getName(), smartphone1.getPrice(), smartphone1.getManufacturer());
        assertEquals(smartphone1, smartphone2);
    }

    @Test
    void equals2() {
        Smartphone smartphone1 = new Smartphone(4, "P40 Lite", 20000, "Huawei");
        Smartphone smartphone2 = new Smartphone();
        assertNotEquals(smartphone1, smartphone2);
    }

    @Test
    void equals3() {
        Smartphone smartphone1 = new Smartphone(4, "P40 Lite", 20000, "Huawei");
        Object o = null;
        assertNotEquals(smartphone1, o);
    }

    @Test
    void equals4() {
        Smartphone smartphone1 = new Smartphone(4, "P40 Lite", 20000, "Huawei");
        Smartphone smartphone2 = new Smartphone(smartphone1.getPrice(), smartphone1.getManufacturer(), smartphone1.getId(), smartphone1.getName());
        assertNotEquals(smartphone1, smartphone2);
    }

    @Test
    void equals5() {
        Smartphone smartphone1 = new Smartphone(4, "P40 Lite", 20000, "Huawei");
        Smartphone smartphone2 = new Smartphone(4, "P40 Lite", 19000, "Huawei");
        assertNotEquals(smartphone1, smartphone2);
    }

    @Test
    void equals6() {
        Smartphone smartphone1 = new Smartphone(4, "P40 Lite", 20000, "Huawei");
        Smartphone smartphone2 = new Smartphone(4, "Galaxy S21 5G", 19000, "Samsung");
        assertNotEquals(smartphone1, smartphone2);
    }

    @Test
    void equals7() {
        Smartphone smartphone1 = new Smartphone(4, "P40 Lite", 20000, "Huawei");
        Object o = smartphone1;
        assertEquals(smartphone1, o);
    }

    @Test
    void toString1() {
        Smartphone smartphone = new Smartphone(4, "P40 Lite", 20000, "Huawei");
        String string = smartphone.toString();
        assertNotEquals(smartphone, string);
    }

    @Test
    void hashCode1() {
        Smartphone smartphone1 = new Smartphone(4, "P40 Lite", 20000, "Huawei");
        Smartphone smartphone2 = new Smartphone(smartphone1.getId(), smartphone1.getName(), smartphone1.getPrice(), smartphone1.getManufacturer());
        assertEquals(smartphone1.hashCode(), smartphone2.hashCode());
    }

    @Test
    void shouldReturnTrueOnSmartphoneManufacturer() {
        Smartphone smartphone = new Smartphone(4, "P40 Lite", 20000, "Huawei");
        assertTrue(smartphone.matches("Huawei"));
    }

    @Test
    void shouldReturnFalseOnSmartphoneManufacturer() {
        Smartphone smartphone = new Smartphone(4, "P40 Lite", 20000, "Huawei");
        assertFalse(smartphone.matches("Samsung"));
    }

    @Test
    void shouldReturnTrueOnSmartphoneName() {
        Smartphone smartphone = new Smartphone(4, "P40 Lite", 20000, "Huawei");
        assertTrue(smartphone.matches("P40 Lite"));
    }

    @Test
    void shouldReturnFalseOnSmartphoneName() {
        Smartphone smartphone = new Smartphone(4, "P40 Lite", 20000, "Huawei");
        assertFalse(smartphone.matches("Galaxy S21 5G"));
    }
}