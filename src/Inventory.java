import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> productList;

    private Notification notification;

    private final Integer QUANTITY_MINIMUM_THRESHOLD;

    public Inventory(Notification notification, Integer minimumThreshold) {
        this.notification = notification;
        QUANTITY_MINIMUM_THRESHOLD = minimumThreshold;
        productList = new ArrayList<>();
    }

    private Boolean isProductQuantityLessThanThreshold(Product product) {
        return product.getQuantity() < QUANTITY_MINIMUM_THRESHOLD;
    }

    private Boolean isProductAlreadyExist(Product product) {
        if(productList.isEmpty()) {
            return false;
        }
        for(Product curProduct: productList) {
            if(curProduct.getName().equals(product.getName())) {
                return true;
            }
        }
        return false;
    }

    public void addProduct(Product product) throws Exception {
        if(isProductAlreadyExist(product)) {
            throw new Exception("Product already exist");
        }
        productList.add(product);
        if(isProductQuantityLessThanThreshold(product)) {
            notification.notify(product);
        }
    }

    public void updateProduct(String name, Integer newQuantity) throws Exception {
        for(Product product: productList) {
            if(product.getName().equals(name)) {
                product.setQuantity(newQuantity);
                if(isProductQuantityLessThanThreshold(product)) {
                    notification.notify(product);
                }
                return;
            }
        }
        throw new Exception("Product doesn't exist");
    }

    public List<Product> getProductList() {
        return productList;
    }

    public List<Product> searchProductByName(String name) {
        List<Product> res = new ArrayList<>();
        for(Product product: productList) {
            if(product.getName().equals(name)) {
                res.add(product);
            }
        }
        return res;
    }

    public List<Product> searchProductByCategory(String category) {
        List<Product> res = new ArrayList<>();
        for(Product product: productList) {
            if(product.getCategory().equals(category)) {
                res.add(product);
            }
        }
        return res;
    }

}
