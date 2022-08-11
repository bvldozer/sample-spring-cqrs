package id.nurkholis.tirtamedical.transport.rest;

import id.nurkholis.tirtamedical.domain.entities.Category;
import id.nurkholis.tirtamedical.domain.interactors.category.CategoryService;
import id.nurkholis.tirtamedical.transport.rest.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    TransactionTemplate transaction;

    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    public ResponseEntity<ResponseDto> addNewCategory(@RequestBody Category category) {
        Category result = categoryService.addCategory(category.getName());
        return new ResponseEntity<>(ResponseDto.ok(result), HttpStatus.OK);
    }
}
