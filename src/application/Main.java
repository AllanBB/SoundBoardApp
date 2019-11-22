package application;

import java.io.File;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 * Proof of concept
 * Modified from: https://blog.idrsolutions.com/2015/04/javafx-mp3-music-player-embedding-sound-in-your-application/
 * @author Patrick Godin
 */

public class Main extends Application {
	Media media= null;
	MediaPlayer mediaPlayer;

	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox();
			FileChooser fc = new FileChooser();
			fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Music files","*.mp3","*.wav"));
			MediaView mediaView = new MediaView();;
			mediaView.setMediaPlayer(mediaPlayer);

			Button fetch = new Button("Pick a sound file");
			Button play = new Button("Play");
			Button stop = new Button("Stop");

			fetch.setOnMouseClicked(e->{
				File file = fc.showOpenDialog(null);

				//We could skip this step and use "file" directly ie "media = new Media(file.toURI().toString());
				//However, this goes to show how we can get and use the path of the sound file
				//Since path is just a string it would be easy to store in a database or something else
				String path = file.getAbsolutePath();
				path = path.replace("\\", "/");

				media = new Media(new File(path).toURI().toString());
				mediaPlayer = new MediaPlayer(media);
				mediaView.setMediaPlayer(mediaPlayer);
				play.disableProperty().set(false);
				stop.disableProperty().set(false);
			});

			play.disableProperty().set(true);
			play.setOnMouseClicked(e->{
				mediaPlayer.play();
			});

			stop.disableProperty().set(true);
			stop.setOnMouseClicked(e->{
				mediaPlayer.stop();
				mediaPlayer.seek(mediaPlayer.getStartTime());
			});

			root.getChildren().addAll(fetch,play,stop);

			Scene scene = new Scene(root,400,400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
