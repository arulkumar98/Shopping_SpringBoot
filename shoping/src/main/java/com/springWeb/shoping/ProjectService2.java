package com.springWeb.shoping;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService2 {

    // Simulated in-memory database
    private final List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "iPhone 6", 1000),
            new Product(102, "Google Pixel XL", 50246),
            new Product(103, "Samsung S6", 1000)
    ));

    /**
     * Get all products.
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Get a product by its ID.
     */
    public Product getProductById(int proId) {
        return findProduct(proId)
                .orElse(new Product(0, "No Item", 0)); // Fallback if not found
    }

    /**
     * Add a new product.
     */
    public String addProduct(Product product) {
        boolean added = products.add(product);
        return added ? "Product added" : "Product add failed";
    }

    /**
     * Update an existing product.
     */
    public boolean updateProduct(Product updatedProduct) {
        Optional<Integer> indexOpt = findProductIndex(updatedProduct.getProductId());

        if (indexOpt.isPresent()) {
            products.set(indexOpt.get(), updatedProduct);
            return true;
        }
        return false;
    }

    /**
     * Delete a product by ID.
     */
    public boolean deleteProduct(int proId) {
        Optional<Product> productOpt = findProduct(proId);
        return productOpt.map(products::remove).orElse(false);
    }

    /**
     * Find a product by ID (optional).
     */
    private Optional<Product> findProduct(int proId) {
        return products.stream()
                .filter(p -> p.getProductId() == proId)
                .findFirst();
    }

    /**
     * Find the index of a product by ID (optional).
     */
    private Optional<Integer> findProductIndex(int proId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId() == proId) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }
}
