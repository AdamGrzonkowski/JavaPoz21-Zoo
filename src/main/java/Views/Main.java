package Views;

import javax.swing.*;

/**
 * This Main view should be used in Controller class, but we do not complicate things for now,
 * so we define our logic directly in it.
 */
public class Main extends JFrame {

    private JButton button1;
    public JPanel jPanel;
    private JTextField textField1;

    public static void main(String args[]) {
        JFrame frame = new JFrame("App");

        frame.setContentPane(new Main().jPanel);
        frame.pack();
        frame.setSize(600,600);
        frame.setVisible(true);
    }

}