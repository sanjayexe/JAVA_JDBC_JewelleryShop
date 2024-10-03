package com.jewlleryShop;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static JewleryShop shop = new JewleryShop();
    private static JewleryItem item = new JewleryItem();
    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to jewllery Shop Management System");

            boolean isAdmin = scanner.nextBoolean();
            scanner.nextLine(); // Consume newline

            try {
                login(isAdmin);
                if (isAdmin) {
                    handleAdminActions();
                } else {
                    handleUserActions();
                }
            } catch (AuthenticationException e) {
                System.out.println(e.getMessage());
            } 
        }
    }

    private static void login(boolean checkAdmin) throws AuthenticationException {
        while (true) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if ("exit".equalsIgnoreCase(username) && "exit".equalsIgnoreCase(password)) {
                System.out.println("Exiting the program...");
                scanner.close();
                System.exit(0);
            }

            if ("logout".equalsIgnoreCase(username) && "logout".equalsIgnoreCase(password)) {
                System.out.println("Logging out...");
                return; 
            }

            boolean authenticated = checkAdmin ? Login.isAdmin(username, password) : Login.authenticate(username, password);
            if (authenticated) {
                System.out.println(checkAdmin ? "Admin Access granted" : "User Access granted");
                return;
            } else {
                throw new AuthenticationException("Invalid username or password.");
            }
        }
    }

    private static void handleAdminActions() {
        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Add Item");
            System.out.println("2. Update Item");
            System.out.println("3. Remove Item");
            System.out.println("4. Search Item");
            System.out.println("5. Display Inventory");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        addItem();
                        break;
                    case 2:
                        updateItem();
                        break;
                    case 3:
                        removeItem();
                        break;
                    case 4:
                        searchItem();
                        break;
                    case 5:
                        shop.displayInventory();
                        break;
                    case 6:
                        System.out.println("Logging out...");
                        return; // Exit to prompt for user login again
                    default:
                        throw new InvalidInputException("Invalid choice. Please enter a number between 1 and 6.");
                }
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            } 
        }
    }

    private static void handleUserActions() {
        while (true) {
            System.out.println("1. Display Inventory");
            System.out.println("2. Logout");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        shop.displayInventory();
                        break;
                    case 2:
                        System.out.println("Logging out...");
                        return; // Exit to prompt for admin login again
                    default:
                        throw new InvalidInputException("Invalid choice. Please enter 1 or 2.");
                }
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void addItem() {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter item type: ");
        String type = scanner.nextLine();
        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter item quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        shop.addItem(new JewleryItem(name, type, price, quantity));
    }

    private static void updateItem() {  
        System.out.print("Enter item id to update: ");
        item.setId(scanner.nextInt());
        
        System.out.print("Enter new quantity: ");
         item.setQuantity(scanner.nextInt()); 
        try {
            shop.updateItem(item);
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void removeItem() {
        System.out.print("Enter item name to remove: ");
        item.setId(scanner.nextInt());
//        String name = scanner.nextLine();
        try {
            shop.removeItem(item);
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void searchItem() {
        System.out.print("Enter item name to search: ");
        String name = scanner.nextLine();
        try {
            shop.searchItem(name);
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}