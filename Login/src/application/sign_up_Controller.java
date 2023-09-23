package application;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;



import javafx.stage.Stage;

public class sign_up_Controller {
	private String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!-]).{8,}$";

	DataBase_Controller DB = new DataBase_Controller();
	@FXML
	private Label label;

	@FXML
	private Label false_password;

	@FXML
	private Label not_equal;

	@FXML
	private Label exist_UN;
	

	@FXML
	private TextField su_username;

	@FXML
	private PasswordField password1;

	@FXML
	private PasswordField password2;

	@FXML
	private TextField name;

	@FXML
	private TextField firstname;

	@FXML
	private Button show1;

	@FXML
	private Button show2;

	@FXML
	private TextField show_password1;

	@FXML
	private Button hide1;

	@FXML
	private TextField show_password2;

	@FXML
	private Button hide2;

	@FXML
	public Button sign_up;


	public void initialize() {
		show_password1.setVisible(false);
		hide1.setVisible(false);
		show_password2.setVisible(false);
		hide2.setVisible(false);
	}

	

	
	
	@FXML
	private void SignUp(ActionEvent e) throws SQLException, IOException {

		if (su_username.getText().isBlank() == false && password1.getText().isBlank() == false
				&& password2.getText().isBlank() == false && name.getText().isBlank() == false
				&& firstname.getText().isBlank() == false) {
			label.setVisible(false);
			if (password1.getText().equals(password2.getText())) {
				if (isValidPassword(password1.getText()) && password1.getText().length() >= 8) {
					if(DB.UniqueUser(su_username.getText())) {
						
					
					label.setText("You try to login");
					 DB.insertUser(su_username.getText(), password1.getText(), name.getText(), firstname.getText());
					Stage stage = (Stage) sign_up.getScene().getWindow();
					stage.close();
					Parent success = FXMLLoader.load(getClass().getResource("Success Regisred.fxml"));
					Scene scene = new Scene(success, 700, 600);
					Stage PS = new Stage();
					PS.setScene(scene);
					PS.show();
					}else {
						exist_UN.setVisible(true);
						label.setVisible(false);
						not_equal.setVisible(false);
						false_password.setVisible(false);
						exist_UN.setText("the user "+ su_username.getText() +" is already exist.");
						System.out.println("Khkajwkdjajd");
					}
				} else {
					not_equal.setVisible(false);
					exist_UN.setVisible(false);
					label.setVisible(false);
					false_password.setVisible(true);
					false_password.setText(
							"The password requires\n- at least 8 characters long\n- uppercase,\n- lowercase,\n- [@#$%^&+=!-].");
				}
			} else {
				false_password.setVisible(false);
				label.setVisible(false);
				exist_UN.setVisible(false);
				not_equal.setVisible(true);
				not_equal.setText("Passwords do not match.");
				
			}

		} else {
			exist_UN.setVisible(false);
			not_equal.setVisible(false);
			false_password.setVisible(false);
			label.setVisible(true);
			label.setText("Please complete all required fields.");
		}
		
	}

	private boolean isValidPassword(String password) {
		return password.matches(PASSWORD_PATTERN);
	}

	@FXML
	private void show1() {

		show1.setOnAction(e -> {

			show_password1.setText(password1.getText());
			show_password1.setVisible(true);
			password1.setVisible(false);
			hide1.setVisible(true);
		});
		hide1.setOnAction(e -> {
			password1.setText(show_password1.getText());
			hide1.setVisible(false);
			show_password1.setVisible(false);
			password1.setVisible(true);
		});
	}

	@FXML
	private void show2() {

		show2.setOnAction(e -> {

			show_password2.setText(password2.getText());
			show_password2.setVisible(true);
			password2.setVisible(false);
			hide2.setVisible(true);
		});
		hide2.setOnAction(e -> {
			password2.setText(show_password2.getText());
			hide2.setVisible(false);
			show_password2.setVisible(false);
			password2.setVisible(true);
		});
	}
}
