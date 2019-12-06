package domainObjects;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

/**
 * A class representing a sound
 */
public class Sound implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6109640774359327224L;

	/**
	 * The name given to the Sound
	 */
	SimpleStringProperty name;

	/**
	 * The system path to the sound
	 */
	SimpleStringProperty path;// = "src/SampleSounds/birds2.wav";

	
	public static String style="-fx-background-color: yellow;";

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
	
	


	public void play() {
		if (mediaPlayer != null && mediaPlayer.statusProperty().get().equals(MediaPlayer.Status.PLAYING)) {
			mediaPlayer.stop();
		} else {
			if (path.get() != null && !path.get().equals("Select a sound ->")) {
				MediaView mediaView = new MediaView();
				mediaView.setMediaPlayer(mediaPlayer);
				mediaPlayer.seek(new Duration(0.0));
				mediaPlayer.play();
				mediaPlayer.setOnEndOfMedia(() -> {
					mediaPlayer.stop();
				});
			}
		}

	}

	public String getStyle() {
		return style;
	}

	public SimpleStringProperty getNameProperty() {
		return name;
	}

	public SimpleStringProperty getPathProperty() {
		return path;
	}
	
	
	
	

	/**
	 * ABSTRACT METHOD, classes extending this one need this method signature. An
	 * interface should have been used but this is a quick, time is short work
	 * around
	 */
	public void setNameAndPath(String text, String text2, String text3) {
		/*
		 *  ABSTRACT METHOD, classes extending this one need this method signature. An
	 * interface should have been used but this is a quick, time is short work
	 * around
		 */
	};
	
	public Sound sound1;
	public Sound sound2;

	/**
	 * ABSTRACT METHOD, classes extending this one need this method signature. An
	 * interface should have been used but this is a quick, time is short work
	 * around
	 */
	public void setStartTime(Duration minutes) {
		/*
		 *  ABSTRACT METHOD, classes extending this one need this method signature. An
	 * interface should have been used but this is a quick, time is short work
	 * around
		 */
	}

	/**
	 * ABSTRACT METHOD, classes extending this one need this method signature. An
	 * interface should have been used but this is a quick, time is short work
	 * around
	 */
	public Duration getStartTime() {
		/*
		 *  ABSTRACT METHOD, classes extending this one need this method signature. An
	 * interface should have been used but this is a quick, time is short work
	 * around
		 */
		return null;
	}
	/**
	 * ABSTRACT METHOD, classes extending this one need this method signature. An
	 * interface should have been used but this is a quick, time is short work
	 * around
	 */
	public Duration getStopTime() {
		/*
		 *  ABSTRACT METHOD, classes extending this one need this method signature. An
	 * interface should have been used but this is a quick, time is short work
	 * around
		 */
		return null;
	}

	/**
	 * ABSTRACT METHOD, classes extending this one need this method signature. An
	 * interface should have been used but this is a quick, time is short work
	 * around
	 */
	public void setStopTime(Duration minutes) {
		/*
		 *  ABSTRACT METHOD, classes extending this one need this method signature. An
	 * interface should have been used but this is a quick, time is short work
	 * around
		 */
		
	}
	/**
	 * ABSTRACT METHOD, classes extending this one need this method signature. An
	 * interface should have been used but this is a quick, time is short work
	 * around
	 */
	public void setNameAndPath(String name, String path, Duration duration, Duration duration2) {
		this.name.setValue(name);
		this.path.setValue(path);
		media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
	}

}
