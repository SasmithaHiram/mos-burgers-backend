package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Product;
import edu.icet.ecom.entity.ProductEntity;
import edu.icet.ecom.repository.ProductRepository;
import edu.icet.ecom.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {
    final ProductRepository repository;
    final ModelMapper mapper;

    @Override
    public void addProduct(Product product) {
        repository.save(mapper.map(product, ProductEntity.class));
    }

    @Override
    public Product searchProductById(Integer id) {
        return mapper.map(repository.findById(id), Product.class);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        List<ProductEntity> byName = repository.findByName(name);

        List<Product> products = new ArrayList<>();

        byName.forEach(productEntity -> {
            products.add(mapper.map(productEntity, Product.class));
        });
        return products;
    }

    @Override
    public void updateProduct(Product product) {
        repository.save(mapper.map(product, ProductEntity.class));
    }

    @Override
    public void deleteProduct(Integer code) {
        repository.deleteById(code);
    }

    @Override
    public List<Product> getAllProduct() {
        List<ProductEntity> productEntityList = repository.findAll();

        ArrayList<Product> products = new ArrayList<>();
        productEntityList.forEach(productEntity -> {
            products.add(mapper.map(productEntity, Product.class));
        });
        return products;
    }

}
