package com.fxtoy.view;

import com.fxtoy.application.MainApplication;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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
		// TODO: display info alert box with credits
	}
	
	@FXML
	private void handleClose() {
		System.exit(0);
	}
}
