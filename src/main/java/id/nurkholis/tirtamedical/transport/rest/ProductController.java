package id.nurkholis.tirtamedical.transport.rest;

import id.nurkholis.tirtamedical.domain.entities.CreateProduct;
import id.nurkholis.tirtamedical.domain.entities.Product;
import id.nurkholis.tirtamedical.domain.interactors.common.PageResult;
import id.nurkholis.tirtamedical.domain.interactors.product.ProductSearchRequest;
import id.nurkholis.tirtamedical.domain.interactors.product.ProductService;
import id.nurkholis.tirtamedical.transport.commands.CreateProductCommand;
import id.nurkholis.tirtamedical.transport.commands.ProductCommandHandler;
import id.nurkholis.tirtamedical.transport.rest.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductCommandHandler productCommand;

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<ResponseDto> addNewProduct(@Validated @RequestBody CreateProduct createProduct) {
        Product product = productCommand.createProductCommandHandler(new CreateProductCommand(createProduct.getSku(),
                createProduct.getName(), createProduct.getPrice(), createProduct.getStock(), createProduct.getCategoryId()));
        return new ResponseEntity<>(ResponseDto.ok(product), HttpStatus.OK);
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<ResponseDto> getProducts(@RequestParam(required = false) List<String> sku, @RequestParam(required = false) String name,
                                                   @RequestParam(name = "price.start", required = false) BigDecimal priceStart, @RequestParam(name = "price.end", required = false) BigDecimal priceEnd,
                                                   @RequestParam(name = "stock.start", required = false) Long stockStart, @RequestParam(name = "stock.end", required = false) Long stockEnd,
                                                   @RequestParam(name = "category.id", required = false) List<UUID> categoryId, @RequestParam(name = "category.name", required = false) List<String> categoryName) {

        ProductSearchRequest searchRequest = new ProductSearchRequest(sku == null ? null : new HashSet<>(sku), name, priceStart, priceEnd,
                stockStart, stockEnd, categoryId==null ? null : new HashSet<>(categoryId), categoryName == null ? null : new HashSet<>(categoryName));
        PageResult<Product> pageResult = productService.searchProduct(searchRequest);
        ResponseDto.Pagedata pagedata = new ResponseDto.Pagedata(pageResult.getCount().intValue(), 1, 10);
        return new ResponseEntity<>(ResponseDto.ok(pageResult.getResult(), pagedata), HttpStatus.OK);
    }
}
