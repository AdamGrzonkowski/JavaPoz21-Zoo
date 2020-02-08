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
    public JComboBox bearTypesComboBox;
    private JButton getChosenAnimalCountButton;
    public JButton addChosenAnimalButton;
    public JTextField nameField;
    public JTextField lastEatTimeField;

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
    }

    public void addAnimalListener(ActionListener actionListener){
        addChosenAnimalButton.addActionListener(actionListener);
    }

    public void show(){

        JFrame frame = new JFrame("App"); // we create frame to contain view components of our app

        IAnimalService animalService = new AnimalService();
        Main mainView = this;

        frame.setContentPane(mainView.jPanel); // we set jPanel (the one from designer) to be the one used as view source for JFrame 'frame'
        frame.pack(); // we set frame to adjust its size to the elements it contains
        frame.setSize(600,600); // set width and height in pixels, for the window
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // exit the program when X is clicked in the right-upper corner
        frame.setVisible(true); // show frame
    }
}