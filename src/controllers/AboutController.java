package controllers;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AboutController {

	@FXML
	Button back;
	
	@FXML
	ImageView imageView;
	@FXML
	private void initialize() {
		back.setOnAction(e->{
			Main.root.setCenter(Main.m);
		});
	}
	
	
}
