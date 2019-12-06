package application.Views;

import application.Main;
import domainObjects.Category;
import domainObjects.Clip;
import domainObjects.Mix;
import domainObjects.Playlist;
import domainObjects.Sound;
import javafx.collections.ListChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

/**
 * The main view which will contain the list of category and sfx buttons
 */
public class MainView extends BorderPane {
	public Button s0, s1, s2, s3, playPause, createCat,soundEditButton,mixEditButton,playlistEditButton,clipEditButton,deleteCat;
	public ListView<Category> catList;

	public MainView() {

		// Create Listview of Categories

		catList = new ListView<Category>();
		catList.setEditable(true);
		catList.setCellFactory(param -> {
			TextFieldListCell<Category> cell = new TextFieldListCell<Category>() {
				@Override
				public void updateItem(Category cat, boolean empty) {
					super.updateItem(cat, empty);
					if (empty || cat == null | cat.getName() == null) {
						setText(null);
					} else {
						setText(cat.getName());
					}
				}
			};
			 cell.setConverter(new StringConverter<Category>() {
		            @Override
		            public String toString(Category cat) {
		                return cat.getName();
		            }
		            @Override
		            public Category fromString(String string) {
		            	Category cat = cell.getItem();
		            	cat.setName(string);
		                return cat ;
		            }
		        });
			return cell;
		});

		Main.mod.getCategoriesProperty().addListener(new ListChangeListener<Category>() {
			@Override
			public void onChanged(javafx.collections.ListChangeListener.Change<? extends Category> c) {
				catList.setItems(Main.mod.getCategories());
			}
		});
		catList.setItems(Main.mod.getCategories());
		this.setLeft(catList);
		catList.getSelectionModel().select(0);

		// Hbox for edit/create/mix buttons
		HBox hb1 = new HBox();

		soundEditButton = new Button("Edit Sound");
		soundEditButton.setStyle(Sound.style);
		mixEditButton = new Button("Edit Mix");
		mixEditButton.setStyle(Mix.style);
		playlistEditButton = new Button("Edit Playlist");
		playlistEditButton.setStyle(Playlist.style);
		clipEditButton = new Button("Edit Clip");
		clipEditButton.setStyle(Clip.style);
		createCat = new Button("Create Category");
		deleteCat= new Button("DeleteCat");

		// button icon found from: <div>Icons made by <a
		// href="https://www.flaticon.com/authors/freepik" title="Freepik">Freepik</a>
		// from <a href="https://www.flaticon.com/"
		// title="Flaticon">www.flaticon.com</a></div>
		Image play = new Image(getClass().getResourceAsStream("./play.png"));
		playPause = new Button();
		playPause.setGraphic(new ImageView(play));

		hb1.setSpacing(30.0);

		// hb1.setPadding(10.0);

		hb1.getChildren().addAll(soundEditButton, mixEditButton,playlistEditButton,clipEditButton, createCat,deleteCat);

		HBox hb2 = new HBox();
		hb2.getChildren().addAll(playPause);

		// BorderPane.setAlignment(hb1, Pos.TOP_RIGHT);

		// Create Sound Buttons
		VBox buttonVBox = new VBox();
		HBox hb3 = new HBox();
		HBox hb4 = new HBox();
		s0 = new Button(Main.mod.getCategories().get(0).getSound().get(0).getName());
		s1 = new Button(Main.mod.getCategories().get(0).getSound().get(1).getName());
		s2 = new Button(Main.mod.getCategories().get(0).getSound().get(2).getName());
		s3 = new Button(Main.mod.getCategories().get(0).getSound().get(3).getName());
		
		s0.setStyle(Main.mod.getCategories().get(0).getSound().get(0).getStyle());
		s1.setStyle(Main.mod.getCategories().get(0).getSound().get(1).getStyle());
		s2.setStyle(Main.mod.getCategories().get(0).getSound().get(2).getStyle());
		s3.setStyle(Main.mod.getCategories().get(0).getSound().get(3).getStyle());
		
		buttonVBox.setSpacing(30.0);
		hb3.setSpacing(30.0);
		hb4.setSpacing(30.0);

		hb3.getChildren().addAll(s0, s1);
		hb4.getChildren().addAll(s2, s3);
		buttonVBox.getChildren().addAll(hb3,hb4);
		// BorderPane.setAlignment(hb2, Pos.BOTTOM_RIGHT);

		// Outer VBox

		VBox vb = new VBox(8);
		Separator sep = new Separator();
		vb.getChildren().addAll(hb1, hb2, sep, buttonVBox);
		this.setRight(vb);
		
		Main.imodel.buttonSounds.addListener(new ListChangeListener<Sound>() {
			
			@Override
			public void onChanged(Change<? extends Sound> c) {
				s0.setText(Main.imodel.buttonSounds.get(0).getName());
				s1.setText(Main.imodel.buttonSounds.get(1).getName());
				s2.setText(Main.imodel.buttonSounds.get(2).getName());
				s3.setText(Main.imodel.buttonSounds.get(3).getName());
				
				s0.setStyle(Main.imodel.buttonSounds.get(0).getStyle());
				s1.setStyle(Main.imodel.buttonSounds.get(1).getStyle());
				s2.setStyle(Main.imodel.buttonSounds.get(2).getStyle());
				s3.setStyle(Main.imodel.buttonSounds.get(3).getStyle());
				
			}
			
		});
		s0.getStyleClass().add("CustomButton");
		s1.getStyleClass().add("CustomButton");
		s2.getStyleClass().add("CustomButton");
		s3.getStyleClass().add("CustomButton");
		soundEditButton.getStyleClass().add("CustomButton");
		playlistEditButton.getStyleClass().add("CustomButton");
		mixEditButton.getStyleClass().add("CustomButton");
		clipEditButton.getStyleClass().add("CustomButton");
	}

	// list of categories

	// list of buttons filtered by imodel.selected category
}
