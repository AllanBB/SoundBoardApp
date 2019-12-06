package controllers;

import java.io.File;

import application.Main;
import domainObjects.Playlist;
import javafx.stage.FileChooser;

public class PlaylistEditController {
	public PlaylistEditController() {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Music files", "*.mp3", "*.wav"));
		Main.playlistEdit.save.setOnAction(e -> {
			if (Main.imodel.selectedSound.get(0).getClass().equals(Playlist.class)) {
				updateExistingPlaylist();
			} else {
				createNewPlaylist();
			}
			Main.root.setCenter(Main.m);
			Main.control.save();
		});
		Main.playlistEdit.cancel.setOnAction(e -> {
			Main.root.setCenter(Main.m);
		});
		Main.playlistEdit.openSoundPicker1.setOnAction(e -> {

			File file = fc.showOpenDialog(null);
			if(file!=null) {

			String path = file.getAbsolutePath();
			path = path.replace("\\", "/");
			Main.playlistEdit.path1.setText(path);
			}

		});
		Main.playlistEdit.openSoundPicker2.setOnAction(e -> {

			File file = fc.showOpenDialog(null);
			if(file!=null) {
				String path = file.getAbsolutePath();
				path = path.replace("\\", "/");
				Main.playlistEdit.path2.setText(path);
			}
		});
	}

	/**
	 * 
	 */
	private void createNewPlaylist() {
		Playlist newPlaylist = new Playlist(Main.playlistEdit.name.getText(), Main.playlistEdit.path1.getText(),
				Main.playlistEdit.path2.getText());
		Main.m.catList.getSelectionModel().getSelectedItem().getSoundsProperty()
				.set(Main.m.catList.getSelectionModel().getSelectedItem().getSoundsProperty()
						.indexOf(Main.imodel.selectedSound.get(0)), newPlaylist);
		Main.imodel.selectedSound.set(0, newPlaylist);

		Main.control.updateButtons();
	}

	/**
	 * 
	 */
	private void updateExistingPlaylist() {
		if (!Main.playlistEdit.path1.getText().equals("Select a sound ->")) {
			Main.imodel.selectedSound.get(0).setNameAndPath(Main.playlistEdit.name.getText(),
					Main.playlistEdit.path1.getText(), Main.playlistEdit.path2.getText());
		}
	}

	

}
