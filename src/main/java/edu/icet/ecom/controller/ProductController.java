package edu.icet.ecom.controller;

import edu.icet.ecom.dto.Product;
import edu.icet.ecom.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@CrossOrigin

public class ProductController {
    final ProductService service;

    @PostMapping("/add-product")
    public void addItem(@RequestBody Product product) {
        service.addProduct(product);
    }

    @GetMapping("/search-productById/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Product searchById(@PathVariable Integer id) {
        return service.searchProductById(id);
    }

    @PutMapping("/update-product")
    public void updateItem(@RequestBody Product product) {
        service.updateProduct(product);
    }

    @GetMapping("/get-all-product")
    public List<Product> getAllItems() {
        return service.getAllProduct();
    }

    @DeleteMapping("/delete-product/{code}")
    public void DeleteItem(@PathVariable Integer code) {
        service.deleteProduct(code);
    }

}
