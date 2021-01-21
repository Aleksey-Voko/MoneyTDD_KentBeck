package tdd.voko;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyExampleTest {

    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        five.times(2);
        assertEquals(10, five.amount);
    }
}
