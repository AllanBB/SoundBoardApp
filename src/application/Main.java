package application;

import application.Views.MainView;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Proof of concept
 * Modified from: https://blog.idrsolutions.com/2015/04/javafx-mp3-music-player-embedding-sound-in-your-application/
 * @author Patrick Godin
 */

public class Main extends Application {
	public static Media media= null;
	public static MediaPlayer mediaPlayer;
	public static int buttonRadius = 20;
	public static Model mod = new Model(buttonRadius);
	public static final MainView m = new MainView();
	public static IModel imodel = new IModel();
	public static Controller control = new Controller();

	@Override
	public void start(Stage primaryStage) {
		try {
			
			BorderPane root = new BorderPane();
			//Create menubar
			
			MenuBar menu = new MenuBar();
			
			Menu help = new Menu("Help");
			
			MenuItem about = new MenuItem("About");
			MenuItem helpInfo = new MenuItem("Help");
			
			help.getItems().addAll(about, helpInfo);
			menu.getMenus().add(help);
			
			root.setTop(menu);
			
			root.setCenter(m);
			
			/*
			
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
			*/

			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
