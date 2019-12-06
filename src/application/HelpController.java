package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HelpController {

	@FXML
	Button back;
	
	@FXML
	private void initialize() {
		back.setOnAction(e->{
			Main.root.setCenter(Main.m);
		});
	}
}
