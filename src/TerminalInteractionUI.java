import java.util.List;
import java.util.Scanner;

public class TerminalInteractionUI {

    private Inventory inventory;

    public TerminalInteractionUI(Inventory inventory) {
        this.inventory = inventory;
    }

    private void printIntro() {
        System.out.println("\nInventory Management System");
        System.out.println("1. Add New Product");
        System.out.println("2. Update Product Quantity");
        System.out.println("3. List All Products");
        System.out.println("4. Search Products by Name");
        System.out.println("5. Search Products by Category");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printIntro();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProductQuantity();
                    break;
                case 3:
                    listAllProducts();
                    break;
                case 4:
                    searchProductsByName();
                    break;
                case 5:
                    searchProductsByCategory();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Exiting the inventory system. Goodbye!");
    }

    private void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter product price: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter initial quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter product category: ");
        String category = scanner.nextLine();

        Product product = new Product(name, category, price, quantity);
        try {
            inventory.addProduct(product);
            System.out.println("Product added successfully!");
        }
        catch (Exception e) {
            System.out.println("Error while adding Product: "+ e.getMessage());
        }
    }

    private void updateProductQuantity() {
        System.out.print("Enter product name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.print("Enter new quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        try {
            inventory.updateProduct(name, quantity);
            System.out.println("Product updated successfully!");
        }
        catch (Exception e) {
            System.out.println("Error while updating Product: "+ e.getMessage());
        }
    }

    private void listAllProducts() {
        List<Product> products = inventory.getProductList();

        System.out.println("\nCurrent Inventory:");
        for (Product product : products) {
            product.printDetails();
        }
    }

    private void searchProductsByName() {
        System.out.print("Enter product name: ");
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        List<Product> products = inventory.searchProductByName(name);

        System.out.println("\nSearch Results:");
        for (Product product : products) {
            product.printDetails();
        }
    }

    private void searchProductsByCategory() {
        System.out.print("Enter product category: ");

        Scanner scanner = new Scanner(System.in);
        String category = scanner.nextLine();

        List<Product> products = inventory.searchProductByCategory(category);

        System.out.println("\nSearch Results:");
        for (Product product : products) {
            product.printDetails();
        }
    }


}
