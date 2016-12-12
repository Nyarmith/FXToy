package com.fxtoy.application;

import java.io.IOException;

import com.fxtoy.view.GameController;
import com.fxtoy.view.StartMenuController;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class MainApplication extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("FXToy");

		initRootLayout();
		showStartMenu();
	}
	
	private void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class
            		                          .getResource("../view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void showStartMenu() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("../view/StartMenu.fxml"));
            AnchorPane mainMenu = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(mainMenu);
            
            // Give the controller access to the main app
            StartMenuController controller = loader.getController();
            controller.setMainApplication(this);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void showGame() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("../view/Game.fxml"));
            AnchorPane simulation = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(simulation);
        } catch (IOException e) {
            e.printStackTrace();
        }	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
