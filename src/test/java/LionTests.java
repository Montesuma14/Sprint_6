import com.example.Feline;
import com.example.Lion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class LionTests {

    private Lion lion;
    @Mock
    private Feline feline;


    static Stream<Arguments> sexData() {
        return Stream.of(
                Arguments.of("Самец", true),
                Arguments.of("Самка", false)
        );
    }

    @ParameterizedTest
    @MethodSource("sexData")
    public void testLionsConstructor(String sexLion, Boolean hasMane) throws Exception {
        lion = new Lion(sexLion, feline);
        assertEquals(hasMane, lion.doesHaveMane(), "Должно возвращать корректный hasMane");
    }

    @Test
    public void testUnknownLionsSexTest() {

        try {
            lion = new Lion("Незнаем", feline);
        } catch (Exception exception) {
            assertEquals(
                    "Используйте допустимые значения пола животного - самей или самка",
                    exception.getMessage()
            );
        }

    }

    @Test
    void testGetKittens() throws Exception {
        lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(5);
        assertEquals(5, lion.getKittens());
    }

    @Test
    void testGetFood() throws Exception {
        lion = new Lion("Самка", feline);
        List<String> list = List.of("Еда", "Не еда");
        Mockito.when(feline.getFood("Хищник")).thenReturn(list);
        assertEquals(list, lion.getFood());
    }

}
