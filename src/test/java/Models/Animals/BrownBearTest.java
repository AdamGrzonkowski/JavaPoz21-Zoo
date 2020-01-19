package Models.Animals;

import Constants.AttackType;
import org.junit.Assert;
import org.junit.Test;

public class BrownBearTest {
    @Test
    public void GetWeight_Always_Returns50(){
        Bear bear = new BrownBear();
        Assert.assertEquals(bear.getWeight(), 100);
    }

    @Test
    public void GetAttackType_Always_ReturnsHurt(){
        Bear bear = new BrownBear();
        Assert.assertEquals(AttackType.HURT, bear.getAttackType());
    }

    @Test
    public void GetInfo_Always_ReturnsStringContainingSubspeciesOfBear(){
        Bear bear = new BrownBear();
        Assert.assertTrue(bear.getInfo().contains("Brown"));
    }
}
