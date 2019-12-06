package controllers;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AboutController {

	@FXML
	Button back;
	
	@FXML
	private void initialize() {
		back.setOnAction(e->{
			Main.root.setCenter(Main.m);
		});
	}
	
	
}
