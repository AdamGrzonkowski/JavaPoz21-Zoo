import Animals.Bear;
import Animals.BlackBear;
import Animals.BrownBear;
import Animals.PolarBear;

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
        //Animals.Bear tb = new Toys.TeddyBear();

        // Mockito <-------------

        ArrayList<Bear> animalList = new ArrayList<>();
        animalList.add(blb);
        animalList.add(brb);
        animalList.add(plb);
        //animalList.add(tb);

        for (int i=0; i < animalList.size(); i++){
            Bear currentBear = animalList.get(i);
            System.out.println(currentBear.display() + " " + currentBear.getWeight()+ " " + currentBear.attack() + " " + currentBear.isAlive());
        }
    }
}