package application;

import domainObjects.Category;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * The Applications controller
 */
public class Controller {

	public Controller() {
		setButtonWhenOpen();
		Main.m.edit.setOnAction(e -> {
			e.consume();
			Main.root.setCenter(Main.soundEdit);
		});

		Main.m.catList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Category>() {
			@Override
			public void changed(ObservableValue<? extends Category> ov, Category oldVal, Category newVal) {

				Main.imodel.buttonSounds.set(0, newVal.getSound().get(0));
				Main.m.s0.setOnAction(e -> {
					Main.imodel.selectedSound.set(0, newVal.getSound().get(0));
				});
				Main.imodel.buttonSounds.set(1, newVal.getSound().get(1));
				Main.m.s1.setOnAction(e -> {
					Main.imodel.selectedSound.set(0, newVal.getSound().get(1));
				});
				Main.imodel.buttonSounds.set(2, newVal.getSound().get(2));
				Main.m.s2.setOnAction(e -> {
					Main.imodel.selectedSound.set(0, newVal.getSound().get(2));
				});
				Main.imodel.buttonSounds.set(3, newVal.getSound().get(3));
				Main.m.s3.setOnAction(e -> {
					Main.imodel.selectedSound.set(0, newVal.getSound().get(3));
				});
			}
		});

		Main.m.playPause.setOnAction(e -> {
			if (Main.imodel.selectedSound.get(0) != null) {
				Main.imodel.selectedSound.get(0).play();
			} else {
				System.out.println("no sound");
			}
		});

		Main.m.createCat.setOnAction(e -> {
			Main.mod.getCategoriesProperty().add(new Category("New Category"));
		});

	}

	/**
	 * This will set the button when you first open the app before you pick a
	 * category
	 */
	private void setButtonWhenOpen() {
		Main.m.s0.setOnAction(e -> {
			Main.imodel.selectedSound.set(0, Main.mod.getCategories().get(0).getSound().get(0));
		});
		Main.m.s1.setOnAction(e -> {
			Main.imodel.selectedSound.set(0, Main.mod.getCategories().get(0).getSound().get(1));
		});
		Main.m.s2.setOnAction(e -> {
			Main.imodel.selectedSound.set(0, Main.mod.getCategories().get(0).getSound().get(2));
		});
		Main.m.s3.setOnAction(e -> {
			Main.imodel.selectedSound.set(0, Main.mod.getCategories().get(0).getSound().get(3));
		});
	}
}
