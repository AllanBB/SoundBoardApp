package application;

import java.util.ArrayList;

import domainObjects.Category;
import domainObjects.Sound;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {

	static SimpleListProperty<Category> categories;
	SimpleListProperty<Sound> sounds;
	
	private int buttonRadius;

	public Model(int buttonRadius) {
		ArrayList<Category> list = new ArrayList<Category>();
		ObservableList<Category> observableList = FXCollections.observableArrayList(list);
		categories = new SimpleListProperty<Category>(observableList);

		
		Category cat1 = new Category("Animals");
		Sound x = new Sound("Cat", "Meow");
		categories.add(cat1);
		//categories.get(0).addSound(x);
		
		this.buttonRadius = buttonRadius;
	}

	public SimpleListProperty<Category> getCategoriesProperty(){
		return categories;
	}
	
	public ObservableList<Category> getCategories(){
//		ArrayList<String> list = new ArrayList<String>();
//		for(Category cat:categories) {
//			list.add(cat.getName());
//		}
		
		return categories.getValue();
	}
	
	//TODO Add getters setters and all that stuff
	
	
	
	
	
	
	
	
	
	
	
	
	
}
