import Models.Animals.Bear;
import Models.Animals.BlackBear;
import Models.Animals.BrownBear;
import Models.Animals.PolarBear;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Program {
    public static void main(String args[]){
        System.out.println("Hello!");

        Bear bear = new BlackBear((LocalDateTime.now().plusDays(-1)));
        bear.isAlive();

        System.out.println(bear.getWeight());

        Bear blb = new BlackBear();
        Bear brb = new BrownBear();
        Bear plb = new PolarBear(LocalDateTime.now());
        //Models.Animals.Bear tb = new Models.Toys.TeddyBear();

        // Mockito <------------- one of the main reasons for using Interfaces and Composition

        ArrayList<Bear> animalList = new ArrayList<>();
        animalList.add(blb);
        animalList.add(brb);
        animalList.add(plb);
        //animalList.add(tb);

        for (int i=0; i < animalList.size(); i++){
            Bear currentBear = animalList.get(i);
            System.out.println(currentBear.getInfo() + " " + currentBear.getWeight()+ " " + currentBear.getAttackType() + " " + currentBear.isAlive());
        }
    }
}