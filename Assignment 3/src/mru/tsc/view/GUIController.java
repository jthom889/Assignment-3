package mru.tsc.view;



import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import mru.tsc.controller.StoreMenu;
import mru.tsc.exceptions.ClassificationException;
import mru.tsc.exceptions.PuzzleException;
import mru.tsc.exceptions.SizeException;
import mru.tsc.model.Animals;
import mru.tsc.model.BoardGames;
import mru.tsc.model.Figures;
import mru.tsc.model.Puzzles;
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
	private TextField bgMax;
	@FXML 
	private TextField bgDesign;
	@FXML
	private Button addSave;
	@FXML
	private Label addError;
	@FXML
	private TextArea displayArea;
	
	
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
		
		//sets the addError message to an empty string
		addError.setText("");
		
		
		
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
		st.exit();
	}
	
	public void addClicked(ActionEvent e) {
		
		long sn = 0;
		String name = "";
		String brand = "";
		double price = 0;
		int count = 0;
		String age = "";
		
		
		
		try{
		//setting the user input equal to the variables
		sn = Long.parseLong(addSN.getText());
				
		name = addName.getText();
			
		brand = addBrand.getText();
				
		price = Double.parseDouble(addPrice.getText());
				
		count = Integer.parseInt(addCount.getText());
				
		age = addAge.getText();
		
		addError.setText("");
				
		}
		catch(NumberFormatException e1) {
			addError.setText("Invalid Input");
				
		}
		catch(Exception e2) {
			addError.setText("Invalid Input");
				
		}
		
		
		
		
		if (category.getValue().equals("Figure")) {
				
			char classification = figClass.getText().charAt(0);	
			
			Toys t = null;
			try {
				t = new Figures(sn, name, brand, price, count, age, classification);
			} catch(ClassificationException e1) {
				
				addError.setText("Invalid Classification");
			}
			
			
			
			toys.add(t);
			st.exit();
			addError.setText("Toy Added");
			
		}
		else if (category.getValue().equals("Animal")) {
			
			String material = animalMat.getText();
			char size = animalSize.getText().charAt(0);
			
			Toys t = null;
			try {
				t = new Animals(sn, name, brand, price, count, age, material, size);
			} catch (SizeException e1) {
				
				addError.setText("Invalid Size");
			}
			toys.add(t);
			st.exit();
			addError.setText("Toy Added");
			
		}
		else if (category.getValue().equals("Puzzle")) {
			
			char type = puzzleType.getText().charAt(0);
			
			Toys t = null;
			try {
				t = new Puzzles(sn, name, brand, price, count, age, type);
			} catch (PuzzleException e1) {
				
				addError.setText("Invalid Type");
			}
			toys.add(t);
			st.exit();
			addError.setText("Toy Added");
			
		}
		else if (category.getValue().equals("Board Game")) {
			
			int min = 0;
			int max = 0;
			
			try {
				
				min = Integer.parseInt(bgMin.getText());
				max = Integer.parseInt(bgMax.getText());
				
			} catch (NumberFormatException e1) {
				addError.setText("Invalid Max or Min");
			}
			
			
			String designers = bgDesign.getText();
			
			Toys t = new BoardGames(sn, name, brand, price, count, age, min, max, designers);
			
			toys.add(t);
			st.exit();
			addError.setText("Toy Added");
		}
		
	}

	

}