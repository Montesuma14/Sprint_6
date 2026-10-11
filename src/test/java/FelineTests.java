import com.example.Feline;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FelineTests {
    @Spy
    private Feline feline;


    @Test
    public void testEatMeat() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline).getFood("Хищник");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat(), "Должен вернуть корректный список хищника");
    }

    @Test
    public void testGetKittensInt() {
        int numberOfKids = 5;
        assertEquals(numberOfKids, feline.getKittens(numberOfKids), "Должно вернуться кол-во детей 5");
    }

    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily(), "Должно вернуться Кошачьи");
    }


    @Test
    public void testGetKittens()  {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }


}
