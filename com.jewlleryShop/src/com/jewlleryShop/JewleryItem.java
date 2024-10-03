package com.jewlleryShop;



public class JewleryItem {
   private int id;
    private String name;

    
	private String type;

    private double price;

    private int quantity;

    public JewleryItem() {}
//    public JewleryItem(String name,int quantity) {}
    public JewleryItem(String name, String type, double price, int quantity) {

        this.name = name;

        this.type = type;

        this.price = price;

        this.quantity = quantity;

    }


    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
  

    // Method to display item details

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void display() {

        System.out.println("Name: " + name);

        System.out.println("Type: " + type);

        System.out.println("Price: $" + price);

        System.out.println("Quantity: " + quantity);

    }

}

