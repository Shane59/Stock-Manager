package model;

public class Item {
	private int id;
	private String name;
	private String description;
	private String expDate;
	
	public Item(int id, String name, String description, String expDate) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.expDate = expDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
}
