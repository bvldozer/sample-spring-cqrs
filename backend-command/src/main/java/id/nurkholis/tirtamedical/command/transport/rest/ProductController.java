package id.nurkholis.tirtamedical.command.transport.rest;

import id.nurkholis.tirtamedical.command.domain.entities.CreateProduct;
import id.nurkholis.tirtamedical.command.domain.entities.Product;
import id.nurkholis.tirtamedical.command.transport.commands.CreateProductCommand;
import id.nurkholis.tirtamedical.command.transport.commands.ProductCommandHandler;
import id.nurkholis.tirtamedical.command.transport.rest.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductCommandHandler productCommand;

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<ResponseDto> addNewProduct(@Validated @RequestBody CreateProduct createProduct) {
        Product product = productCommand.createProductCommandHandler(new CreateProductCommand(createProduct.getSku(),
                createProduct.getName(), createProduct.getPrice(), createProduct.getStock(), createProduct.getCategoryId()));
        return new ResponseEntity<>(ResponseDto.ok(product), HttpStatus.OK);
    }
}
