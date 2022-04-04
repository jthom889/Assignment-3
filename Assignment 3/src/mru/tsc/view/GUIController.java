package mru.tsc.view;



import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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