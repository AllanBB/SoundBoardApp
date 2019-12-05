package controllers;

import application.Main;
import domainObjects.Category;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * The Applications controller
 */
public class Controller {

	public Controller() {
		setButtonWhenOpen();
		Main.m.soundEditButton.setOnAction(e -> {
			Main.root.setCenter(Main.soundEdit);
		});
		Main.m.playlistEditButton.setOnAction(e -> {
			Main.root.setCenter(Main.playlistEdit);
		});
		Main.m.clipEditButton.setOnAction(e -> {
			Main.root.setCenter(Main.clipEdit);
		});
		Main.m.mixEditButton.setOnAction(e -> {
			Main.root.setCenter(Main.mixEdit);
		});

		Main.m.catList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Category>() {
			@Override
			public void changed(ObservableValue<? extends Category> ov, Category oldVal, Category newVal) {
				Main.imodel.buttonSounds.set(0, newVal.getSound().get(0));
				Main.imodel.buttonSounds.set(1, newVal.getSound().get(1));
				Main.imodel.buttonSounds.set(2, newVal.getSound().get(2));
				Main.imodel.buttonSounds.set(3, newVal.getSound().get(3));
				
				Main.imodel.selectedSound.set(0, newVal.getSound().get(0));
				clearSelected();
				Main.m.s0.getStyleClass().add("Selected");
				
				Main.m.s0.setOnAction(e -> {
					Main.imodel.selectedSound.set(0, newVal.getSound().get(0));
					clearSelected();
					Main.m.s0.getStyleClass().add("Selected");
				});
				Main.m.s1.setOnAction(e -> {
					Main.imodel.selectedSound.set(0, newVal.getSound().get(1));
					clearSelected();
					Main.m.s1.getStyleClass().add("Selected");
				});
				Main.m.s2.setOnAction(e -> {
					Main.imodel.selectedSound.set(0, newVal.getSound().get(2));
					clearSelected();
					Main.m.s2.getStyleClass().add("Selected");
				});
				Main.m.s3.setOnAction(e -> {
					Main.imodel.selectedSound.set(0, newVal.getSound().get(3));
					clearSelected();
					Main.m.s3.getStyleClass().add("Selected");
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
		clearSelected();
		Main.m.s0.getStyleClass().add("Selected");
		Main.m.s0.setOnAction(e -> {
			Main.imodel.selectedSound.set(0, Main.mod.getCategories().get(0).getSound().get(0));
			clearSelected();
			Main.m.s0.getStyleClass().add("Selected");
		});
		Main.m.s1.setOnAction(e -> {
			Main.imodel.selectedSound.set(0, Main.mod.getCategories().get(0).getSound().get(1));
			clearSelected();
			Main.m.s1.getStyleClass().add("Selected");
		});
		Main.m.s2.setOnAction(e -> {
			Main.imodel.selectedSound.set(0, Main.mod.getCategories().get(0).getSound().get(2));
			clearSelected();
			Main.m.s2.getStyleClass().add("Selected");
		});
		Main.m.s3.setOnAction(e -> {
			Main.imodel.selectedSound.set(0, Main.mod.getCategories().get(0).getSound().get(3));
			clearSelected();
			Main.m.s3.getStyleClass().add("Selected");
		});
	}
	
	public void clearSelected() {
		Main.m.s0.getStyleClass().remove("Selected");
		Main.m.s1.getStyleClass().remove("Selected");
		Main.m.s2.getStyleClass().remove("Selected");
		Main.m.s3.getStyleClass().remove("Selected");
	}
	
	/**
	 * update the button. Right after creating a new Sound type the buttons need to be
	 * refreshed with the new value. This is far from the best way to go about it
	 * but time is running out so shortcuts are taken...
	 */
	public void updateButtons() {
		Main.imodel.buttonSounds.set(0,
				Main.m.catList.getSelectionModel().getSelectedItem().getSoundsProperty().get(0));
		Main.imodel.buttonSounds.set(1,
				Main.m.catList.getSelectionModel().getSelectedItem().getSoundsProperty().get(1));
		Main.imodel.buttonSounds.set(2,
				Main.m.catList.getSelectionModel().getSelectedItem().getSoundsProperty().get(2));
		Main.imodel.buttonSounds.set(3,
				Main.m.catList.getSelectionModel().getSelectedItem().getSoundsProperty().get(3));
	}
}
