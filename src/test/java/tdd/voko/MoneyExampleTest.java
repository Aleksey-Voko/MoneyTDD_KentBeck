package tdd.voko;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyExampleTest {

    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        assertEquals(10, product.amount);
        product = five.times(3);
        assertEquals(15, product.amount);
    }

    @Test
    public void testEquality() {
        assertEquals(new Dollar(5), new Dollar(5));
    }
}
