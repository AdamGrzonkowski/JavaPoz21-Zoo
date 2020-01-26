package Services.Animals;

import Constants.AttackType;
import Constants.BearSpecies;
import Models.Animals.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalService implements IAnimalService {
    public List<BlackBear> blackBears = new ArrayList<>();
    public List<BrownBear> brownBears = new ArrayList<>();
    public List<PolarBear> polarBears = new ArrayList<>();


    List<Animal> animals = new ArrayList<>();

    @Override
    public int getNumberOfAllAnimals() {
        return blackBears.size() + brownBears.size() + polarBears.size();
    }

    @Override
    public Map<String, Integer> getAnimalsCount() {
        Map<String, Integer> map = new HashMap<>();
        map.put(BearSpecies.BlackBear, blackBears.size());
        map.put(BearSpecies.BrownBear, brownBears.size());
        map.put(BearSpecies.PolarBear, polarBears.size());

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

    @Override
    public void add(Animal animal) {
        animals.add(animal);

        // ----------------------------------
        // below is not the best solution (HACK) as it requires modifying this method after each new bear type being added, but
        // it's here as we don't have dedicated BlackBearService, BrownBearService or PolarBearService which would handle these things themselves
        // or we could just use one Bear class with some "Type" field and references to Animal, but this requires some basic
        // knowledge about databases, relations, normalization etc. and that's still to be learned, so we use below for now
        if (animal instanceof BlackBear){
            blackBears.add((BlackBear) animal);
        }
        else if (animal instanceof BrownBear){
            brownBears.add((BrownBear) animal);
        }
        else if (animal instanceof PolarBear){
            polarBears.add((PolarBear) animal);
        }
    }
}