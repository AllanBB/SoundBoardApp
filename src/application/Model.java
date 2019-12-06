package application;

import java.io.Serializable;
import java.util.ArrayList;

import domainObjects.Category;
import domainObjects.Sound;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2223793071622849707L;
	SimpleListProperty<Category> categories;
	SimpleListProperty<Sound> sounds;
	

	public Model() {
		ArrayList<Category> list = new ArrayList<Category>();
		ObservableList<Category> observableList = FXCollections.observableArrayList(list);
		categories = new SimpleListProperty<Category>(observableList);

		
		Category cat1 = new Category("Animals");
		Sound x = new Sound("Bird", "soundFile/birds2.wav");
		categories.add(cat1);
		cat1.addSound(x);
		cat1.addSound(new Sound("Raven","soundFile/raven2.wav"));
		
		Category cat2= new Category("Animals 2");
		categories.add(cat2);
		cat2.addSound(new Sound("Horse","soundFile/horse.wav"));
		cat2.addSound(new Sound("Sea Gull","soundFile/seagull2.wav"));
	}

	public SimpleListProperty<Category> getCategoriesProperty(){
		return categories;
	}
	
	public ObservableList<Category> getCategories(){
		return categories.getValue();
	}
	
	public ArrayList<Category> getCategoriesForSeriliazation() {
		ArrayList<Category> list = new ArrayList<Category>(categories.get());
		return list;
	}
	public void setCategoriesForSeriliazation(ArrayList<Category> arg) {
		categories.setAll(arg);
	}
}
