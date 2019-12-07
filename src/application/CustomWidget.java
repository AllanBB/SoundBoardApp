package application;

import domainObjects.Mix;
import domainObjects.Playlist;
import domainObjects.Sound;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.collections.ListChangeListener;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class CustomWidget extends VBox {
	Label name;
	HBox path1, path2;

	public CustomWidget() {
		this.prefWidth(400);
		this.maxWidth(400);
		name = new Label(Main.imodel.selectedSound.get(0).getName());
		this.setAlignment(Pos.TOP_CENTER);
		path1 = new HBox();
		path2 = new HBox();
		path1.prefWidth(400);
		path1.maxWidth(400);
		this.toBack();
		this.getChildren().addAll(new Separator(), name, path1, path2);
		scrollingText(path1, Main.imodel.selectedSound.get(0).getPath());
		scrollingText(path2, "");
		Main.imodel.selectedSound.addListener(new ListChangeListener<Sound>() {
			@Override
			public void onChanged(Change<? extends Sound> c) {
				Sound selected = Main.imodel.selectedSound.get(0);
				path1.getChildren().clear();
				path2.getChildren().clear();
				name.setText("Selected Sound: " + selected.getName());
				if (selected.getClass().equals(Playlist.class) || selected.getClass().equals(Mix.class)) {
					scrollingText(path1, selected.sound1.getPath());
					scrollingText(path2, selected.sound2.getPath());
				} else {
					scrollingText(path1, selected.getPath());
					scrollingText(path2, "");
				}
			}
		});
	}

	/**
	 * This code was taken from http://blog.yabysoft.com/?p=4
	 * 
	 * I wanted this behavior and it offered exactly what I wanted with a few Minor
	 * Tweaks. I do NOT claim ownership this method
	 * 
	 * @param parent
	 * @param text
	 */
	public void scrollingText(HBox parent, String text) {
		Text scrollingText = new Text(text);
		parent.getChildren().add(scrollingText);
		scrollingText.setLayoutX(parent.getLayoutX());
		scrollingText.setLayoutY(parent.getLayoutY());
		TranslateTransition tt = new TranslateTransition(Duration.millis(20000), scrollingText);
		tt.setFromX(0 - 10); // setFromX sets the starting position, coming from the
																	// left and going to the right.
		 int boundWidth = (int) parent.getBoundsInParent().getWidth();
		tt.setToX(scrollingText.getWrappingWidth() + boundWidth); // setToX sets to target position, go beyond the right
															// side of the screen.
		tt.setCycleCount(Timeline.INDEFINITE); // repeats for ever
		tt.setAutoReverse(false); // Always start over
		tt.play();
	}
}
