import org.junit.Assert;
import org.junit.Test;

public class BrownBearTest {
    @Test
    public void GetWeight_Always_Returns50(){
        Bear bear = new BrownBear();
        Assert.assertEquals(bear.getWeight(), 100);
    }

    @Test
    public void Display_Always_ReturnsStringContainingTypeOfBear(){
        BrownBear bear = new BrownBear();

        String displayMsg = bear.display();
        Assert.assertTrue(displayMsg.contains("Brown"));
    }

    @Test
    public void Attack_Always_ReturnsStringContainingRane(){
        BrownBear bear = new BrownBear();

        String attackMsg = bear.attack();
        Assert.assertTrue(attackMsg.contains("ranę"));
    }
}
