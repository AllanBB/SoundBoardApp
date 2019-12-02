package application;

import domainObjects.Category;
import domainObjects.Sound;
import javafx.scene.layout.Pane;

/**
 * The interactive state of the app 
 */
public class IModel {

	Pane currentView;//we could swap between the different view as needed based on need to edit
	
	Category selectedCategory;
	Sound selectedSound;
}
