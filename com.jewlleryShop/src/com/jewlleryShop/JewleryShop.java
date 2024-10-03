package com.jewlleryShop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JewleryShop {
	Statement stmt;
	ResultSet rs;
	String qry=null;
	int count;
	DbInfo db=new DbInfo();
	Connection con;
    private List<JewleryItem> inventory;

    public JewleryShop() {
        this.inventory = new ArrayList<>();
    }

    public void addItem(JewleryItem item) {
//        inventory.add(item);
//        System.out.println("Added item: " + item.getName());
    	  
    	try {
    		con=db.getDBConnection();
    		stmt=con.createStatement();
    		qry="insert into jewellery(name,type,quantity,price) values(' "+item.getName()+"','"+item.getType()+"',' "+item.getPrice()+"','"+item.getQuantity()+"')";
    		count= stmt.executeUpdate(qry);
    		if(count==1) {
    			System.out.println("item added successfully");
    		}
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    	
    }

    public void updateItem(JewleryItem item) throws ItemNotFoundException {
    	try {
    		con=db.getDBConnection();
    		stmt=con.createStatement();
    		qry="update jewellery set quantity="+item.getQuantity()+" where id="+item.getId()+"";
    		count=stmt.executeUpdate(qry);
    		if(count==1) {
    			System.out.println("item Updated successfully");
    		}
    	}catch(Exception e) {
    		
    	}
//        for (JewleryItem item : inventory) {
//        	
//            if (item.getName().equalsIgnoreCase(itemName)) {
//                item.setQuantity(newQuantity);
//                System.out.println("Updated item: " + itemName + " with new quantity: " + newQuantity);
//                return;
//            }
//        }
     //   throw new ItemNotFoundException("Item not found: " + itemName);
    }

    public void removeItem(JewleryItem item) throws ItemNotFoundException {
    	try {
    		con=db.getDBConnection();
    		stmt=con.createStatement();
    		qry="delete from jewellery where id="+item.getId();
    		count=stmt.executeUpdate(qry);
    		if(count==1) {
    			System.out.println("item Deleted successfully");
    		}

    	}catch(Exception e) {}
     //   Iterator<JewleryItem> iterator = inventory.iterator();
//        while (iterator.hasNext()) {
//            JewleryItem item = iterator.next();
//            if (item.getName().equalsIgnoreCase(itemName)) {
//                iterator.remove();
//                System.out.println("Removed item: " + itemName);
//                return;
//            }
//        }
        //throw new ItemNotFoundException("Item not found: " + itemName);
    }

    public void searchItem(String itemName) throws ItemNotFoundException {
        for (JewleryItem item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                item.display();
                return;
            }
        }
        throw new ItemNotFoundException("Item not found: " + itemName);
    }

    public void displayInventory() {
      /*  System.out.println("Jewelry Shop Inventory:");
        if (inventory.isEmpty()) {
            System.out.println("No items in inventory.");
            return;
        }
        for (JewleryItem item : inventory) {
            item.display();
            System.out.println("------------------------");
        } */
    	try {
    		con=db.getDBConnection();
    		stmt=con.createStatement();
    		rs=stmt.executeQuery("select * from jewellery");
    		while(rs.next())
    	    System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getFloat(5));
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    }
}