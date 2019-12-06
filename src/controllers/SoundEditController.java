package controllers;

import java.io.File;

import application.Main;
import domainObjects.Playlist;
import domainObjects.Sound;
import javafx.stage.FileChooser;

public class SoundEditController {

	public SoundEditController() {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Music files", "*.mp3", "*.wav"));
		Main.soundEdit.save.setOnAction(e -> {
			if (Main.imodel.selectedSound.get(0).getClass().equals(Sound.class)) {
				if (!Main.soundEdit.path.getText().equals("Select a sound ->")) {
					Main.imodel.selectedSound.get(0).setNameAndPath(Main.soundEdit.name.getText(),
							Main.soundEdit.path.getText());
				}
			} else {
				createNewSound();
			}
			Main.root.setCenter(Main.m);
			Main.control.save();
		});
		Main.soundEdit.cancel.setOnAction(e -> {
			Main.root.setCenter(Main.m);
		});
		Main.soundEdit.openSoundPicker.setOnAction(e -> {

			File file = fc.showOpenDialog(null);

			String path = file.getAbsolutePath();
			path = path.replace("\\", "/");
			Main.soundEdit.path.setText(path);

			if (Main.imodel.selectedSound.get(0).getName().equals("empty")) {
				String temp = path.substring(path.lastIndexOf("/") + 1);
				Main.soundEdit.name.setText(temp);
			}
		});
	}
	
	private void createNewSound() {
		Sound newSound = new Sound(Main.soundEdit.name.getText(), Main.soundEdit.path.getText());
		Main.m.catList.getSelectionModel().getSelectedItem().getSoundsProperty()
				.set(Main.m.catList.getSelectionModel().getSelectedItem().getSoundsProperty()
						.indexOf(Main.imodel.selectedSound.get(0)), newSound);
		Main.imodel.selectedSound.set(0, newSound);

		Main.control.updateButtons();
	}
}
