package battleShip;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BattleTests {

    private Battle battle;

    @BeforeEach
    void setUp() {
        battle = new Battle("Battle", 10);
    }

    @Test
    void test_Constructor_Should_Create_Correct_Object() {

        assertEquals(10, battle.getCapacity());
        assertEquals(0, battle.getCount());
    }

    @Test
    void test_Constructor_Should_Throw_When_Negative_Capacity() {

        assertThrows(IllegalArgumentException.class,
                     () -> new Battle("Battle", -10)
                    );
    }

    @Test
    void test_getShips_Should_Return_Correct_Ships_In_Battle() {
        battle.addShip(new Ship("Gloria", "Royal", 100, 180, 50));
        battle.addShip(new Ship("Jack", "Pirat", 100, 180, 50));

        Ship ship = battle.getShips().get(0);
        Ship ship2 = battle.getShips().get(1);

        assertEquals(2, battle.getShips().size());
        assertEquals("Gloria", ship.getName());
        assertEquals("Jack", ship2.getName());
    }

    @Test
    void test_getShips_Should_Return_UnmodifiableCollection() {

        assertThrows(UnsupportedOperationException.class,
                     () -> battle.getShips().remove(0));
    }

    @Test
    void test_AddShip_Should_Throw_When_Ship_Null() {
        assertThrows(IllegalArgumentException.class,
                     () -> battle.addShip(null));
    }

    @Test
    void test_AddShip_Should_Throw_When_No_Capacity() {
        battle = new Battle("Battle", 0);
        assertThrows(IllegalArgumentException.class,
                     () -> battle.addShip(new Ship("Gloria", "Royal", 100, 180, 50)));
    }

    @Test
    void test_AddShip_Should_Throw_When_Ship_Exist() {
        battle.addShip(new Ship("Gloria", "Royal", 100, 180, 50));
        assertThrows(IllegalArgumentException.class,
                     () -> battle.addShip(
                     new Ship("Gloria", "Royal", 100, 180, 50)));
    }

    @Test
    void test_AddShip_Should_Add_Successfully() {
        battle.addShip(new Ship("Gloria", "Royal", 100, 180, 50));
        battle.addShip(new Ship("Jack", "Pirat", 100, 180, 50));

        Ship ship = battle.getShips().get(0);
        Ship ship2 = battle.getShips().get(1);

        assertEquals(2, battle.getCount());
        assertEquals("Gloria", ship.getName());
        assertEquals("Jack", ship2.getName());
    }

    @Test
    void test_RemoveShip_Should_Remove_Successfully() {
        battle.addShip(new Ship("Gloria", "Royal", 100, 180, 50));
        battle.addShip(new Ship("Jack", "Pirat", 100, 180, 50));

        assertTrue(battle.removeShip("Royal"));
    }

    @Test
    void test_RemoveShip_Should_Remove_Unsuccessfully() {
        assertFalse(battle.removeShip("Royal"));
    }

    @Test
    void test_getMostPowerfulShip_Should_Return_Correct_Ship() {
        battle.addShip(new Ship("Gloria", "Royal", 100, 180, 50));
        battle.addShip(new Ship("Jack", "Pirat", 100, 180, 150));

        String mostPowerfulShip = battle.getMostPowerfulShip();

        assertEquals("Jack", mostPowerfulShip);
    }

//    @Test
//    void test_getMostPowerfulShip_Should_Throw_Assertion_Error() {
//
//        assertThrows(AssertionError.class,
//                     () -> battle.getMostPowerfulShip());
//    }

    @Test
    void test_findAllShipByAmmunitionMoreThan100_Should_Return_Correct_Ships() {
        battle.addShip(new Ship("Gloria", "Royal", 100, 180, 50));
        battle.addShip(new Ship("Jack", "Pirat", 100, 180, 150));
        battle.addShip(new Ship("Shipppp", "Pirat", 100, 10, 150));
        battle.addShip(new Ship("Shipppp2", "Pirat", 100, 100, 150));

        battle.findAllShipByAmmunitionMoreThan100().forEach(
        ship -> assertTrue(ship.getAmmunition() > 100)
                                                           );
        assertEquals(2, battle.findAllShipByAmmunitionMoreThan100().size());
    }

    @Test
    void test_findAllShipByAmmunitionMoreThan100_Should_Return_EmptyList() {
        assertEquals(0, battle.findAllShipByAmmunitionMoreThan100().size());
    }
}