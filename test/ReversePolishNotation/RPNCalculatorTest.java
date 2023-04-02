package ReversePolishNotation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class RPNCalculatorTest {

    @ParameterizedTest
    @CsvSource({"34+62+89+43+***, 6664","31+78+987+1214++7++++++, 58"})
    void calculateCorrectNotation(String input, String expected) {
        assertEquals(String.valueOf(expected), RPNCalculator.calculate(input, false));
    }

    @ParameterizedTest
    @ValueSource(strings = {"34+*", "8+9+7*2*"})
    void calculateIncorrectNotation(String input) {
        assertThrows(RuntimeException.class, ()-> RPNCalculator.calculate(input, false),"Incorrect Notation");
    }
}