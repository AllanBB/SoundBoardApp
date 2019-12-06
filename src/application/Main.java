package application;

import java.io.IOException;
import javafx.util.Duration;

import application.Views.MainView;
import application.Views.SoundEdit;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	public static Model mod = new Model(buttonRadius);
	public static IModel imodel = new IModel();
	public static final MainView m = new MainView();
	public static Controller control = new Controller();
	public static SoundEdit soundEdit = new SoundEdit();
	//public static SoundEditController soundEditController = new SoundEditController();
	public static BorderPane root;
	public static StackPane pane;
	@Override
	public void start(Stage primaryStage) {
		try {
			
			root = new BorderPane();
			//Create MenuBar
			
			MenuBar menu = new MenuBar();
			
			Menu help = new Menu("Help");

			//Creating a sub-menu to hold about and help information.
			Menu subHelp = new Menu("Help");
			MenuItem helpDets = new MenuItem("This information will help you use my app, you're welcome.");
			subHelp.getItems().add(helpDets);
			
			Menu subAbout = new Menu("About");
			MenuItem logo = new MenuItem("Developers: \nPatrick Godin,\nBrianne Savard,\nAllan Beaton Boutilier");
			Image l = new Image(getClass().getResourceAsStream("./logo.png"));
			logo.setGraphic(new ImageView(l));
			subAbout.getItems().addAll(logo);
			
			help.getItems().addAll(subHelp, subAbout);
			menu.getMenus().add(help); 
			
			displaySplash();
			root.setTop(menu);
			root.setCenter(m);

			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void displaySplash() {
		try {
			//Load Splash view
			pane = FXMLLoader.load(getClass().getResource("splash.fxml"));
			
			//Add to the root container
			//root.getChildren().add(pane);
			
			//Load splash screen with face in effect
			FadeTransition fadeIn = new FadeTransition(Duration.seconds(3),pane);
			fadeIn.setFromValue(0);
			fadeIn.setToValue(1);
			fadeIn.setCycleCount(1);
			
			//End splash animation
			FadeTransition fadeOut = new FadeTransition(Duration.seconds(3),pane);
			fadeOut.setFromValue(1);
			fadeOut.setToValue(0);
			fadeOut.setCycleCount(1);
			
			fadeIn.play();
			root.setCenter(pane);
			
			//After fade begins
			
			fadeIn.setOnFinished((e) -> {
				fadeOut.play();
			});
			
			//After fade out
			fadeOut.setOnFinished((e) -> {
				root.setCenter(m);
			});
		}catch(IOException ex){
			
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
