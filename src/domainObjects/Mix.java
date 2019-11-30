package domainObjects;

import javafx.util.Duration;

/**
 * A mixture of 2 sound
 *  Allows for 2 sounds to be played at the same time.
 */
public class Mix extends Sound {

	/**
	 * Note we haven't talk about this one yet so this stub class is merely a proposal 
	 * We can rework scrap
	 */
	
	public Mix(String name, String description) {
		super(name, description);
	}
	Sound sound1;
	Sound sound2;
	double  startOfSound1,startOfSound2,endOfSound1,endOfSound2;
	long startofSound2relativeto1;
	
	public void play() {
		sound1.mediaPlayer.setStartTime(new Duration(startOfSound1));
		sound1.mediaPlayer.setStopTime(new Duration(endOfSound1));
		
		sound2.mediaPlayer.setStartTime(new Duration(startOfSound2));
		sound2.mediaPlayer.setStopTime(new Duration(endOfSound2));
		
		sound1.mediaPlayer.play();
		
		//TODO find a better way to wait. This is mainly to show to idea and it unlikely to work unless asynchronous
		try {
			wait(startofSound2relativeto1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sound2.mediaPlayer.play();
		
		
	}
	
	
	
}
