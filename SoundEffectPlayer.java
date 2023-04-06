import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class SoundPlayer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create a new File object with the path to the MP3 file
        File mp3File = new File("path");

        // Create a Media object with the file URI
        Media media = new Media(mp3File.toURI().toString());

        // Create a MediaPlayer object with the Media object
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        // Play the media
        mediaPlayer.play();

        // Stop the media after 5 seconds
        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.stop();
            System.out.println("Media playback completed.");
        });

        // Show the media player window
        primaryStage.setTitle("Effect Player");
        primaryStage.show();
    }
}
