package mru.tsc.view;

import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mru.tsc.controller.StoreMenu;

public class SBGUI 
{
	public SBGUI(Stage primaryStage, StoreMenu S)
	{
		try 
		{
			Parent root = (Parent)FXMLLoader.load(getClass().getResource("GUI.fxml"));
			Scene scene = new Scene(root,800,600);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();			
		} 
		
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
}