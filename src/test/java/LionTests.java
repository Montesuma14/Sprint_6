import com.example.Feline;
import com.example.Lion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class LionTests {

    private Lion lion;
    @Mock
    private Feline feline;


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
        List<String> list = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(list);
        assertEquals(list, lion.getFood());
    }

}
