package animal.predator.feline;

import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private Feline feline;

    @Before
    public void init() {
        feline = new Feline();
    }

    @Test
    public void eatMeatTest() throws Exception {
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void getFamilyTest() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutArgTest() {
        Assert.assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithArgTest() {
        Assert.assertEquals(5, feline.getKittens(5));
    }

    @Test
    public void getFoodHerbivoreTest() throws Exception {
        Assert.assertEquals(List.of("Трава", "Различные растения"), feline.getFood("Травоядное"));
    }

    @Test
    public void getFoodPredatorTest() throws Exception {
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.getFood("Хищник"));
    }

    @Test
    public void getFoodExceptionTest(){
        try {
            feline.getFood("");
        } catch (Exception exception){
            Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
        }
    }




}
