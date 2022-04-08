package mru.tsc.application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import mru.tsc.controller.StoreMenu;
import mru.tsc.view.SBGUI;

/**
 * this class calls the main menu to run the 
 * program and creates the scene
 * @author jonah and victor
 *
 */
public class Main extends Application 
{
	/**
	 * this method creates the scene and store menu
	 *  objects that create the program
	 */
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		StoreMenu s = new StoreMenu();
		SBGUI gui = new SBGUI(primaryStage, s);
	}
	
	/**
	 * this is the main method that will run the program
	 * @param args
	 */
	public static void main(String[] args) 
	{
		launch(args);
	}
}
