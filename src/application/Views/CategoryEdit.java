package application.Views;

import javafx.scene.control.TextField;
import domainObjects.Sound;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * The editable view of a category 
 */
public class CategoryEdit {

	TextField name,description;
	ListView<Sound> listOfSound;
	Button save,delete,addSound,RemoveSound;
	
}
