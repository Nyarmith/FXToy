package com.fxtoy.view;

import ch.makery.address.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class PreferencesController {
	
	private Stage preferencesStage;

	private @FXML TextField dragField;
	private @FXML TextField mouseForceField;
	private @FXML TextField massField;
	
	public void setPreferencesStage(final Stage preferencesStage) {
		this.preferencesStage = preferencesStage;
	}
	
	@FXML
	private void initialize() {
	}
	
	@FXML
	public void handleApply() {
		if (this.isParameterListValid()) {
			// TODO: apply parameters to object
			this.handleClose();
		}
	}
	
	@FXML
	public void handleClose() {
		preferencesStage.close();
	}
	
	private boolean isParameterListValid() {
	    String errorMessage = "";

	    String input = dragField.getText();
        if (input == null || input.length() == 0) {
            errorMessage += "Drag value must be non-empty!\n"; 
        }
        else {
        	try {
        		double d = Double.parseDouble(input);
        		if (d < 0.0 || d > 1.0) {
        			errorMessage += "Mass value must be a real number in range [0, 1].\n";
        		}
        	}
        	catch (NumberFormatException e) {
        		errorMessage += "Mass value must be a number!!\n";
        	}
        }
        
        input = mouseForceField.getText();
        if (input == null || input.length() == 0) {
            errorMessage += "Mouse force value must be non-empty!\n"; 
        }
        // TODO: input validation
        
        input = massField.getText();
        if (input == null || input.length() == 0) {
            errorMessage += "Mass value must be non-empty!\n"; 
        }
        else {
        	try {
        		if (Integer.parseInt(input) < 0) {
        			errorMessage += "Mass value must be non-negative.\n";
        		}
        	}
        	catch (NumberFormatException e) {
        		errorMessage += "Mass value must be a number!!\n";
        	}
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(preferencesStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
	}
}
