import com.example.Animal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;

public class AnimalTests {

    final Animal animal = new Animal();
    final String getFamilyString = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";


    static Stream<Arguments> foodData() {
        return Stream.of(
                Arguments.of("Травоядное", List.of("Трава", "Различные растения")),
                Arguments.of("Хищник", List.of("Животные", "Птицы", "Рыба"))
        );
    }

    @ParameterizedTest
    @MethodSource("foodData")
    public void testValidGetFood(String animalKind, List<String> expectedFood) throws Exception {
        assertEquals(expectedFood, animal.getFood(animalKind), "Должно возвращать корректный список");
    }

    @Test
    public void getFoodUnknownAnimalTest() {
        Exception exception = assertThrows(
                Exception.class,
                () -> animal.getFood("Неизвестное")
        );

        assertEquals(
                "Неизвестный вид животного, используйте значение Травоядное или Хищник",
                exception.getMessage()
        );
    }


    @Test
    public void testGetFamily() {
        assertEquals(getFamilyString, animal.getFamily(), "Должно возвращать корректные семейства");
    }

}
