package application.Views;

import application.Main;
import domainObjects.Clip;
import domainObjects.Mix;
import domainObjects.Sound;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ClipEdit extends Pane {

	public TextField name, startSec, endSec;
	public Label path;
	public Button save, cancel, openSoundPicker;

	public ClipEdit() {
		name = new TextField();
		startSec = new TextField();
		endSec = new TextField();
		path = new Label("Select a sound ->");
		save = new Button("Save");
		cancel = new Button("Cancel");
		openSoundPicker = new Button("Pick");// TODO replace with icon

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
		if (Main.imodel.selectedSound.get(0).getClass().equals(Clip.class)) {
			if (Main.imodel.selectedSound.get(0).getPath() == null) {
				path.setText("Select a sound ->");
			} else {
				path.setText(Main.imodel.selectedSound.get(0).getPath());
			}
			name.setText(Main.imodel.selectedSound.get(0).getName());
			startSec.setText("" + Main.imodel.selectedSound.get(0).getStartTime().toSeconds());
			endSec.setText("" + Main.imodel.selectedSound.get(0).getStopTime().toSeconds());
		}else {
			name.setText("New Mix");
			path.setText("Select a sound ->");
			startSec.setText("");
			endSec.setText("");
		}

	}

	/**
	 * 
	 */
	private void createViewLayout() {
		VBox root = new VBox();
		HBox pathBox = new HBox();
		HBox saveDeleteBox = new HBox();
		saveDeleteBox.setSpacing(5);
		pathBox.getChildren().addAll(path, openSoundPicker);
		saveDeleteBox.getChildren().addAll(save, cancel);

		VBox startVBox = new VBox();
		HBox startHbox = new HBox();
		startHbox.getChildren().addAll(new Label("Sec:"), startSec);
		startVBox.getChildren().addAll(new Label("Start"), startHbox);
		startVBox.setSpacing(5);

		VBox endVBox = new VBox();
		HBox endHbox = new HBox();
		endHbox.getChildren().addAll( new Label("Sec:"), endSec);
		endVBox.getChildren().addAll(new Label("End"), endHbox);
		endVBox.setSpacing(5);

		root.getChildren().addAll(name, pathBox, startVBox, endVBox, saveDeleteBox);
		this.getChildren().addAll(root);
	}
}
