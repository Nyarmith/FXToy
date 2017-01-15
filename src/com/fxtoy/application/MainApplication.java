package com.fxtoy.application;

import java.io.IOException;

import com.fxtoy.view.StartMenuController;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class MainApplication extends Application
                             implements EventHandler<KeyEvent> {
	
	private Stage parameterStage = new Stage();
	private Stage primaryStage;
	private BorderPane rootLayout;
	private GameLoop gameLoop;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("FXToy");

		initRootLayout();
		initParameterStage();
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

	private void initParameterStage() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApplication.class.getResource("../view/Preferences.fxml"));
			AnchorPane preferences = (AnchorPane) loader.load();
		
			Scene scene = new Scene(preferences);
			parameterStage.setScene(scene);
			parameterStage.initModality(Modality.WINDOW_MODAL);
		}
		catch (IOException e) {
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
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("../view/Game.fxml"));
            AnchorPane simulation = (AnchorPane) loader.load();

            rootLayout.setCenter(simulation);
            rootLayout.getScene().setOnKeyPressed(this);
            Canvas canvas = (Canvas) simulation.getChildren().get(0);
            
            gameLoop = new GameLoop(canvas.getGraphicsContext2D());
            gameLoop.start();
        } catch (IOException e) {
            e.printStackTrace();
        }	
	}
	
	@Override
	public void handle(KeyEvent event) {
		if (event.getCode() == KeyCode.F2 ) {
			toggleParameterStage();
		}
	}
	
	private void toggleParameterStage() {
		if (parameterStage.isShowing()) {
			parameterStage.hide();
		}
		else {
			parameterStage.show();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
