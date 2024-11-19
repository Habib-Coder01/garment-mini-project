/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication5;

import java.util.ArrayList;
import java.util.Scanner;

// Main Class
public class JavaApplication5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GarmentInventory inventory = new GarmentInventory();

        while (true) {
            System.out.println("\n--- Garment Inventory System ---");
            System.out.println("1. Add Garment");
            System.out.println("2. List Garments");
            System.out.println("3. Search Garment by Name");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Garment Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Garment Type: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    
                    inventory.addGarment(new Garment(name, type, price));
                    System.out.println("Garment added successfully!");
                    break;

                case 2:
                    System.out.println("\n--- List of Garments ---");
                    inventory.listGarments();
                    break;

                case 3:
                    System.out.print("Enter Garment Name to Search: ");
                    String searchName = scanner.nextLine();
                    inventory.searchGarmentByName(searchName);
                    break;

                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

// Garment Class
class Garment {
    private String name;
    private String type;
    private double price;

    public Garment(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Type: " + type + ", Price: $" + price;
    }
}

// GarmentInventory Class
class GarmentInventory {
    private ArrayList<Garment> garments;

    public GarmentInventory() {
        garments = new ArrayList<>();
    }

    public void addGarment(Garment garment) {
        garments.add(garment);
    }

    public void listGarments() {
        if (garments.isEmpty()) {
            System.out.println("No garments available.");
            return;
        }

        for (Garment garment : garments) {
            System.out.println(garment);
        }
    }

    public void searchGarmentByName(String name) {
        boolean found = false;

        for (Garment garment : garments) {
            if (garment.getName().equalsIgnoreCase(name)) {
                System.out.println(garment);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Garment not found.");
        }
    }
}
