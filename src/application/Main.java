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
import javafx.scene.layout.VBox;
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
			Menu file = new Menu("File");
			Menu edit = new Menu("Edit");
			Menu help = new Menu("Help");
			
			MenuItem save= new MenuItem("Save");
			save.setOnAction(e->{
				control.save();
			});
			MenuItem exit = new MenuItem("Exit");
			exit.setOnAction(e->{
				primaryStage.close();
			});
			
			MenuItem editSoundMenuItem = new MenuItem("Edit Sound");
			editSoundMenuItem.setOnAction(e->{
				root.setCenter(soundEdit);
			});
			MenuItem editMixMenuItem = new MenuItem("Edit Mix");
			editMixMenuItem.setOnAction(e->{
				root.setCenter(mixEdit);
			});
			MenuItem editPlaylistMenuItem = new MenuItem("Edit Playlist");
			editPlaylistMenuItem.setOnAction(e->{
				root.setCenter(playlistEdit);
			});
			MenuItem editClipMenuItem = new MenuItem("Edit Clip");
			editClipMenuItem.setOnAction(e->{
				root.setCenter(clipEdit);
			});
			
			//Creating a sub-menu to hold about and help information.
			MenuItem subHelp = new MenuItem("Help");
			subHelp.setOnAction(e->{
				try {
					root.setCenter(FXMLLoader.<VBox>load(getClass().getResource("Help.fxml")));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});

			MenuItem subAbout = new MenuItem("About");
			Image l = new Image(getClass().getResourceAsStream("./logo.png"));
			subAbout.setOnAction(e->{
				try {
					root.setCenter(FXMLLoader.<VBox>load(getClass().getResource("About.fxml")));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
			
			file.getItems().addAll(save,exit);
			edit.getItems().addAll(editSoundMenuItem,editMixMenuItem,editPlaylistMenuItem,editClipMenuItem);
			help.getItems().addAll(subHelp, subAbout);
			menu.getMenus().addAll(file,edit,help);
			
			root.setTop(menu);
			
			root.setCenter(m);
			
			control.load();

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Sound Board Project");
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
}
