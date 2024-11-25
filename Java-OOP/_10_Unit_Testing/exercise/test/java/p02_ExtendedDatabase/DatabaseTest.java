package p02_ExtendedDatabase;

import javax.naming.OperationNotSupportedException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DatabaseTest {

    private static final Person PERSON1 = Mockito.mock(Person.class);
    private static final Person PERSON2 = Mockito.mock(Person.class);
    private static final Person PERSON3 = Mockito.mock(Person.class);

    private Database database;

    @BeforeEach
    void setUp() throws OperationNotSupportedException {
        database = new Database(PERSON1,
                                PERSON2,
                                null,
                                PERSON3);
        Mockito.when(PERSON1.getUsername()).thenReturn("Peter");
        Mockito.when(PERSON2.getUsername()).thenReturn("Kaloyan");
        Mockito.when(PERSON3.getUsername()).thenReturn("Sofia");

        Mockito.when(PERSON1.getId()).thenReturn(1);
        Mockito.when(PERSON2.getId()).thenReturn(2);
        Mockito.when(PERSON3.getId()).thenReturn(3);
    }

    @Test
    void test_FindByUsername_Should_Throw_When_Username_NotPresent() {

        Assertions.assertThrows(OperationNotSupportedException.class,
                                () -> database.findByUsername("Ivan"));
    }

    @Test
    void test_FindByUsername_Should_Throw_When_Username_Null() {

        Assertions.assertThrows(OperationNotSupportedException.class,
                                () -> database.findByUsername(null));
    }

    @Test
    void test_FindByUsername_Should_Return_Correct_Person() throws OperationNotSupportedException {

        Person actualPerson = database.findByUsername("Kaloyan");

        Assertions.assertEquals(PERSON2, actualPerson);
    }

    @Test
    void test_FindById_Should_Throw_When_Username_NotPresent() {

        Assertions.assertThrows(OperationNotSupportedException.class,
                                () -> database.findById(100));
    }

    @Test
    void test_FindById_Should_Return_Correct_Person() throws OperationNotSupportedException {

        Person actualPerson = database.findById(2);

        Assertions.assertEquals(PERSON2, actualPerson);
    }


    //    @Test
    //    void test_GetElements_Should_Return_Only_NonNull_Elements() {
    //        Arrays.stream(database.getElements())
    //        .forEach(Assertions::assertNotNull);
    //    }

}
