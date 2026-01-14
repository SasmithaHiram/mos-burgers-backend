package edu.icet.ecom.controller;

import edu.icet.ecom.dto.Product;
import edu.icet.ecom.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin

public class ProductController {
    private final ProductService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody Product product) {
        service.addProduct(product);
    }

    @GetMapping("/searchById/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Product searchById(@PathVariable Integer id) {
        return service.searchProductById(id);
    }

    @GetMapping("/searchByName/{name}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Product> searchByName(@PathVariable String name) {
        return service.searchProductByName(name);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateProduct(@RequestBody Product product) {
        service.updateProduct(product);
    }

    @DeleteMapping("/delete/{code}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteProduct(@PathVariable Integer code) {
        service.deleteProduct(code);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProdcut() {
        return service.getAllProduct();
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getBurgers() {
        return service.getBurgers();
    }

}
