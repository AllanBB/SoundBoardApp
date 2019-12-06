package application;

import java.io.IOException;

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
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
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
	public static Model mod = new Model();
	public static IModel imodel = new IModel();
	public static final MainView m = new MainView();
	public static MenuItem save,exit,editSoundMenuItem,editMixMenuItem,editPlaylistMenuItem,editClipMenuItem,subHelp,subAbout;
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
	public static StackPane splashPane;
	MenuBar menu;
	@Override
	public void start(Stage primaryStage) {
		try {
			
			root = new BorderPane();
			//Create menubar
			
			menu = new MenuBar();
			Menu file = new Menu("File");
			Menu edit = new Menu("Edit");
			Menu help = new Menu("Help");
			
			 exit = new MenuItem("Exit");
			exit.setOnAction(e->{
				primaryStage.close();
			});
			
			
			file.getItems().addAll(save,exit);
			edit.getItems().addAll(editSoundMenuItem,editMixMenuItem,editPlaylistMenuItem,editClipMenuItem);
			help.getItems().addAll(subHelp, subAbout);
			menu.getMenus().addAll(file,edit,help);
			
			displaySplash();
			
			control.load();

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Sound Board Project");
			Image l = new Image(getClass().getResourceAsStream("/application/Views/logo.png"));
			primaryStage.getIcons().add(l);
			primaryStage.sizeToScene();
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	private void displaySplash() {
		 StackPane pane= new StackPane();
		try {
			 pane = FXMLLoader.<StackPane>load(getClass().getResource(("/application/Views/splash.fxml")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
         root.setCenter(pane);;
//         root.setCenter(pane);
         
         FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), pane);
         fadeIn.setFromValue(0);
         fadeIn.setToValue(1);
         fadeIn.setCycleCount(1);

         FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), pane);
         fadeOut.setFromValue(1);
         fadeOut.setToValue(0);
         fadeOut.setCycleCount(1);

         fadeIn.play();

         fadeIn.setOnFinished((e) -> {
             fadeOut.play();
         });

         fadeOut.setOnFinished((e) -> {
        	 root.setTop(menu);
             root.setCenter(m);
         });

     
	}
	
}
