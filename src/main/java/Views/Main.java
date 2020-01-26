package Views;

import Constants.BearSpecies;
import Dtos.BearDto;
import Models.Animals.Animal;
import Services.Animals.AnimalService;
import Services.Animals.BearFactory;
import Services.Animals.IAnimalService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * This Main view should be used in Controller class, but we do not complicate things for now,
 * so we define our logic directly in it.
 * If you want to use console version of this map, see Program class
 */
public class Main extends JFrame {

    /**
     * This is the main panel in which all others buttons, textfields etc. are contained
     */
    public JPanel jPanel;
    private JButton getAllAnimalsButton;
    private JLabel animalCountLabel;
    private JTextField animalCountField;
    private JTextField chosenAnimalCountField;
    private JComboBox bearTypesComboBox;
    private JButton getChosenAnimalCountButton;
    private JButton addChosenAnimalButton;
    private JTextField nameField;
    private JTextField lastEatTimeField;

    public Main(IAnimalService animalService) {
        // set combo box possible values (we define them here instead of Designer, to avoid typos and further errors)
        bearTypesComboBox.setModel(new DefaultComboBoxModel<>(
                BearSpecies.BearSpeciesList.toArray(new String[0])
        ));

        /**
         * Below is defined logic to be performed on button's click event (on the button with fieldName 'button1')
         */
        getAllAnimalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int animalCount = animalService.getNumberOfAllAnimals();
                animalCountField.setText(String.valueOf(animalCount));
            }
        });
        getChosenAnimalCountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<String, Integer> animalCountPerSpecies = animalService.getAnimalsCount();
                int chosenAnimalCount = animalCountPerSpecies.get(bearTypesComboBox.getSelectedItem());
                chosenAnimalCountField.setText(String.valueOf(chosenAnimalCount));
            }
        });

        addChosenAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    String animalType = bearTypesComboBox.getSelectedItem().toString();
                    String lastEatTime = lastEatTimeField.getText();
                    String name = nameField.getText();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    LocalDateTime lastEatTimeAsDate = LocalDateTime.parse(lastEatTime, formatter);

                    BearDto dto = new BearDto();
                    dto.type = animalType;
                    dto.lastEatTime = lastEatTimeAsDate;
                    dto.name = name;

                    BearFactory factory  = new BearFactory();
                    Animal animalToAdd = factory.Create(dto);

                    animalService.add(animalToAdd);

                    addChosenAnimalButton.setBackground(Color.GREEN); // a very basic way to show that everything went fine - it would be better to show some dialog with "Success!" text
                }catch(Exception ex){
                    addChosenAnimalButton.setBackground(Color.RED); // a very basic way to show that something went wrong - it would be better to show some dialog with "Something went wrong, please contact your system administrator" text
                }
            }
        });
    }

    /**
     * This main method should be defined elsewhere, for example in Program.java class
     * and logic regarding creating JFrame etc. should be defined in Controller classes
     *
     * @param args
     */
    public static void main(String args[]) {
        JFrame frame = new JFrame("App"); // we create frame to contain view components of our app

        IAnimalService animalService = new AnimalService();
        Main mainView = new Main(animalService);

        frame.setContentPane(mainView.jPanel); // we set jPanel (the one from designer) to be the one used as view source for JFrame 'frame'
        frame.pack(); // we set frame to adjust its size to the elements it contains
        frame.setSize(600,600); // set width and height in pixels, for the window
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // exit the program when X is clicked in the right-upper corner
        frame.setVisible(true); // show frame
    }
}