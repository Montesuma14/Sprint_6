import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CatTests {

    Cat cat;
    @Mock
    private Feline feline;

    @Test
    public void testConstructor() throws Exception {
        List<String> list = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(list);
        cat = new Cat(feline);
        assertEquals(list, cat.getFood(), "Должно возвращать корректный лист");
    }

    @Test
    public void testGetSound() {
        cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound(), "Должно возвращать корректный звук");
    }

}
