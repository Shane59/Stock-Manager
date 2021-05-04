package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Item;

public class ItemDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/itemManager";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public List<Item> getAllItem() {
		List<Item> itemList = new ArrayList<>();
		
		try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT ID, NAME, DESCRIPTION, EXPDATE FROM ITEM";
			
			PreparedStatement pStmt = connection.prepareStatement(sql);
			ResultSet rSet = pStmt.executeQuery();
			
			while (rSet.next()) {
				int id = rSet.getInt("ID");
				String name = rSet.getString("NAME");
				String description = rSet.getString("DESCRIPTION");
				String expDate = rSet.getString("EXPDATE");
				Item item = new Item(id, name, description, expDate);
				itemList.add(item);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return itemList;
	}
	public boolean addItem(Item item) {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO ITEM VALUES (?, ?, ?, ?)";	
			PreparedStatement pStmt = connection.prepareStatement(sql);
			pStmt.setInt(1, item.getId());
			pStmt.setString(2, item.getName());
			pStmt.setString(3, item.getDescription());
			pStmt.setString(4, item.getExpDate());
			
			int rSet = pStmt.executeUpdate();
			
			if (rSet == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean editItem(Item item) {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "UPDATE ITEM SET NAME = ?, DESCRIPTION = ?, EXPDATE = ? WHERE ID = ?";
			PreparedStatement pStmt = connection.prepareStatement(sql);
			
			pStmt.setString(1, item.getName());
			pStmt.setString(2, item.getDescription());
			pStmt.setString(3, item.getExpDate());
			pStmt.setInt(4, item.getId());
			
			int rSet = pStmt.executeUpdate();
			
			if (rSet == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteItem(int id) {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "DELETE FROM ITEM WHERE ID = ?";
			PreparedStatement pStmt = connection.prepareStatement(sql);
			
			pStmt.setInt(1, id);
			
			int rSet = pStmt.executeUpdate();
			
			if (rSet == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
//	public static void main(String[] args) {
//		ItemDAO dao = new ItemDAO();
//		List<Item> itemList = dao.getAllItem();
		
//		if (itemList.size() > 0) {
//			System.out.println("sucess!");
//		}
		
//		for (int i = 0; i < itemList.size(); i++) {
//			System.out.println(itemList.get(i).toString());
//		}
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		Date todayDate = new Date();
//		Item item = new Item(2, "rice", "what is this", format.format(todayDate));
//		if (dao.addItem(item)) {
//			System.out.println("item added!");
//		} else {
//			System.out.println("failed...");
//		}
		
//		Item temp = itemList.get(3);
//		temp.setName("Changed to Shinya");
//		if (dao.editItem(temp)) {
//			System.out.println("success!");
//		} else {
//			System.out.println("false!");
//		}
		
//		if (dao.deleteItem(temp.getId())) {
//			System.out.println("success!");
//		} else {
//			System.out.println("false");
//		}
//	}
}
