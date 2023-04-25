import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionSexParamTest {
    private final String sex;
    private final Boolean hasMane;
    @Mock
    Feline feline;

    public LionSexParamTest(String sex, Boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters(name = "Проверка поля льва. Тестовые данные: {0} {1}")
    public static Object[][] getTestParam() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test //Проверяем верный возврат бинарного поля пола
    public void doesHaveMane() throws Exception {
        Assert.assertEquals(hasMane, new Lion(sex, feline).doesHaveMane());
    }

}