package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class success_Controller {

	@FXML
	Button To_login;
	
	@FXML
	private void to_login(ActionEvent e) throws IOException {
		Parent to_login = FXMLLoader.load(getClass().getResource("layout.fxml"));
		Scene scene = new Scene(to_login , 700 , 600);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
		
		Stage s = (Stage) To_login.getScene().getWindow();
		s.close();
	}
}
