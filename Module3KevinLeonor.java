
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * CSC372 Module 3: Critical Thinking Assignment
 * Creating a User Interface with Menu Options
 * 
 * This program creates a JavaFX application with a menu bar containing four options:
 * 1. Display current date and time in a text area
 * 2. Write text area contents to "log.txt"
 * 3. Change background to a random green hue (fixed per execution)
 * 4. Exit the program
 * 
 * @author Kevin Leonor
 * @version 1.0
 */
public class Module3KevinLeonor extends Application {

    // TextArea to display output
    private TextArea textArea;
    
    // Random green color generated once per program execution
    private final Color randomGreenColor = generateRandomGreen();

    /**
     * Generates a random green hue.
     * This ensures the same green hue is shown each time menu option 3 is selected
     * during a single execution of the program.
     */
    private static Color generateRandomGreen() {
        Random random = new Random();
        // Generate a random green hue: keep green high, red and blue low
        int red = random.nextInt(100);         // 0-99 for red (low)
        int green = 128 + random.nextInt(128); // 128-255 for green (high)
        int blue = random.nextInt(100);        // 0-99 for blue (low)
        return Color.rgb(red, green, blue);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create the BorderPane as root layout
        BorderPane root = new BorderPane();

        // Create the MenuBar
        MenuBar menuBar = new MenuBar();

        // Create the "Options" menu
        Menu optionsMenu = new Menu("Options");

        // Menu Item 1: Show Date and Time
        MenuItem dateTimeItem = new MenuItem("Show Date/Time");
        dateTimeItem.setOnAction(e -> showDateTime());

        // Menu Item 2: Save to log.txt
        MenuItem saveLogItem = new MenuItem("Save to log.txt");
        saveLogItem.setOnAction(e -> saveToLog());

        // Menu Item 3: Change Background to Random Green
        MenuItem changeColorItem = new MenuItem("Change Background to Green");
        changeColorItem.setOnAction(e -> changeBackgroundColor(root));

        // Menu Item 4: Exit
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(e -> Platform.exit());

        // Add all menu items to the Options menu
        optionsMenu.getItems().addAll(dateTimeItem, saveLogItem, changeColorItem, exitItem);

        // Add the Options menu to the MenuBar
        menuBar.getMenus().add(optionsMenu);

        // Create the TextArea for displaying output
        textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setPrefHeight(400);
        textArea.setPrefWidth(500);

        // Set the MenuBar at the top and TextArea in the center
        root.setTop(menuBar);
        root.setCenter(textArea);

        // Create and set the Scene
        Scene scene = new Scene(root, 600, 450);
        primaryStage.setTitle("CSC372 - Module 3: Menu Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Menu Option 1: Displays the current date and time in the text area.
     */
    private void showDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy - hh:mm:ss a");
        String dateTimeString = "Current Date and Time: " + now.format(formatter);
        textArea.appendText(dateTimeString + "\n");
    }

    /**
     * Menu Option 2: Writes the text area contents to "log.txt".
     */
    private void saveToLog() {
        try (FileWriter writer = new FileWriter("log.txt")) {
            writer.write(textArea.getText());
            textArea.appendText("[System] Text area contents saved to log.txt successfully.\n");
        } catch (IOException ex) {
            textArea.appendText("[Error] Could not write to log.txt: " + ex.getMessage() + "\n");
        }
    }

    /**
     * Menu Option 3: Changes the background color to the random green hue.
     * The same green hue is displayed each time this option is selected
     * during a single execution of the program.
     */
    private void changeBackgroundColor(BorderPane root) {
        BackgroundFill backgroundFill = new BackgroundFill(
            randomGreenColor, CornerRadii.EMPTY, Insets.EMPTY
        );
        root.setBackground(new Background(backgroundFill));
        
        // Display the hex color value in the text area
        String hexColor = String.format("#%02X%02X%02X",
            (int)(randomGreenColor.getRed() * 255),
            (int)(randomGreenColor.getGreen() * 255),
            (int)(randomGreenColor.getBlue() * 255));
        textArea.appendText("[System] Background changed to green hue: " + hexColor + "\n");
    }

    /**
     * Main method - launches the JavaFX application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}

