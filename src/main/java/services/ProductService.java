package services;

import nuvemdesoftware.ceramicpro.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {

    private final ProductsRepository _productsRepository;

    @Autowired
    public ProductService(ProductsRepository productsRepository) {
        _productsRepository = productsRepository;
    }
}
