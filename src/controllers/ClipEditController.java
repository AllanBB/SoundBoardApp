package controllers;

import java.io.File;

import application.Main;
import domainObjects.Clip;
import domainObjects.Sound;
import javafx.stage.FileChooser;
import javafx.util.Duration;

public class ClipEditController {

	public ClipEditController() {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Music files", "*.mp3", "*.wav"));
		Main.clipEdit.save.setOnAction(e -> {
			if (Main.imodel.selectedSound.get(0).getClass().equals(Clip.class)) {
				updateExistingClip();
			} else {
				createNewClip();
			}
			Main.root.setCenter(Main.m);
			Main.control.save();
		});
		Main.clipEdit.cancel.setOnAction(e -> {
			Main.root.setCenter(Main.m);
		});
		Main.clipEdit.openSoundPicker.setOnAction(e -> {

			File file = fc.showOpenDialog(null);

			String path = file.getAbsolutePath();
			path = path.replace("\\", "/");
			Main.clipEdit.path.setText(path);

			if (Main.imodel.selectedSound.get(0).getName().equals("empty")) {
				String temp = path.substring(path.lastIndexOf("/") + 1);
				Main.clipEdit.name.setText(temp);
			}
		});
	}

	/**
	 * 
	 */
	private void updateExistingClip() {
		if (!Main.clipEdit.path.getText().equals("Select a sound ->")) {
			Main.imodel.selectedSound.get(0).setNameAndPath(Main.clipEdit.name.getText(),
					Main.clipEdit.path.getText(),Duration.seconds(Double.parseDouble(Main.clipEdit.startSec.getText())),Duration.seconds(Double.parseDouble(Main.clipEdit.endSec.getText())));
		}
	}
	
	private void createNewClip() {
		Clip newClip = new Clip(Main.clipEdit.name.getText(), Main.clipEdit.path.getText());
		newClip.setStartTime(Duration.seconds(Double.parseDouble(Main.clipEdit.startSec.getText())));
		newClip.setStopTime(Duration.seconds(Double.parseDouble(Main.clipEdit.endSec.getText())));
		
		Main.m.catList.getSelectionModel().getSelectedItem().getSoundsProperty()
				.set(Main.m.catList.getSelectionModel().getSelectedItem().getSoundsProperty()
						.indexOf(Main.imodel.selectedSound.get(0)), newClip);
		Main.imodel.selectedSound.set(0, newClip);

		Main.control.updateButtons();
	}
}
