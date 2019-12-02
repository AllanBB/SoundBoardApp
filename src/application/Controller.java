package application;

import domainObjects.Category;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;

/**
 * The Applications controller
 */
public class Controller {

	public Controller() {
		Main.m.catList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Category>() {
			@Override
			public void changed(ObservableValue<? extends Category> ov, Category oldVal, Category newVal) {
				System.out.println("Selected");

				Main.m.s0 = new Button(newVal.getSound().get(0).getName());
				Main.m.s0.setOnAction(e -> {
					Main.imodel.selectedSound = newVal.getSound().get(0);
				});
//						s1 = new Button("s1");
//						s2 = new Button("s2");
//						s3 = new Button("s3");
			}
		});
	}
}
