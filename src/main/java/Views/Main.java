package Views;

import Services.Animals.AnimalService;
import Services.Animals.IAnimalService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton button1;
    private JLabel animalCountLabel;
    private JTextField animalCountField;

    public Main(IAnimalService animalService) {
        /**
         * Define logic to be performed on button's click event (on the button with fieldName 'button1')
         */
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int animalCount = animalService.getNumberOfAllAnimals();
                animalCountField.setText(String.valueOf(animalCount));
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