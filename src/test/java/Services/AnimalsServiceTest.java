package Services;

import Constants.AttackType;
import Models.Animals.Animal;
import Models.Animals.BlackBear;
import Services.Animals.AnimalService;
import Services.Animals.IAnimalService;
import org.junit.Assert;
import org.junit.Test;

public class AnimalsServiceTest {
    @Test
    public void Display_Always_ReturnsStringContainingInfoAboutAnimal(){
        IAnimalService animalService = new AnimalService();
        Animal bear = new BlackBear();

        String displayMsg = animalService.display(bear);
        Assert.assertEquals(bear.getInfo(), displayMsg);
    }

    @Test
    public void Attack_Always_ReturnsAttackTypeOfAnimal(){
        IAnimalService animalService = new AnimalService();
        Animal bear = new BlackBear();

        AttackType attackMsg = animalService.attack(bear);
        Assert.assertEquals(bear.getAttackType(), attackMsg);
    }
}
