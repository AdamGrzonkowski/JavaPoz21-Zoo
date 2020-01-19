package Services.Animals;

import Constants.AttackType;
import Models.Animals.Animal;

import java.util.Map;

public interface IAnimalService {
    int getNumberOfAllAnimals();
    Map<String, Integer> getAnimalsCount();

    String display(Animal animal);
    AttackType attack(Animal animal);
}
