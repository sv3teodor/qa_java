import com.example.Feline;
import com.example.LionAlex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {
    @Mock
    Feline feline;

    @Test
    public void getFriends() throws Exception {
        assertEquals(List.of("Зебра Марти", "Бегемотиха Глории", "Жираф Мелман"), new LionAlex(feline).getFriends());
    }

    @Test
    public void getPlaceOfLiving() throws Exception {
        assertEquals("Нью-Йоркский зоопарк", new LionAlex(feline).getPlaceOfLiving());
    }

    @Test
    public void getKittens() throws Exception {
        assertEquals(0, new LionAlex(feline).getKittens());
    }
}