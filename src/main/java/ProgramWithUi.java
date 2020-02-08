import Controllers.MainController;
import Services.Animals.AnimalService;
import Services.Animals.IAnimalService;
import Views.Main;

public class ProgramWithUi {

    private MainController _controller;
    /**
     * This main method should be defined elsewhere, for example in Program.java class
     * and logic regarding creating JFrame etc. should be defined in Controller classes
     *
     * @param args
     */
    public static void main(String args[]) {
        IAnimalService animalService = new AnimalService();
        Main mainView = new Main(animalService);
        MainController mainController = new MainController(animalService, mainView);

        mainController.show();
    }
}
