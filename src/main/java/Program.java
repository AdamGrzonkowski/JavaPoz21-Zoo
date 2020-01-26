import Dtos.BearDto;
import Models.Animals.*;
import Services.Animals.AnimalService;
import Services.Animals.IAnimalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * This is an entry point for console version of this map.
 * If you want to use UI version, implemented in Swing, go to the
 * @see Views.Main
 */
public class Program {

    public static final String DateTimeFormat = "yyyy-MM-dd HH:mm";

    private static final Logger logger =
            LoggerFactory.getLogger(Program.class);

    public static void main(String args[]){
        try{
            MainProgramMethod();
        }
        catch(DateTimeParseException ex){
            logger.warn("Exception during parsing to DateTime. Expected format: " + DateTimeFormat, ex);
        }
        catch(Exception ex){
            logger.error(ex.getMessage(), ex);
            // handle exception here - log it into file
        }
        finally{
            MainProgramMethod(); // a HACK to always continue program after exception - not recommended!!! Only for learning purposes
        }
    }

    public static void MainProgramMethod(){
        System.out.println("Welcome to the zoo app!");
        System.out.println("What would you like to do?");
        System.out.println("[add ANIMAL_NAME] - add new animal to the zoo");
        System.out.println("[getCountOfAll] - returns number of all animals in the zoo");
        System.out.println("[getCountOf ANIMAL_NAME] - returns number of a given animals in the zoo");
        System.out.println("[quit] / [exit] - terminates the program");

        IAnimalService animalService = new AnimalService();
        Scanner in = new Scanner(System.in);

        while (true){
            String command = in.nextLine();
            ProcessCommand(command, animalService);
        }
    }

    public static void ProcessCommand(String command, IAnimalService animalService){
        String[] splitted = command.split(" ", 2);
        String commandType = splitted[0];
        String animalType = null;

        switch(commandType){
            case "getCountOfAll":
                int numberOfAllAnimals = animalService.getNumberOfAllAnimals();
                System.out.println(numberOfAllAnimals);

                break;
            case "getCountOf":
                animalType = splitted[1];
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
            case "add":
                animalType = splitted[1];
                System.out.println("Give date/time of last feeding:");
                String lastEatTime = new Scanner(System.in).nextLine();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime lastEatTimeAsDate = LocalDateTime.parse(lastEatTime, formatter);

                BearDto dto = new BearDto();
                dto.type = animalType;
                dto.lastEatTime = lastEatTimeAsDate;

                BearFactory factory  = new BearFactory();
                Animal animalToAdd = factory.Create(dto);

                animalService.add(animalToAdd);
                System.out.println("Animal has been added!");

                break;
            default:
                System.out.println("Wrong use of options! Please try again...");
                break;
        }
    }
}