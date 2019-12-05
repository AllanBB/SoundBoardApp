package application;

import application.Views.ClipEdit;
import application.Views.MainView;
import application.Views.MixEdit;
import application.Views.PlaylistEdit;
import application.Views.SoundEdit;
import controllers.ClipEditController;
import controllers.Controller;
import controllers.MixEditController;
import controllers.PlaylistEditController;
import controllers.SoundEditController;
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
	public static IModel imodel = new IModel();
	public static final MainView m = new MainView();
	public static Controller control = new Controller();
	public static SoundEdit soundEdit = new SoundEdit();
	public static SoundEditController soundEditController = new SoundEditController();
	public static PlaylistEdit playlistEdit = new PlaylistEdit();
	public static PlaylistEditController playlistEdiController = new PlaylistEditController();
	public static MixEdit mixEdit = new MixEdit();
	public static MixEditController mixEditController = new MixEditController();
	public static ClipEdit clipEdit = new ClipEdit();
	public static ClipEditController clipEditController = new ClipEditController();
	public static BorderPane root;
	@Override
	public void start(Stage primaryStage) {
		try {
			
			root = new BorderPane();
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
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Sound Board Project");
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
