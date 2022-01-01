package ca1;

// imports
import java.time.*;
import javax.swing.JOptionPane;

// Class: DIT/FT/1B/01
// Admission Number: 2002161
// Name: Skylar Phua
public class StudentUser {

    public static void main(String[] args) {
        int input = 0;
        StudentManagement studM = new StudentManagement();
        //--------------------------------------
        Instant start = Instant.now();
        //--------------------------------------

        do {
            // This is to get user input
            String userInput = JOptionPane.showInputDialog(null, "Enter your option: \n\n1. Display all students \n2. Search Student By Name \n3. Search Module By Name \n4. Print Statistic \n5. Exit\n\n", "Mini Student System", JOptionPane.QUESTION_MESSAGE);
            // This is to validate numeric inputs only
            try {
                input = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a numerical input", "Error", JOptionPane.ERROR_MESSAGE);
            }
            // This is to call the methods and validate the user input
            switch (input) {
                case 1:
                    studM.generate();
                    studM.displayAll();
                    break;
                case 2:
                    String nameInput = JOptionPane.showInputDialog(null, "Enter the Student name to search:", "Input", JOptionPane.QUESTION_MESSAGE);
                    studM.generate();
                    studM.searchByName(nameInput);
                    break;
                case 3:
                    String moduleInput = JOptionPane.showInputDialog(null, "Enter the Module name to search:", "Input", JOptionPane.QUESTION_MESSAGE);
                    studM.generate();
                    studM.searchByModule(moduleInput);
                    break;
                case 4:
                    studM.generate();
                    studM.printStatistic();
                    break;
                case 5:
                    //--------------------------------------
                    Instant end = Instant.now();
                    Duration timeElapsed = Duration.between(start, end);
                    long minutes = (timeElapsed.toMillis() / 1000) / 60;
                    long seconds = (timeElapsed.toMillis() / 1000) % 60;
                    //--------------------------------------
                    JOptionPane.showMessageDialog(null, "Program terminated. \nThank You!\nUsage time: " + minutes + " minutes " + seconds + " seconds.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option! Please enter in the range from 1 to 5.", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (input != 5);

    }

}
