package nuvemdesoftware.ceramicpro.repository;

import nuvemdesoftware.ceramicpro.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductsRepository extends PagingAndSortingRepository<Product, Long> {
}
