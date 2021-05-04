package model;

import dao.AccountDAO;

public class LoginLogic {
	public boolean execute(Login login) {
		AccountDAO dao = new AccountDAO();
		Account account = dao.findUser(login);
		return account != null;
	}
	
//	public static void main(String[] args) {
//		LoginLogic logic = new LoginLogic();
//		Login login = new Login("shinya", "1234");
//		if (logic.execute(login)) {
//			System.out.println("login success!");
//		} else {
//			System.out.println("login failed...");
//		}
//	}
}
