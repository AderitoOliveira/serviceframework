package nuvemdesoftware.ceramicpro.controller;

import nuvemdesoftware.ceramicpro.model.Product;
import nuvemdesoftware.ceramicpro.repository.ProductsRepository;
import nuvemdesoftware.ceramicpro.utils.CustomPageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@CrossOrigin
public class ProductController {

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
                    //.map(Product::new)
                    .collect(toList());

            //return new PageImpl<>(products, pageRequest, pageResult.getTotalElements());
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

    @PostMapping(path="/saveProduct" ,consumes = "application/json", produces = "application/json")
    public void saveProduct(@RequestBody Product product){
        System.out.println("PRODUTO: " + product.toString());
    }
}
