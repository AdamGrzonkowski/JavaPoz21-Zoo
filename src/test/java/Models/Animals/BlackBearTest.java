package Models.Animals;

import Constants.AttackType;
import org.junit.Assert;
import org.junit.Test;

public class BlackBearTest {
    @Test
    public void GetWeight_Always_Returns50(){
        Bear bear = new BlackBear();
        Assert.assertEquals(bear.getWeight(), 50);
    }

    @Test
    public void GetAttackType_Always_ReturnsHurt(){
        Bear bear = new BlackBear();
        Assert.assertEquals(AttackType.HURT, bear.getAttackType());
    }

    @Test
    public void GetInfo_Always_ReturnsStringContainingSubspeciesOfBear(){
        Bear bear = new BlackBear();
        Assert.assertTrue(bear.getInfo().contains("Black"));
    }
}
