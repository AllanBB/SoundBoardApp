package application.Views;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import application.Main;
import domainObjects.Sound;
import javafx.collections.ListChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * The editable view of a sound 
 */
public class SoundEdit extends Pane {

//	Sound sound;
	public TextField name;
	public Label path;	
	public Button save,cancel,openSoundPicker;
	
	public SoundEdit() {
		name = new TextField();
		path =new Label("Select a sound ->");
		save =new Button("Save");
		cancel =new Button("Cancel");
		openSoundPicker =new Button("Pick");//TODO replace with icon
		Main.imodel.selectedSound.addListener(new ListChangeListener<Sound>() {
			
			@Override
			public void onChanged(Change<? extends Sound> c)  {
				initiallizeElements();
			}
			
		});
		initiallizeElements();
		createViewLayout();
		
	}

	private void initiallizeElements() {
		if(Main.imodel.selectedSound.get(0).getClass().equals(Sound.class)) {
		if(Main.imodel.selectedSound.get(0).getPath()==null) {
			path.setText("Select a sound ->");
		}else {
			path.setText(Main.imodel.selectedSound.get(0).getPath());
		}
		name.setText(Main.imodel.selectedSound.get(0).getName());
		}else {
			name.setText("New Sound");
			path.setText("Select a sound ->");
		}
		
	}

	/**
	 * 
	 */
	private void createViewLayout() {
		VBox root= new VBox();
		HBox pathBox= new HBox();
		HBox saveDeleteBox = new HBox();
		saveDeleteBox.setSpacing(5);
		pathBox.getChildren().addAll(path,openSoundPicker);
		saveDeleteBox.getChildren().addAll(save,cancel);
		root.getChildren().addAll(name,pathBox,saveDeleteBox);
		this.getChildren().addAll(root);
	}
	
}
