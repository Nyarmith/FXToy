package com.fxtoy.view;

import com.fxtoy.application.MainApplication;

import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Screen;

public class StartMenuController {
	
	private @FXML TextField width;
	private @FXML TextField height;
	private MainApplication application;
	
	@FXML
	private void initialize() {
		// no-op for now
	}
	
	public void setMainApplication(MainApplication application) {
		this.application = application;
	}
	
	@FXML
	private void handleStart() {
		// TODO: validate canvas resolution
		application.showGame();
	}
	
	@FXML
	private void handleAbout() {
		//TODO: Add credits
		//Magical method to get screen resolution
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        String MaxResStr = "Max Resolution : " + primScreenBounds.getMaxX() + " x " + primScreenBounds.getMaxY() + "\n";
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Woah(!)");
        alert.setHeaderText("\"Ab-OUT\"");
        alert.setContentText(MaxResStr + "Help Me I'm In Virtual Space");

        alert.showAndWait();
	}
	
	@FXML
	private void handleClose() {
		System.exit(0);
	}
}
