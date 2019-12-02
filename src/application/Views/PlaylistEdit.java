package application.Views;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import domainObjects.Sound;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * The editable view of a Playlist 
 * Plays sound one after the other
 */
public class PlaylistEdit extends Pane {

	Sound sound;
	TextField name,description;
	ListView<Sound> listOfSound;
	Button save,delete,openSoundPicker;
	
	public PlaylistEdit() {
		createViewLayout();
		initiallizeElements();
	}

	private void initiallizeElements() {
		name = new TextField(sound.getName());
		description= new TextField(sound.getDescription());
		save =new Button("Save");
		delete =new Button("Delete");
		openSoundPicker =new Button();//find a folder icon
		
	}

	/**
	 * 
	 */
	private void createViewLayout() {
		VBox root= new VBox();
		HBox saveDeleteBox = new HBox();
		//TODO display an editable list of sound
		saveDeleteBox.getChildren().addAll(save,delete);
		root.getChildren().addAll(name,description,saveDeleteBox);
		this.getChildren().add(root);
	}
	
}
