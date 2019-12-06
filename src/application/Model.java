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
		Sound x = new Sound("Bird", "src/SampleSounds/birds2.wav");
		categories.add(cat1);
		cat1.addSound(x);
		cat1.addSound(new Sound("Raven","src/SampleSounds/raven2.wav"));
		
		Category cat2= new Category("Animals 2");
		categories.add(cat2);
		cat2.addSound(new Sound("Horse","src/SampleSounds/horse.wav"));
		cat2.addSound(new Sound("Sea Gull","src/SampleSounds/seagull2.wav"));
		
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
	
	public ArrayList<Category> getCategoriesForSeriliazation() {
		ArrayList<Category> list = new ArrayList<Category>(categories.get());
		return list;
	}
	public void setCategoriesForSeriliazation(ArrayList<Category> arg) {
//		Category cat=new Category("test");
//		cat.getSound().setAll(arg);
//		categories.clear();
		categories.setAll(arg);
	}
	
	
	//TODO Add getters setters and all that stuff
	
	
	
	
	
	
	
	
	
	
	
	
	
}
