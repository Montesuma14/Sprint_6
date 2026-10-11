import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LionParameterizedTest {

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













}
