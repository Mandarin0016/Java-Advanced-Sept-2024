import org.example.mockito.LuckyWheel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

public class LuckyWheelTests {

    // Ще тествам:
    // 1. Ако заложа 5 лева и получа числото 100                 - тогава печеля 500 лева
    @Test
    public void whenRisk5LevaAndLuckyNumberIs100_thenWin500Leva() {

        // new Random()               = обикновен обект
        // Mockito.mock(Random.class) = мокнат обект, който лесно мога да манипулирам
        Random random = Mockito.mock(Random.class);
        LuckyWheel wheel = new LuckyWheel(random);

        // Mockito.when(извикване на метод).thenReturn(стойност, която да се върне)
        Mockito.when(random.nextInt()).thenReturn(100);

        int win = wheel.riskAndWin(5);

        Assertions.assertEquals(500, win);
    }

    // 2. Ако заложа 5 лева и получа числото 2                   - тогава печеля 10  лева
    @Test
    public void whenRisk5LevaAndLuckyNumberIs2_thenWin10Leva() {

        Random random = Mockito.mock(Random.class);
        LuckyWheel wheel = new LuckyWheel(random);

        Mockito.when(random.nextInt()).thenReturn(2);

        int win = wheel.riskAndWin(5);

        Assertions.assertEquals(10, win);
    }

    // 3. Ако заложа 5 лева и получа число различно от 2 и 100   - тогава печеля 4 лева
    @Test
    public void whenRisk5LevaAndLuckyNumberIsDifferentThan2And100_thenLose1Leva() {

        Random random = Mockito.mock(Random.class);
        LuckyWheel wheel = new LuckyWheel(random);

        Mockito.when(random.nextInt()).thenReturn(33);

        int win = wheel.riskAndWin(5);

        Assertions.assertEquals(4, win);
    }
}
