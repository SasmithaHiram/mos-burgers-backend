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
    @ResponseStatus(HttpStatus.CREATED)
    public void addItem(@RequestBody Product product) {
        service.addProduct(product);
    }

    @GetMapping("/search-productById/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Product searchById(@PathVariable Integer id) {
        return service.searchProductById(id);
    }

    @GetMapping("/search-productByName/{name}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Product> searchByName(@PathVariable String name) {
        return service.searchProductByName(name);
    }

    @PutMapping("/update-product")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateItem(@RequestBody Product product) {
        service.updateProduct(product);
    }

    @DeleteMapping("/delete-product/{code}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void DeleteItem(@PathVariable Integer code) {
        service.deleteProduct(code);
    }

    @GetMapping("/get-all-product")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllItems() {
        return service.getAllProduct();
    }

}
