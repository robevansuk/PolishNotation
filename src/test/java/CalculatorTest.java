import org.example.Calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator testObject;

    @BeforeEach
    void setUp() {
        testObject  = new Calculator();
    }

    @Test
    void shouldCalculateResultOfInstruction() {
        assertEquals(9l, testObject.calculate("5 4 +"));
    }

    // 3 (enter) 4 − 5 + -> 3 4 - 5 + = 3 - 4 + 5
    // 3 − 4 + 5 -> 3 4 - 5 +
    // 3 4 + 5 6 + ×
    // 7 11 x
    @Test
    void shouldCalculateResultOfMoreThanOneInstruction() {
        assertEquals(4l, testObject.calculate("3 4 - 5 +")); // 3 - 4 + 5 = 4
    }

    @Test
    void shouldCalculateResultOfMoreThanOneInstructionWithMultiplication() {
        assertEquals(77l, testObject.calculate("3 4 + 5 6 + *")); // 3 + 4 * 5 + 6 -> (3+4)*(5*6) -> 7 * 11 = 77
    }

    @Test
    void shouldCalculateResultOfMoreThanOneInstructionWithSubtractionAndDivision() {
        assertEquals(1l, testObject.calculate("3 4 - 5 6 - /")); // 3 - 4 / 5 - 6 = -1 / -1 = 1
    }
}