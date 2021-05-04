package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Account;
import model.Login;

public class AccountDAO {
	private final String jDBC_URL = "jdbc:h2:tcp://localhost/~/itemManager";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public Account findUser(Login login) {
		Account account = null;
		
		try (Connection connection = DriverManager.getConnection(jDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT NAME, PASS FROM USER WHERE NAME = ? AND PASS = ?";
			PreparedStatement pStmt = connection.prepareStatement(sql);
			pStmt.setString(1, login.getUserName());
			pStmt.setString(2, login.getPass());
			
			ResultSet rSet = pStmt.executeQuery();
			
			if (rSet.next()) {
				String userName = rSet.getString("NAME");
				String pass = rSet.getString("PASS");
				account = new Account(userName, pass);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return account;
	}
	
	//TODO: delete this later
//	public static void main(String[] args) {
//		Login login = new Login("shinya", "1234");
//		AccountDAO dao = new AccountDAO();
//		Account result = dao.findUser(login);
//		if (result != null) {
//			System.out.println(result.getUserName());
//		} else {
//			System.out.println("user not found");
//		}
//	}
}
