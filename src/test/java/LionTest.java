import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void getKittens() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, new Lion("Самец", feline).getKittens());

    }

    @Test//Проверяем текст возвращаемый исключением
    public void LionConstructorExceptionMessageTest() {
        try {
            new Lion("", feline);
        } catch (java.lang.Exception e) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка", e.getMessage());
        }
    }

    //Проверяем, что при вводе неизвестного пола возникает исключение
    @Test(expected = java.lang.Exception.class)
    public void LionConstructorExceptionTest() throws Exception {
        new Lion("", feline);
    }

    @Test
    public void getFood() throws Exception {
        List<String> expect = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(expect, new Lion("Самка", feline).getFood());
    }

}