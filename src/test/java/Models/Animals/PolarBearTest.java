package Models.Animals;

import Constants.AttackType;
import org.junit.Assert;
import org.junit.Test;

public class PolarBearTest {
    @Test
    public void GetWeight_Always_Returns50(){
        Bear bear = new PolarBear();
        Assert.assertEquals(200, bear.getWeight());
    }

    @Test
    public void GetAttackType_Always_ReturnsKill(){
        Bear bear = new PolarBear();
        Assert.assertEquals(AttackType.KILL, bear.getAttackType());
    }

    @Test
    public void GetInfo_Always_ReturnsStringContainingSubspeciesOfBear(){
        Bear bear = new PolarBear();
        Assert.assertTrue(bear.getInfo().contains("Polar"));
    }
}
