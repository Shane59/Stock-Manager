package model;

import java.util.List;

import dao.ItemDAO;

public class ItemLogic {
	public List<Item> getAllItem() {
		ItemDAO dao = new ItemDAO();
		return dao.getAllItem();
	}
	public boolean addItem(Item item) {
		ItemDAO dao = new ItemDAO();
		return dao.addItem(item);
	}
	
	public boolean deleteItem(int id) {
		ItemDAO dao = new ItemDAO();
		return dao.deleteItem(id);
	}
	
	public boolean editItem(Item item) {
		ItemDAO dao = new ItemDAO();
		return dao.editItem(item);
	}
	
//	public static void main(String[] args) {
//		ItemLogic logic = new ItemLogic();
//		List<Item> itemList = logic.getAllItem();
//		if (itemList.size() > 0) {
//			System.out.println("success!");
//		} else {
//			System.out.println("fail");
//		}
//		
//		Item item = new Item(3, "test", "testtest", "2021-05-09");
//		if (logic.addItem(item)) {
//			System.out.println("success");
//		} else {
//			System.out.println("fail");
//		}
//	}
}
