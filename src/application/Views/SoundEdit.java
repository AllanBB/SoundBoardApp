package application.Views;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import domainObjects.Sound;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * The editable view of a sound 
 */
public class SoundEdit extends Pane {

	Sound sound;
	TextField name,description;
	Label path;	
	Button save,delete,openSoundPicker;
	
	public SoundEdit() {
		createViewLayout();
		initiallizeElements();
	}

	private void initiallizeElements() {
		name = new TextField(sound.getName());
		description= new TextField(sound.getDescription());
		path =new Label(sound.getDescription());
		save =new Button("Save");
		delete =new Button("Delete");
		openSoundPicker =new Button();//find a folder icon
		
	}

	/**
	 * 
	 */
	private void createViewLayout() {
		VBox root= new VBox();
		HBox pathBox= new HBox();
		HBox saveDeleteBox = new HBox();
		pathBox.getChildren().addAll(path,openSoundPicker);
		saveDeleteBox.getChildren().addAll(save,delete);
		root.getChildren().addAll(name,pathBox,description,saveDeleteBox);
		this.getChildren().add(root);
	}
	
}
