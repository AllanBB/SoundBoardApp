package domainObjects;

import java.io.File;

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
	String name;

	/**
	 * The system path to the sound
	 */
	String path = "src/SampleSounds/birds2.wav";

	/**
	 * The description of the file
	 */
	String description;

	 Media media = new Media(new File(path).toURI().toString());
	 MediaPlayer mediaPlayer = new MediaPlayer(media);

	public Sound(String name, String path) {
		this.name = name;
		this.path = path;
		media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPath(String path) {
		this.path = path;
		media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void play() {

		MediaView mediaView = new MediaView();
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.seek(new Duration(0.0));
		mediaPlayer.play();
	}

}
