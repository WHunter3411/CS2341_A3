import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProductManager {
    private RedBlackBST<String, Product> productTree;

    public ProductManager() {
        productTree = new RedBlackBST<>();
    }

    public void addProduct(Product product) {
        // duplicate requirment
        if (productTree.contains(product.getProductId())) {
            StdOut.println("Error: Product with ID " + product.getProductId() + " already exists.");
        } else {
            // Add the product to the tree if it doesn't exist
            productTree.put(product.getProductId(), product);
            StdOut.println("Product added: " + product);
        }
    }


    // Search for a product by ID
    public void searchProduct(String productId) {
        Product product = productTree.get(productId);
        if (product == null) {
            StdOut.println("Product with ID " + productId + " not found.");
        } else {
            StdOut.println(product);
        }
    }

    public void loadProducts(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            line = br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

                if (values.length != 4) {
                    StdOut.println("Skipping invalid line: " + line);
                    continue;
                }

                try {
                    // quote remove
                    String productId = values[0].replaceAll("^\"|\"$", "").trim();
                    String name = values[1].replaceAll("^\"|\"$", "").trim();
                    String category = values[2].replaceAll("^\"|\"$", "").trim();
                    String priceStr = values[3].replaceAll("^\"|\"$", "").trim();

                    // Parse the price into a double
                    double price = Double.parseDouble(priceStr.replace("$", "").trim());

                    // Create and add the product
                    Product product = new Product(productId, name, category, price);
                    addProduct(product);
                } catch (NumberFormatException e) {
                    StdOut.println("Skipping line with invalid price: " + line);
                }
            }
        } catch (IOException e) {
            StdOut.println("Error reading file: " + e.getMessage());
        }
    }



    // Test cases to demonstrate functionality
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        // Load products from a CSV file
        StdOut.println("Load products:");
        manager.loadProducts("src/amazon-product-data.csv");

        // Search for products
        StdOut.println("\n--Product Search (I did 4 and illustrated a not-found)--:");
        manager.searchProduct("2e2d46cee23bf6e46bcfc3202be60176");
        manager.searchProduct("d1ac6d805fcdf75f9e00af611dd03ce4");
        manager.searchProduct("89a993dbc079cc3fbe9088c8170b6f99");
        manager.searchProduct("aNonExistentProductID");
        StdOut.println("\n");

        // Add a duplicate product
        StdOut.println("--Duplicate Product Insertion (ID: 2e2d46cee23bf6e46bcfc3202be60176)--:");
        Product duplicate = new Product("2e2d46cee23bf6e46bcfc3202be60176", "Duplicate Product", "Category", 99.99);
        manager.addProduct(duplicate);

        // Add a new product
        StdOut.println("\n--Product Insertion--:");
        Product newProduct1 = new Product("2341ComputerScience", "A Widgit", "New Category", 50.12);
        Product newProduct2 = new Product("CS2341DataStructures", "Hammer", "New Category", 2341.99);
        manager.addProduct(newProduct1);
        manager.addProduct(newProduct2);
    }
}
