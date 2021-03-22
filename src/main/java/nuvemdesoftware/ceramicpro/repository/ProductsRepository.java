package nuvemdesoftware.ceramicpro.repository;

import nuvemdesoftware.ceramicpro.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ProductsRepository extends PagingAndSortingRepository<Product, Long> {

    Page<Product> findByCustomerProductId(String customerProductId, Pageable pageable);
    Page<Product> findByCustomerProductIdStartsWith(String customerProductId, Pageable pageable);

    @Query("select prod from Product prod where customer_product_id like %:searchValue% or product_name like %:searchValue% or internal_product_id like %:searchValue% ")
    Page<Product> findByCustProdIdProdNameInternalProdId(String searchValue, Pageable pageable);
}
