package domainObjects;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Duration;

/**
 * Represent a category of sound
 */
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5346490466078599192L;

	/**
	 * Name of the Category
	 */
	String name;

	/**
	 * List of sounds and playlist within this category.
	 */
	transient SimpleListProperty<Sound> sounds;

	/**
	 * Get the Sound property
	 * 
	 * @return the sound property
	 */
	public SimpleListProperty<Sound> getSoundsProperty() {
		return sounds;
	}

	public ObservableList<Sound> getSound() {
		return sounds.get();
	}

	/**
	 * Add a sound to the category
	 * 
	 * @param sound
	 *            The sound to add
	 */
	public void addSound(Sound x) {
		sounds.add(0, x);
		sounds.remove(sounds.size() - 1);
	}

	/**
	 * Remove a sound from the category
	 * 
	 * @param sound
	 *            The sound to remove
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
		ArrayList<Sound> list = new ArrayList<Sound>();
		ObservableList<Sound> observableList = FXCollections.observableArrayList(list);
		sounds = new SimpleListProperty<Sound>(observableList);
		sounds.add(new Sound("empty"));
		sounds.add(new Sound("empty"));
		sounds.add(new Sound("empty"));
		sounds.add(new Sound("empty"));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;

	}

	public Sound[] getSoundForSerializaton() {
		Sound[] array = new Sound[sounds.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = sounds.get(i);
		}
		return array;
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		for (int i = 0; i < 4; i++) {
			Sound sound = sounds.get(i);
			oos.writeObject(sound.getClass());
			oos.writeObject(sound.getName());
			if (sound.getClass().equals(Playlist.class) || sound.getClass().equals(Mix.class)) {
				oos.writeObject(sound.sound1.getPath());
				oos.writeObject(sound.sound2.getPath());
			} else if (!sound.getName().equals("empty")) {
				oos.writeObject(sound.getPath());

				if (sound.getClass().equals(Clip.class)) {
					oos.writeObject(sound.getStartTime());
					oos.writeObject(sound.getStopTime());
				}
			}
		}
	}

	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		ArrayList<Sound> list = new ArrayList<Sound>();
		ObservableList<Sound> observableList = FXCollections.observableArrayList(list);
		sounds = new SimpleListProperty<Sound>(observableList);
		ois.defaultReadObject();
		for (int i = 0; i < 4; i++) {
			Class<Sound> classString = (Class<Sound>) ois.readObject();
			String name = (String) ois.readObject();
			if (name.equals("empty")) {
				this.sounds.add(new Sound("empty"));
			} else {
				String path = (String) ois.readObject();
				if (classString.equals(Playlist.class) || classString.equals(Mix.class)) {
					String path2 = (String) ois.readObject();
					if (classString.equals(Playlist.class)) {
						this.sounds.add(new Playlist(name, path, path2));
					} else {
						this.sounds.add(new Mix(name, path, path2));
					}
				} else if (classString.equals(Clip.class)) {
					Duration start = (Duration) ois.readObject();
					Duration stop = (Duration) ois.readObject();
					this.sounds.add(new Clip(name, path));
					this.sounds.get(i).setStartTime(start);
					this.sounds.get(i).setStopTime(stop);
				} else {
					this.sounds.add(new Sound(name, path));
				}
			}

		}
		while (sounds.size() < 4) {
			this.sounds.add(sounds.getSize() - 1, new Sound("empty"));
		}
	}
}
