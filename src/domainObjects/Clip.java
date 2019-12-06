package domainObjects;

import java.io.File;
import java.io.Serializable;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Clip extends Sound implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4372483073320118000L;
	public static String style="-fx-background-color: #eb5ea7; ";
	
	public Clip(String name) {
		super(name);
	}

	public Clip(String name, String path) {
		super(name,path);
	}

	@Override
	public void setNameAndPath(String name, String path, Duration duration, Duration duration2) {
		media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		setStartTime(duration);
		setStopTime(duration2);
		this.name.setValue(name);
		this.path.setValue(path);
	}
	
	@Override
	public void setStartTime(Duration start) {
		this.mediaPlayer.setStartTime(start);
	}
	
	@Override
	public void setStopTime(Duration end) {
		this.mediaPlayer.setStopTime(end);
	}
	
	@Override
	public Duration getStartTime() {
		return this.mediaPlayer.getStartTime();
	}
	
	@Override
	public Duration getStopTime() {
		return this.mediaPlayer.getStopTime();
	}
	
	@Override
	public  String getStyle() {
		return style;
	}
}
