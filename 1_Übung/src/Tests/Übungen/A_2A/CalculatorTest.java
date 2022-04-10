package Tests.Übungen.A_2A;

import Übungen.A_2A.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//https://www.jetbrains.com/help/idea/junit.html
class CalculatorTest{

    private final Calculator calc = new Calculator();

    @Test
    void add() {
        assertEquals(2, calc.add(1,1));
    }

    /*@Test
    void addDontWork() {
        assertEquals(, calc.add(1,1));
    }*/

    @Test
    void addList() {
        assertEquals(4, calc.addList(new double[] {1,2,1}));
    }
}