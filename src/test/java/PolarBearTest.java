import org.junit.Assert;
import org.junit.Test;

public class PolarBearTest {
    @Test
    public void GetWeight_Always_Returns50(){
        Bear bear = new PolarBear();
        Assert.assertEquals(bear.getWeight(), 200);
    }

    @Test
    public void Display_Always_ReturnsStringContainingTypeOfBear(){
        PolarBear bear = new PolarBear();

        String displayMsg = bear.display();
        Assert.assertTrue(displayMsg.contains("Polar"));
    }
}
