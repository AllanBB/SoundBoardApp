package application.Views;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import application.Main;
import domainObjects.Mix;
import domainObjects.Sound;
import javafx.collections.ListChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * The editable view of a mix.
 * Allows for 2 sounds to be played at the same time.
 */
public class MixEdit extends Pane {

	public TextField name;
	public Label path1, path2;
	public Button save, cancel, openSoundPicker1, openSoundPicker2;

	public MixEdit() {
		name = new TextField();
		path1 = new Label("Select first sound ->");
		path2 = new Label("Select first sound ->");
		save = new Button("Save");
		cancel = new Button("Cancel");
		openSoundPicker1 = new Button("Pick");// TODO replace with icon
		openSoundPicker2 = new Button("Pick");// TODO replace with icon
		Main.imodel.selectedSound.addListener(new ListChangeListener<Sound>() {

			@Override
			public void onChanged(Change<? extends Sound> c) {
				initiallizeElements();
			}

		});
		initiallizeElements();
		createViewLayout();

	}

	private void initiallizeElements() {
		if (Main.imodel.selectedSound.get(0).getClass().equals(Mix.class)) {
			Sound grrr=Main.imodel.selectedSound.get(0);
			grrr.getName();
			if (Main.imodel.selectedSound.get(0).sound1.getPath() == null) {
				path1.setText("Select a sound ->");
			} else {
				path1.setText(Main.imodel.selectedSound.get(0).sound1.getPath());
			}
			if (Main.imodel.selectedSound.get(0).sound2.getPath() == null) {
				path2.setText("Select a sound ->");
			} else {
				path2.setText(Main.imodel.selectedSound.get(0).sound2.getPath());
			}
			name.setText(Main.imodel.selectedSound.get(0).getName());
		} else {
			name.setText("New Mix");
			path1.setText("Select a sound ->");
			path2.setText("Select a sound ->");

		}

	}

	/**
	 * 
	 */
	private void createViewLayout() {
		VBox root = new VBox();
		HBox path1Box = new HBox();
		HBox path2Box = new HBox();
		HBox saveDeleteBox = new HBox();
		saveDeleteBox.setSpacing(5);
		path1Box.getChildren().addAll(path1, openSoundPicker1);
		path2Box.getChildren().addAll(path2, openSoundPicker2);
		saveDeleteBox.getChildren().addAll(save, cancel);
		root.getChildren().addAll(name, path1Box, path2Box, saveDeleteBox);
		this.getChildren().addAll(root);
	}
	
}
