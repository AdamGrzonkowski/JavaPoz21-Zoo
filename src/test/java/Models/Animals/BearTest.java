package Models.Animals;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.MILLIS;

public class BearTest {
    @Test
    public void GetLastEatTime_AfterJustCreatingBearObject_ReturnsNull(){
        // Given / When (Arrange / Act)
        Bear bear = new BlackBear.BlackBearBuilder().build();

        // Then (Assert)
        Assert.assertNull(null);
    }

    @Test
    public void GetLastEatTime_AfterEatMethodWasCalled_ReturnsCurrentNewDate(){
        // Given (Arrange)
        Bear bear = new BlackBear.BlackBearBuilder().build();

        // When (Act)
        bear.eat();

        LocalDateTime lastEatDate = bear.getLastEatTime();
        LocalDateTime currentDate = LocalDateTime.now();

        // Then (Assert)
        Assert.assertTrue(MILLIS.between(lastEatDate,currentDate) < 1000);
    }

    @Test
    public void IsAlive_IfDaysBetweenNowAndLastEatTimeIsMoreThan10Days_ReturnsFalse(){
        Bear bear = new BlackBear.BlackBearBuilder()
                .setLastEatTime(LocalDateTime.now().minusDays(11))
                .build();

        boolean isAlive = bear.isAlive();

        Assert.assertFalse(isAlive);
    }

    @Test
    public void IsAlive_IfDaysBetweenNowAndLastEatTimeIsLessThan10Days_ReturnsFalse() {
        Bear bear = new BlackBear.BlackBearBuilder()
                .setLastEatTime(LocalDateTime.now().minusDays(5))
                .build();

        boolean isAlive = bear.isAlive();

        Assert.assertTrue(isAlive);
    }

    @Test
    public void IsAlive_IfDaysBetweenNowAndLastEatTimeIsExactly10Days_ReturnsFalse() {
        Bear bear = new BlackBear.BlackBearBuilder()
                .setLastEatTime(LocalDateTime.now().minusDays(10))
                .build();

        boolean isAlive = bear.isAlive();

        Assert.assertFalse(isAlive);
    }
}
