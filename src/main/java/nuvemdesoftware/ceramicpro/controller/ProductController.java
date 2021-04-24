package nuvemdesoftware.ceramicpro.controller;

import nuvemdesoftware.ceramicpro.exception.ProductException;
import nuvemdesoftware.ceramicpro.model.Product;
import nuvemdesoftware.ceramicpro.repository.ProductsRepository;
import nuvemdesoftware.ceramicpro.utils.CustomPageImpl;
import nuvemdesoftware.ceramicpro.utils.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import static java.util.stream.Collectors.toList;

@ResponseBody
@RestController
@CrossOrigin
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(FileUtil.class);

    @Value( "${server.port}" )
    private String serverPort;

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductController(ProductsRepository productsRepository){
        this.productsRepository=productsRepository;
    }

    @GetMapping(path="/getAllProducts")
    public CustomPageImpl getAllProducts(@RequestParam(name = "page", defaultValue = "0") int page,
                                         @RequestParam(name = "size", defaultValue = "10") int size,
                                         @RequestParam(name = "search", defaultValue = "") String search) throws UnknownHostException {


        String hostName = InetAddress.getLocalHost().getHostName();

        if(search.equals("")) {
            PageRequest pageRequest = PageRequest.of(page, size);
            Page<Product> pageResult = productsRepository.findAll(pageRequest);

            pageResult.forEach(product -> product.setImage_path("http://" + hostName + ":" + serverPort + "/" + "images/?imageName=" + product.getImage_name()));

            List<Product> products = pageResult.stream().collect(toList());

            return new CustomPageImpl(products, pageRequest, pageResult.getTotalElements());
        } else {
            PageRequest pageRequest = PageRequest.of(page, size);
            Page<Product> pageResult = productsRepository.findByCustProdIdProdNameInternalProdId(search, pageRequest);

            pageResult.forEach(product -> product.setImage_path("http://" + hostName + ":" + serverPort + "/" + "images/?imageName=" + product.getImage_name()));

            List<Product> products = pageResult
                    .stream()
                    .collect(toList());

            return new CustomPageImpl(products, pageRequest, pageResult.getTotalElements());
        }

    }

    @GetMapping(path="/getProduct")
    public Product getProduct(@RequestParam(name = "customerProductId", defaultValue = "0") String customerProductId) throws UnknownHostException {

        String hostName = InetAddress.getLocalHost().getHostName();

        Product product = productsRepository.findByCustomerProductId(customerProductId);
        product.setImage_path("http://" + hostName + ":" + serverPort + "/" + "images/?imageName=" + product.getImage_name());

        return product;
    }

    @PostMapping(path="/saveProduct")
    public ResponseEntity saveProduct(@RequestBody Product product) throws ProductException {

        Product productToUpdate = null;
        try {
            productToUpdate = this.productsRepository.findByCustomerProductId(product.getCustomer_product_id());
            productToUpdate.setInternal_product_id(product.getInternal_product_id());
            productToUpdate.setClient_name(product.getClient_name());
            productToUpdate.setProduct_name(product.getProduct_name());
            productToUpdate.setPrice_euro_1(product.getPrice_euro_1());
            productToUpdate.setPrice_euro_2(product.getPrice_euro_2());
            productToUpdate.setProduct_name_for_label(product.getProduct_name_for_label());
            productToUpdate.setIs_parent(product.getIs_parent());
            this.productsRepository.save(productToUpdate);
        } catch (Exception exception) {
            LOG.error("Problem Saving product!", exception);
            throw new ProductException("Problem saving product " + productToUpdate.getCustomer_product_id() + " - " + productToUpdate.getProduct_name());
        }

        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
