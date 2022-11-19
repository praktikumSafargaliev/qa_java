package animal.predator.feline.lion;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;

import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class LionTest {

    private Lion lion;
    private final String sex;

    public LionTest (String sex) {
        this.sex = sex;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"Самец"},
                {"Самка"}
        };
    }

    @Mock
    Feline feline;

    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
        lion = new Lion(feline, sex);
    }

    @Test
    public void exceptionTest() {
        try {
            lion = new Lion(feline, "");
        } catch (Exception exception){
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }

    @Test
    public void getKittensTest() {
        Mockito.when(lion.getKittens()).thenReturn(1);
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void doesHaveManeTest() {
        switch (sex) {
            case "Самец":
                Assert.assertTrue(lion.doesHaveMane());
                break;
            case "Самка":
                Assert.assertFalse((lion.doesHaveMane()));
                break;
            default:
                fail();
        }

    }

    @Test
    public void getFoodTest() throws Exception {
        Mockito.when(lion.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

}
