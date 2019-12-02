package application.Views;

import application.Main;
import domainObjects.Category;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * The main view which will contain the list of category and sfx buttons 
 */
public class MainView extends BorderPane{
	public Button s0,s1,s2,s3;
	public ListView <Category> catList;
	
	
	public MainView() {
		
		//Create Listview of Categories
		
		catList = new ListView<Category>();
		ObservableList <Category> list = FXCollections.observableArrayList(Main.mod.getCategories());
		catList.setCellFactory(param -> new ListCell<Category>() {
			@Override
			protected void updateItem(Category cat, boolean empty) {
				super.updateItem(cat, empty);
				if(empty || cat == null | cat.getName()==null) {
					setText(null);
				}else {
					setText(cat.getName());
				}
			}
		});
		
		catList.setItems(list);
		this.setLeft(catList);
		
		
		//Hbox for edit/create/mix buttons
		HBox hb1 = new HBox();
		
		Button edit = new Button("Edit");
		Button mix = new Button("Mix");
		Button createCat = new Button("Create Category");
		Slider slider = new Slider();
		
		//button icon found from: <div>Icons made by <a href="https://www.flaticon.com/authors/freepik" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
		Image play = new Image(getClass().getResourceAsStream("./play.png"));
		Button playPause = new Button();
		playPause.setGraphic(new ImageView(play));
		
		hb1.setSpacing(30.0);
		
		//hb1.setPadding(10.0);
		
		hb1.getChildren().addAll(edit, mix, createCat);
		
		
		HBox hb2 = new HBox();
		hb2.getChildren().addAll(slider, playPause);
		
		//BorderPane.setAlignment(hb1, Pos.TOP_RIGHT);

		//Create Sound Buttons
		HBox hb3 = new HBox();
		
		s0 = new Button("s0");
		s1 = new Button("s1");
		s2 = new Button("s2");
		s3 = new Button("s3");
		
		hb3.setSpacing(30.0);

		hb3.getChildren().addAll(s0,s1,s2,s3);
		//BorderPane.setAlignment(hb2, Pos.BOTTOM_RIGHT);
		
		//Outer VBox
		
		VBox vb = new VBox(8);
		Separator sep = new Separator();
		vb.getChildren().addAll(hb1,hb2,sep,hb3);
		this.setRight(vb);
		
	}

	//list of categories

	
	//list of buttons filtered by imodel.selected category
}
