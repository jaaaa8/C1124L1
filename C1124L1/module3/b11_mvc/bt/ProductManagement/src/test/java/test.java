import service.ProductService;

public class test {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        System.out.println("Total products: " + productService.size());
    }
}
