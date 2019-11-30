package domainObjects;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;

/**
 * Represent a category of sound
 */
public class Category {

	/**
	 * Name of the Category
	 */
	String name;	
	
	/**
	 * List of sounds and playlist within this category.
	 */
	SimpleListProperty<Sound> sounds;
	
	/**
	 * Get the Sound property
	 * @return the sound property
	 */
	public SimpleListProperty<Sound> getSoundsProperty() {
		return sounds;
	}
	
	public ObservableList<Sound> getSound(){
		return sounds.get();
	}
	
	/**
	 * Add a sound to the category
	 * @param sound The sound to add
	 */
	public void addSound(Sound sound) {
		sounds.add(sound);
	}
	
	/**
	 * Remove a sound from the category
	 * @param sound The sound to remove
	 */
	public void removeSound(Sound sound) {
		sounds.remove(sound);
	}

	/**
	 * @param name
	 * @param sounds
	 */
	public Category(String name) {
		super();
		this.name = name;
		sounds = new SimpleListProperty<Sound>();
	}
	
	
}
