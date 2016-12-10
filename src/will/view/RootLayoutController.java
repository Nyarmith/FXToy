package will.view;

import javafx.fxml.FXML;
import will.Main;

public class RootLayoutController {
	
    // Reference to the main application
    private Main main;

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param main
     */
    public void setMainApp(Main main) {
        this.main = main;
    }
    
    @FXML
    private void handlePreferences() {
    	main.showPreferencesDialog();
    }
}
