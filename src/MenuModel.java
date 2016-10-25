import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

class MenuModel extends JButton {
	private String itemName;
	private double itemPrice;
	
	
	MenuModel(String name, double price) {
		super(name);
		this.itemName = name;
		this.itemPrice = price;
		
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String toString() {
		return this.getItemName();
	}
	
	
}