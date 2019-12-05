package controllers;

import java.io.File;

import application.Main;
import domainObjects.Mix;
import domainObjects.Playlist;
import javafx.stage.FileChooser;

public class MixEditController {
	public MixEditController() {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Music files", "*.mp3", "*.wav"));
		Main.mixEdit.save.setOnAction(e -> {
			if (Main.imodel.selectedSound.get(0).getClass().equals(Playlist.class)) {
				updateExistingMix();
			} else {
				createNewMix();
			}
			Main.root.setCenter(Main.m);

		});
		Main.mixEdit.cancel.setOnAction(e -> {
			Main.root.setCenter(Main.m);
		});
		Main.mixEdit.openSoundPicker1.setOnAction(e -> {

			File file = fc.showOpenDialog(null);

			String path = file.getAbsolutePath();
			path = path.replace("\\", "/");
			Main.mixEdit.path1.setText(path);

		});
		Main.mixEdit.openSoundPicker2.setOnAction(e -> {

			File file = fc.showOpenDialog(null);

			String path = file.getAbsolutePath();
			path = path.replace("\\", "/");
			Main.mixEdit.path2.setText(path);

		});
	}

	/**
	 * 
	 */
	private void createNewMix() {
		Mix newMix = new Mix(Main.mixEdit.name.getText(), Main.mixEdit.path1.getText(),
				Main.mixEdit.path2.getText());
		Main.m.catList.getSelectionModel().getSelectedItem().getSoundsProperty()
				.set(Main.m.catList.getSelectionModel().getSelectedItem().getSoundsProperty()
						.indexOf(Main.imodel.selectedSound.get(0)), newMix);
		Main.imodel.selectedSound.set(0, newMix);

		Main.control.updateButtons();
	}

	/**
	 * 
	 */
	private void updateExistingMix() {
		if (!Main.mixEdit.path1.getText().equals("Select a sound ->")) {
			Main.imodel.selectedSound.get(0).setNameAndPath(Main.mixEdit.name.getText(),
					Main.mixEdit.path1.getText(), Main.mixEdit.path2.getText());
		}
	}
}
