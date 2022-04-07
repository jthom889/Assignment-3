package mru.tsc.view;

import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mru.tsc.controller.StoreMenu;

/**
 * this class makes the scene for the program
 */
public class SBGUI 
{
	/**
	 * this constructor sets the scene for
	 *  javafx when it is called
	 * @param primaryStage is the stage
	 * @param S is the store menu class
	 */
	public SBGUI(Stage primaryStage, StoreMenu S)
	{
		try 
		{
			Parent root = (Parent)FXMLLoader.load(getClass().getResource("GUI.fxml"));
			Scene scene = new Scene(root,1100,500);
			
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