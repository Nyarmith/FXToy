package will;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import will.view.MainMenuController;
import will.view.PreferencesDialogController;
import will.view.RootLayoutController;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("FXToy");

		initRootLayout();
		showMainMenu();
	}
	
	private void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class
                    .getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void showMainMenu() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/MainMenu.fxml"));
            BorderPane mainMenu = (BorderPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(mainMenu);
            
            // Give the controller access to the main app
            MainMenuController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void showPreferencesDialog() {
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(Main.class
   				                   .getResource("view/PreferencesDialog.fxml"));
    		AnchorPane page = (AnchorPane) loader.load();
    		
    		Stage dialogStage = new Stage();
    		dialogStage.setTitle("Edit Person");
    		dialogStage.initModality(Modality.WINDOW_MODAL);
    		dialogStage.initOwner(primaryStage);
    		
    		Scene scene = new Scene(page);
    		dialogStage.setScene(scene);

    		// Set the person into the controller.
    		PreferencesDialogController controller = loader.getController();
    		
    		// Show the dialog and wait until the loader class closes it.
    		dialogStage.showAndWait();
    	}
    	
    	catch (IOException e) {
    		e.printStackTrace();
    	}	
	}
	
	public void showSimulation() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Simulation.fxml"));
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
