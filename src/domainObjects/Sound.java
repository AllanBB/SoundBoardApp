package domainObjects;

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
	String path = "/home1/ugrads/bsavard1/Downloads/cat.mp3";

	/**
	 * The description of the file
	 */
	String description;

//	 Media media = new Media(new File(path).toURI().toString());
//	 MediaPlayer mediaPlayer = new MediaPlayer(media);

	public Sound(String name, String description) {
		this.name = name;
		this.description = description;
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

//	public void setPath(String path) {
//		this.path = path;
//		media = new Media(new File(path).toURI().toString());
//		mediaPlayer = new MediaPlayer(media);
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public void play() {
//
//		MediaView mediaView = new MediaView();
//		mediaView.setMediaPlayer(mediaPlayer);
//		mediaPlayer.play();
//	}

}
