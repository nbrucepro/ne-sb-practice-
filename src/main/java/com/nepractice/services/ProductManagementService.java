package com.nepractice.services;

import com.nepractice.model.Product;
import com.nepractice.model.Quantity;
import com.nepractice.repository.ProductRepository;
import com.nepractice.repository.QuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductManagementService {
    private final ProductRepository productRepository;
    private final QuantityRepository quantityRepository;

    @Autowired
    public ProductManagementService(ProductRepository productRepository, QuantityRepository quantityRepository) {
        this.productRepository = productRepository;
        this.quantityRepository = quantityRepository;
    }

    public void registerProduct(Product product) {
        productRepository.save(product);
        System.out.println(product);
        System.out.println("Product registered successfully!");
    }
    public void registerQuantity(String productCode, int quantity, String operation, LocalDate date) {
        Quantity quantityEntry = new Quantity();
        quantityEntry.setProductCode(productCode);
        quantityEntry.setQuantity(quantity);
        quantityEntry.setOperation(operation);
        quantityEntry.setDate(date);

        quantityRepository.save(quantityEntry);
        System.out.println("Quantity registered successfully!");
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
