package domainObjects;

import javafx.beans.property.SimpleListProperty;

/**
 * A playlist of multiple sound
 * Plays sound one after the other
 */
public class Playlist extends Sound {

	public Playlist(String name, String description) {
		super(name, description);
		sounds = new SimpleListProperty<Sound>();
	}

	/**
	 * the list of Sounds to be played in order.
	 */
	SimpleListProperty<Sound> sounds;
	
	public void addSound(Sound sound) {
		sounds.add(sound);
	}
	
	public void removeSound(Sound sound) {
		sounds.remove(sound);
	}
	
	/**
	 * Play the sounds in the playlist
	 */
	public void play() {
		
		for(Sound sound: sounds) {
			sound.play();
		}
		
	}
	
}
