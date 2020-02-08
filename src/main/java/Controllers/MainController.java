package Controllers;

import Dtos.BearDto;
import Models.Animals.Animal;
import Services.Animals.BearFactory;
import Services.Animals.IAnimalService;
import Views.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainController {
    private IAnimalService animalService;
    private Main mainView;

    public MainController(IAnimalService animalService, Main mainView){
        this.animalService = animalService;
        this.mainView = mainView;

        mainView.addAnimalListener(new AddAnimalListener());
    }

    public void show(){
        mainView.show();
    }

    class AddAnimalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            try{
                String animalType = mainView.bearTypesComboBox.getSelectedItem().toString();
                String lastEatTime = mainView.lastEatTimeField.getText();
                String name = mainView.nameField.getText();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime lastEatTimeAsDate = LocalDateTime.parse(lastEatTime, formatter);

                BearDto dto = new BearDto();
                dto.type = animalType;
                dto.lastEatTime = lastEatTimeAsDate;
                dto.name = name;

                BearFactory factory  = new BearFactory();
                Animal animalToAdd = factory.Create(dto);

                animalService.add(animalToAdd);

                mainView.addChosenAnimalButton.setBackground(Color.GREEN); // a very basic way to show that everything went fine - it would be better to show some dialog with "Success!" text
            }catch(Exception ex){
                mainView.addChosenAnimalButton.setBackground(Color.RED); // a very basic way to show that something went wrong - it would be better to show some dialog with "Something went wrong, please contact your system administrator" text
            }
        }
    }
}
