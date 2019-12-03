package application;

import domainObjects.Category;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * The Applications controller
 */
public class Controller {

	public Controller() {
		Main.m.catList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Category>() {
			@Override
			public void changed(ObservableValue<? extends Category> ov, Category oldVal, Category newVal) {
				System.out.println("Selected");

				if(newVal.getSound().size()>=1&&newVal.getSound().get(0)!=null) {
				Main.m.s0.setText(newVal.getSound().get(0).getName());
				Main.m.s0.setOnAction(e -> {
					Main.imodel.selectedSound = newVal.getSound().get(0);
				});
				} else {
					Main.m.s0.setText("No sound set");
				}
				if(newVal.getSound().size()>1&&newVal.getSound().get(1)!=null) {
					Main.m.s1.setText(newVal.getSound().get(1).getName());
					Main.m.s1.setOnAction(e -> {
						Main.imodel.selectedSound = newVal.getSound().get(1);
					});
					} else {
						Main.m.s1.setText("No sound set");
					}
				if(newVal.getSound().size()>2&&newVal.getSound().get(2)!=null) {
					Main.m.s2.setText(newVal.getSound().get(2).getName());
					Main.m.s2.setOnAction(e -> {
						Main.imodel.selectedSound = newVal.getSound().get(2);
					});
					} else {
						Main.m.s2.setText("No sound set");
					}
				if(newVal.getSound().size()>3&&newVal.getSound().get(3)!=null) {
					Main.m.s3.setText(newVal.getSound().get(3).getName());
					Main.m.s3.setOnAction(e -> {
						Main.imodel.selectedSound = newVal.getSound().get(3);
					});
					} else {
						Main.m.s3.setText("No sound set");
					}
			}
		});

		Main.m.playPause.setOnAction(e -> {
			if (Main.imodel.selectedSound != null) {
				Main.imodel.selectedSound.play();
			}else {
				System.out.println("no sound");
			}
		});
		
		Main.m.createCat.setOnAction(e->{
			System.out.println("test");
			Main.mod.getCategoriesProperty().add(new Category("new Category"));
		});
	}
}
