package com.stephanie;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PetSurvey extends JFrame {
    private JPanel rootPanel;
    private JCheckBox dogCheckBox;
    private JCheckBox catCheckBox;
    private JCheckBox fishCheckBox;
    private JLabel surveyResultsLabel;
    private JButton quitButton;

    private boolean dog;
    private boolean cat;
    private boolean fish;


    protected PetSurvey(){
        setContentPane(rootPanel); //set the contents of the window to be the rootPanel JPanel
        pack(); //add the components to the window
        setSize(new Dimension(350,200)); // set the size. user can always resize
        setTitle("Pet Survey"); // sets the text in the title bar
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //close the program when you close the window
        setVisible(true); // make this visible

        fishCheckBox.addItemListener(new ItemListener() {
                                         @Override
                                         public void itemStateChanged(ItemEvent e) {
                                             fish = fishCheckBox.isSelected();
                                             updateResults();
                                         }
                                     });
        dogCheckBox.addItemListener(new ItemListener() {
                                        @Override
                                        public void itemStateChanged(ItemEvent e) {
                                            dog = dogCheckBox.isSelected();
                                            updateResults();
                                        }
                                    });

               catCheckBox.addItemListener(new ItemListener() {
                   @Override
                   public void itemStateChanged(ItemEvent e) {
                    cat = catCheckBox.isSelected();
                       updateResults();
                   }
               });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int quit = JOptionPane.showConfirmDialog(PetSurvey.this, "Are you sure you want to quit?",
                       "Quit", JOptionPane.OK_CANCEL_OPTION);
                if (quit == JOptionPane.OK_CANCEL_OPTION);
                System.exit(0);
            }
        });
    }

            private void updateResults(){
                String hasDog = dog ? "one dog" : "no dogs";
                String hasCat = cat ? "one cat" : "no cats";
                String hasFish = fish ? " one fish" : " no fish";

                String results = "you have " + hasDog + " and " + hasCat + " and" + hasFish;
                surveyResultsLabel.setText(results);
            }
}