package Services.Animals;

import Constants.AttackType;
import Models.Animals.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalService implements IAnimalService {
    List<Animal> allAnimals = new ArrayList<>();

    @Override
    public int getNumberOfAllAnimals() {
        return allAnimals.size();
    }

    @Override
    public Map<String, Integer> getAnimalsCount() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        throw new NotImplementedException();
    }

    @Override
    public String display(Animal animal) {
        return animal.getInfo();
    }

    @Override
    public AttackType attack(Animal animal) {
        return animal.getAttackType();
    }
}
