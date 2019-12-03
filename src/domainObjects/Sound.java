package domainObjects;

import java.io.File;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

/**
 * A class representing a sound
 */
public class Sound {

	/**
	 * The name given to the Sound
	 */
	SimpleStringProperty name;

	/**
	 * The system path to the sound
	 */
	SimpleStringProperty path;// = "src/SampleSounds/birds2.wav";

	/**
	 * The description of the file
	 */
	String description;

	Media media;// = new Media(new File(path.getValue()).toURI().toString());
	MediaPlayer mediaPlayer;// = new MediaPlayer(media);

	public Sound(String name) {
		this.name = new SimpleStringProperty();
		this.path = new SimpleStringProperty();
		this.name.setValue(name);
	}

	public Sound(String name, String path) {
		this.name = new SimpleStringProperty();
		this.path = new SimpleStringProperty();
		this.name.setValue(name);
		this.path.setValue(path);
		media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
	}

	public String getName() {
		return name.getValue();
	}

	public String getPath() {
		return path.getValue();
	}

	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.name.setValue(name);
	}

	public void setPath(String path) {
		this.path.setValue(path);
		media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
	}

	public void setNameAndPath(String name, String path) {
		this.name.setValue(name);
		this.path.setValue(path);
		media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void play() {
		if (mediaPlayer!=null && mediaPlayer.statusProperty().get().equals(MediaPlayer.Status.PLAYING)) {
			mediaPlayer.stop();
		} else {
			if (path.get()!=null &&!path.get().equals("Select a sound ->")) {
				MediaView mediaView = new MediaView();
				mediaView.setMediaPlayer(mediaPlayer);
				mediaPlayer.seek(new Duration(0.0));
				mediaPlayer.play();
			}
		}
	}

	public SimpleStringProperty getNameProperty() {
		return name;
	}

	public SimpleStringProperty getPathProperty() {
		return path;
	}

}
