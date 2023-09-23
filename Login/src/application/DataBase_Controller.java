package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase_Controller {

	public Connection connect() {
		try {
			String URL = "jdbc:postgresql://localhost:5432/postgres";

			String username = "postgres";
			String password = "Khaled-6382306";
			Connection connection = DriverManager.getConnection(URL, username, password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void insertUser(String UserName, String Password, String name, String firstname) throws SQLException {
		try {

			Connection connection = connect();
			Statement statement = connection.createStatement();
			String InsertQuery = "insert into users (username , u_password , lastname , firstname) values" + " (" + "'"
					+ UserName + "'" + "," + "'" + Password + "'" + "," + "'" + name + "'" + "," + "'" + firstname + "'"
					+ ")";
			statement.execute(InsertQuery);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean UniqueUser(String Username) throws SQLException {
		try {
			Connection connection = connect();
			Statement statement = connection.createStatement();
			String SelectQuery = "select username from users";
			ResultSet res = statement.executeQuery(SelectQuery);
			while (res.next()) {
				String username = res.getString("username");
				System.out.println(username);
				if (username.equals(Username)) {
					return false;

				}
			}
			statement.close();
			connection.close();
			res.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean UsernameAndPasswordAreMatched(String username, String password) throws SQLException {
		try {
			Connection connection = connect();
			Statement statement = connection.createStatement();
			String MachQuerey = "select username , password from users";
			ResultSet res = statement.executeQuery(MachQuerey);
			while (res.next()) {
				String Username = res.getString("username");
				String Password = res.getString("password");

				if (Username.equals(username) && Password.equals(password)) {
					return true;
				}
			}
			statement.close();
			connection.close();
			res.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return false;
	}

}
