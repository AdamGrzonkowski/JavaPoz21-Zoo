package Services;

import Constants.AttackType;
import Models.Animals.*;
import Services.Animals.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

public class AnimalsServiceTest {
    @Test
    public void Display_Always_ReturnsStringContainingInfoAboutAnimal(){
        IAnimalService animalService = new AnimalService();
        Animal bear = new BlackBear.BlackBearBuilder().build();
        String expected = bear.getInfo();

        String actual = animalService.display(bear);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void Attack_Always_ReturnsAttackTypeOfAnimal(){
        IAnimalService animalService = new AnimalService();
        Animal bear = new BlackBear.BlackBearBuilder().build();
        AttackType expected = bear.getAttackType();

        AttackType actual = animalService.attack(bear);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void GetNumberOfAllAnimals_Always_ReturnsCorrectNumberOfAnimals(){
        IAnimalService animalService = new AnimalService();
        ((AnimalService) animalService).blackBears.add(new BlackBear.BlackBearBuilder().build());
        ((AnimalService) animalService).brownBears.add(new BrownBear());
        ((AnimalService) animalService).brownBears.add(new BrownBear());
        ((AnimalService) animalService).polarBears.add(new PolarBear());

        int actual = animalService.getNumberOfAllAnimals();

        Assert.assertEquals(4, actual);
    }

    @Test
    public void GetNumberOfAllAnimals_IfThereAreNoAnimalsInZoo_ReturnsZero(){
        IAnimalService animalService = new AnimalService();

        int actual = animalService.getNumberOfAllAnimals();

        Assert.assertEquals(0, actual);
    }

    @Test
    public void GetAnimalsCount_IfThereAreNoAnimalsInZoo_ReturnsZeroPerAnimalType(){
        IAnimalService animalService = new AnimalService();
        Map<String,Integer> expected = new HashMap<>();
        expected.put("Black Bears", 0);
        expected.put("Brown Bears", 0);
        expected.put("Polar Bears", 0);

        Map<String,Integer> actual = animalService.getAnimalsCount();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void GetAnimalsCount_Always_ReturnsCorrectNumberPerAnimalType(){
        IAnimalService animalService = new AnimalService();
        ((AnimalService) animalService).blackBears.add(new BlackBear.BlackBearBuilder().build());
        ((AnimalService) animalService).brownBears.add(new BrownBear());
        ((AnimalService) animalService).brownBears.add(new BrownBear());
        ((AnimalService) animalService).brownBears.add(new BrownBear());
        ((AnimalService) animalService).polarBears.add(new PolarBear());
        ((AnimalService) animalService).polarBears.add(new PolarBear());

        Map<String, Integer> expected = new HashMap<>();
        expected.put("Black Bears", 1);
        expected.put("Brown Bears", 3);
        expected.put("Polar Bears", 2);

        Map<String,Integer> actual = animalService.getAnimalsCount();

        Assert.assertEquals(expected, actual);
    }
}
