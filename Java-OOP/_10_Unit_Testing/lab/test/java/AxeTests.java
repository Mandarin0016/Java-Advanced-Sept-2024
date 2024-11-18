import org.example.Axe;
import org.example.Dummy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AxeTests {

    // Ще тествам:
    // 1. Ако имам брадва с 10 точки издръжливост и атакувам - точките ще станат 9
    @Test
    public void whenAxeHas10PointsDurabilityAndAttack_thenPointsWillBecome9() {

        // 3A Pattern

        // Given
        // Arrange (подготвям обектите, от които имам необходимост)
        Axe axe = new Axe(2, 10);

        // When
        // Act (изпълнявам метода, който се опитвам да тествам)
        axe.attack(new Dummy(5, 5));

        // Then
        // Assert (проверките)
        Assertions.assertEquals(9, axe.getDurabilityPoints());
    }


    // 2. Ако имам брадва с 0 точки издръжливост и атакувам - получавам IllegalStateException грешка
    @Test
    public void whenAxeHas0PointsDurabilityAndAttack_thenExpectIllegalStateException() {

        Axe axe = new Axe(2, 0);

        //assertThrows - проверява дали даден код хвърля грешка
        //assertThrows 2 аргумента:
        //1. Класа на грешката (IllegalStateException.class)
        //2. Кода, който ще хвърли тази грешка
        Assertions.assertThrows(IllegalStateException.class, () -> {
            axe.attack(new Dummy(5, 5));
        });
    }

    @Test
    public void testConstructor() {

        // Arrange & Act
        Axe axe = new Axe(2, 3);

        // Assert
        Assertions.assertEquals(2, axe.getAttackPoints());
        Assertions.assertEquals(3, axe.getDurabilityPoints());
    }

}
