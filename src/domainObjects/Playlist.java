package domainObjects;

import java.io.Serializable;

/**
 * A playlist of multiple sound Plays sound one after the other
 */
public class Playlist extends Sound implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4557556140883454550L;
	public static String style = "-fx-background-color: #78eb5e; ";
	
	public Playlist(String name) {
		super(name);
	}
	public Playlist(String name,String path1,String path2) {
		super(name);
		this.sound1 = new Sound("filler",path1);
		this.sound2 =new Sound("filler",path2);
	}


	@Override
	public void play() {

		sound1.play();
		sound1.mediaPlayer.setOnEndOfMedia(() -> {
			sound2.play();
		});

	}
	
	@Override
	public  String getStyle() {
		return style;
	}
	@Override
	public void setNameAndPath(String name, String path1, String path2) {
		this.name.set(name);
		this.sound1.setPath(path1);
		this.sound2.setPath(path2);
		
	}
}
