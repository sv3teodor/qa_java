import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AnimalTest {
    @Test //Проверяем обработку для травоядных
    public void getFoodHerbivoreTestPositive() throws Exception {
        Animal animal = new Animal();
        List<String> expect = List.of("Трава", "Различные растения");
        List<String> res = animal.getFood("Травоядное");
        Assert.assertEquals("Ожидаемое значение " + expect + " возвращенное значение " + res, res, expect);
    }

    @Test //Проверяем обработку для хищников
    public void getFoodPredatorTestPositive() throws Exception {
        Animal animal = new Animal();
        List<String> expect = List.of("Животные", "Птицы", "Рыба");
        List<String> res = animal.getFood("Хищник");
        Assert.assertEquals("Ожидаемое значение " + expect + " возвращенное значение " + res, res, expect);
    }

    //Проверяем вызов исключения при неизвестных параметрах
    @Test(expected = java.lang.Exception.class)
    public void getFoodExceptionTest() throws Exception {
        new Animal().getFood("");
    }

    @Test //Проверяем сообщение которое возвращает исключение
    public void getFoodExceptionMessage() {
        try {
            new Animal().getFood("");
        } catch (Exception e) {
            Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
    }

    @Test
    public void getFoodGetFamily() {
        Animal animal = new Animal();
        String expect = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String res = animal.getFamily();
        Assert.assertEquals("Ожидаемое значение " + expect + " возвращенное значение " + res, res, expect);
    }

}
