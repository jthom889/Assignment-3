package mru.tsc.application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import mru.tsc.controller.StoreMenu;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import mru.tsc.view.SBGUI;


public class Main extends Application 
{
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		StoreMenu s = new StoreMenu(null);
		SBGUI gui = new SBGUI(primaryStage, s);
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
