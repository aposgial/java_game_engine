import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class EventHandler extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create a button
        Button button = new Button("On Click");

        // Create an event handler for the button
        EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Button clicked!");
            }
        };

        // Add the event handler to the button
        button.setOnAction(eventHandler);

        // Create a layout pane and add the button to it
        StackPane root = new StackPane();
        root.getChildren().add(button);

        // Create a scene and set it as the primary stage's scene
        Scene scene = new Scene(root, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Event!");
        primaryStage.show();
    }
}
