package application;


import domainObjects.Category;
import domainObjects.Sound;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

/**
 * The interactive state of the app 
 */
public class IModel {

	Pane currentView;//we could swap between the different view as needed based on need to edit
	
	Category selectedCategory;
	public ObservableList<Sound> selectedSound;
	public ObservableList<Sound> buttonSounds;
	
	public IModel() {
		buttonSounds = FXCollections.observableArrayList(new Callback<Sound, Observable[]>() {
			@Override
			public Observable[] call(Sound param) {
				return new Observable[] { param.getNameProperty(),param.getPathProperty() };
			}
		});
		buttonSounds.add(Main.mod.getCategories().get(0).getSound().get(0));
		buttonSounds.add(Main.mod.getCategories().get(0).getSound().get(1));
		buttonSounds.add(Main.mod.getCategories().get(0).getSound().get(2));
		buttonSounds.add(Main.mod.getCategories().get(0).getSound().get(3));
		
		selectedSound = FXCollections.observableArrayList(new Callback<Sound, Observable[]>() {
			@Override
			public Observable[] call(Sound param) {
				return new Observable[] { param.getNameProperty(),param.getPathProperty() };
			}
		});
		selectedSound.add(Main.mod.getCategories().get(0).getSound().get(0));
	}
}
