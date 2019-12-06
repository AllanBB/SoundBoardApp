package controllers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import application.Main;
import application.Model;
import domainObjects.Category;
import domainObjects.Sound;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;

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
				Category temp=newVal;
				ObservableList<Sound> temp2=Main.imodel.buttonSounds;
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
	 * update the button. Right after creating a new Sound type the buttons need to
	 * be refreshed with the new value. This is far from the best way to go about it
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

	public void save() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("src/model.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(Main.mod.getCategoriesForSeriliazation());
			for(Category cat:Main.mod.getCategories()) {
				objectOutputStream.writeObject(cat);
			}
			objectOutputStream.flush();
			objectOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load() {
		try {
			FileInputStream fileInputStream = new FileInputStream("src/model.txt");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			ArrayList<Category> list= new ArrayList<Category>();
//			while(objectInputStream.available()>0) {
//				list.add((Category) objectInputStream.readObject());
//			}
			list=(ArrayList<Category>) objectInputStream.readObject();
			for(Category cat:list) {
				if(cat.getSound().size()<4) {
					cat.getSound().add(new Sound("empty"));
				}
			}
			Main.mod.setCategoriesForSeriliazation(list);
			objectInputStream.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
