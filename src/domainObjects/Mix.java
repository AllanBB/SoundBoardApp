package domainObjects;

import java.io.Serializable;

import javafx.util.Duration;

/**
 * A mixture of 2 sound Allows for 2 sounds to be played at the same time.
 */
public class Mix extends Sound implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1979948314782879349L;
	public static String style="-fx-background-color: #eb752d; ";
	public Mix(String name) {
		super(name);
	}
	public Mix(String name,String path1,String path2) {
		super(name);
		this.sound1 = new Sound("filler",path1);
		this.sound2 =new Sound("filler",path2);
	}

	public void play() {

		sound1.play();

		sound2.play();

	}
	
	public  String getStyle() {
		return style;
	}

}
