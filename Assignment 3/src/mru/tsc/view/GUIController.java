package mru.tsc.view;



import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import mru.tsc.controller.StoreMenu;
import mru.tsc.model.Toys;

public class GUIController implements Initializable{
	
	
	@FXML
	private ToggleGroup search;
	@FXML
	private TextField rtSN;
	@FXML
	private Button removeToy;
	@FXML
	private ListView<String> rtList;
	@FXML
	private ChoiceBox<String> category;
	@FXML
	private TextField addSN;
	@FXML
	private TextField addName;
	@FXML
	private TextField addBrand;
	@FXML
	private TextField addPrice;
	@FXML
	private TextField addCount;
	@FXML
	private TextField addAge;
	@FXML 
	private TextField figClass;
	@FXML 
	private TextField animalMat;
	@FXML 
	private TextField animalSize;
	@FXML 
	private TextField puzzleType;
	@FXML 
	private TextField bgMin;
	@FXML 
	private TextField bgCMax;
	@FXML 
	private TextField bgDesign;
	@FXML
	private Button addSave;
	
	
	StoreMenu st;
	ArrayList<Toys> toys;
	
	public GUIController() {
		st = new StoreMenu("res/text.txt");
		toys = st.getToys();
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		for(Toys t: toys) {
			rtList.getItems().add(t.toString());
		}
		
		category.getItems().addAll("Figures", "Animal", "Puzzle", "Board Game");
		
		
		
	}
	
	
	public void removeCLicked(ActionEvent e) {
		
		String SN = "";
		if(rtSN.getText() != "") {
			
			for(Toys t: toys) {
				int count = 0;
				
				SN = Long.toString(t.getSerialNo());
				if(rtSN.getText().equals(SN)) {
					toys.remove(t);
					rtList.getItems().remove(count);
					break;
				}
				
				count++;
			}
			
		}
	}

	

}