import Models.Animals.Bear;
import Models.Animals.BlackBear;
import Models.Animals.BrownBear;
import Models.Animals.PolarBear;
import Services.Animals.AnimalService;
import Services.Animals.IAnimalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Program {

    private static final Logger logger =
            LoggerFactory.getLogger(Program.class);

    public static void main(String args[]){
        try{
            int tryToDivideBy0 = 12/0;
            MainProgramMethod();
        }
        catch(Exception ex){
            logger.error(ex.getMessage(), ex);
            MainProgramMethod();
            // handle exception here - log it into file
        }
    }

    public static void MainProgramMethod(){
        System.out.println("Hello!");

        Bear bear = new BlackBear.BlackBearBuilder()
                .setLastEatTime((LocalDateTime.now().plusDays(-1)))
                .build();
        bear.isAlive();

        System.out.println(bear.getWeight());

        Bear blb = new BlackBear.BlackBearBuilder()
                .build();
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

        IAnimalService animalService = new AnimalService();
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to the zoo app!");
        System.out.println("What would you like to do?");
        System.out.println("[getCountOfAll] - returns number of all animals in the zoo");
        System.out.println("[getCountOf ANIMAL_NAME] - returns number of a given animals in the zoo");
        System.out.println("[quit] / [exit] - terminates the program");

        while (true){
            String command = in.nextLine();
            ProcessCommand(command, animalService);
        }
    }

    public static void ProcessCommand(String command, IAnimalService animalService){
        String[] splitted = command.split(" ", 2);
        String commandType = splitted[0];

        switch(commandType){
            case "getCountOfAll":
                int numberOfAllAnimals = animalService.getNumberOfAllAnimals();
                System.out.println(numberOfAllAnimals);

                break;
            case "getCountOf":
                String animalType = splitted[1];
                Map<String, Integer> animalsCount = animalService.getAnimalsCount();
                if (animalsCount.containsKey(animalType)){
                    System.out.println(animalsCount.get(animalType));
                }
                else{
                    System.out.println("We do not have such animal! Animals we have:");
                    System.out.println(animalsCount);
                }

                break;
            case "quit":
            case "exit":
                System.out.println("Thank you for using Zoo app!");
                System.exit(0);

                break;
            default:
                System.out.println("Wrong use of options! Please try again...");
                break;
        }
    }
}