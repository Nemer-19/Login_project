package application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class login_controller{
	DataBase_Controller DB = new DataBase_Controller();
	@FXML
	private Button close;
	
	@FXML
	private Button sign_up;
	
	@FXML 
	private TextField username;
	
	@FXML
	private TextField password;
	
	@FXML
	private Button login;
	
	@FXML
	private void login() throws SQLException {
		if(DB.UsernameAndPasswordAreMatched(username.getText(), password.getText())) {
			
		}
	}
	
	@FXML
	private void close() {
		try {
		Stage stage = (Stage) close.getScene().getWindow();
		stage.close();
			
		}catch(Exception e) {
			System.out.print("kdjnnkjsd");
		}
	}
	
	@FXML
	private void sign_up() throws IOException {
		
		Parent sign_UP = FXMLLoader.load(getClass().getResource("sign_up.fxml"));
		Scene scene = new Scene(sign_UP, 700,600);
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		Stage stage = (Stage) close.getScene().getWindow();
		stage.close();
			
		
		
	}
	




	

}
