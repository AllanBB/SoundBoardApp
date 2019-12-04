package application;

import java.io.File;

import javafx.stage.FileChooser;

public class SoundEditController {

	public SoundEditController() {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Music files", "*.mp3", "*.wav"));
		Main.soundEdit.save.setOnAction(e -> {
			if (!Main.soundEdit.path.getText().equals("Select a sound ->")) {
				Main.imodel.selectedSound.get(0).setNameAndPath(Main.soundEdit.name.getText(),
						Main.soundEdit.path.getText());
				Main.root.setCenter(Main.m);
			}
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
}
