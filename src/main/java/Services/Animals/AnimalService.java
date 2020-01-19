package Services.Animals;

import Constants.AttackType;
import Models.Animals.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalService implements IAnimalService {
    public List<BlackBear> blackBears = new ArrayList<>();
    public List<BrownBear> brownBears = new ArrayList<>();
    public List<PolarBear> polarBears = new ArrayList<>();

    @Override
    public int getNumberOfAllAnimals() {
        return blackBears.size() + brownBears.size() + polarBears.size();
    }

    @Override
    public Map<String, Integer> getAnimalsCount() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Black Bears", blackBears.size());
        map.put("Brown Bears", brownBears.size());
        map.put("Polar Bears", polarBears.size());

        return map;
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
