import org.junit.Assert;
import org.junit.Test;

public class BlackBearTest {
    @Test
    public void GetWeight_Always_Returns50(){
        Bear bear = new BlackBear();
        Assert.assertEquals(bear.getWeight(), 50);
    }

    @Test
    public void Display_Always_ReturnsStringContainingTypeOfBear(){
        BlackBear bear = new BlackBear();

        String displayMsg = bear.display();
        Assert.assertTrue(displayMsg.contains("Black"));
    }

    @Test
    public void Attack_Always_ReturnsStringContainingRane(){
        BlackBear bear = new BlackBear();

        String attackMsg = bear.attack();
        Assert.assertTrue(attackMsg.contains("ranę"));
    }
}
