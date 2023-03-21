import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;// = new Feline();


    @Test
    public void getSound() {
        Cat cat = new Cat(feline);
        String expect = "Мяу";
        String res = cat.getSound();
        assertEquals("Ожидаемое значение " + expect + " возвращенное значение " + res, res, expect);
    }

    @Test //Проверяем обработку для хищников
    public void getFoodPositive() throws Exception {
        List<String> foods = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(foods);
        Assert.assertEquals(foods, new Cat(feline).getFood());
    }

}