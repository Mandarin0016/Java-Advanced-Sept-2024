import org.example.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorTests {

    //Тестове:
    // - обикновен void метод анотиран с анотация @Test
    // - не пестим описание за името на метода

    // Ще тествам:
    // 1: Ако добавя 2 и 2 трябва да получа 4
    @Test
    public void whenSumTwoAndTwo_thenExpectResultFour() {

        int a = 2;
        int b = 2;
        int expectedValue = 4;

        int result = Calculator.sum(a, b);

        // Проверявам дали резултата от този метод е това, което очаквам
        // Assertions
        Assertions.assertEquals(expectedValue, result);
    }

    // 2: Ако добавя 8 и 2 трябва да получа 10
    @Test
    public void whenSumEightAndTwo_thenExpectResultTen() {

        int result = Calculator.sum(8, 2);

        // assertEquals(очаквана стойност, реалната стойност)
        Assertions.assertEquals(10, result);
    }


    @ParameterizedTest
    @MethodSource("calculatorParameters")                 // Arrange
    public void whenSumTwoNumbers_thenExpectCorrectResult(int a, int b, int expectedResult) {

        // Act
        int actualResult = Calculator.sum(a, b);

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    public static Stream<Arguments> calculatorParameters() {

        return Stream.of(
                Arguments.of(2, 2, 4),
                Arguments.of(4, 4, 8),
                Arguments.of(10, 10, 20),
                Arguments.of(100, 100, 200),
                Arguments.of(0, 0, 0)
        );
    }

}
