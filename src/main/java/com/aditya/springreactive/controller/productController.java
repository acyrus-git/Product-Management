package com.aditya.springreactive.controller;

import com.aditya.springreactive.dto.ProductDto;
import com.aditya.springreactive.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class productController {
    @Autowired
    ProductService productService;

    @GetMapping
    public Flux<ProductDto> getProducts(){
        return productService.getProducts();
    }
    @GetMapping("/{id}")
    public Mono<ProductDto> getProduct(@PathVariable String id){
        return productService.getProduct(id);
    }

    @GetMapping("/product-range")
    public Flux<ProductDto> getProductInRange(@RequestParam double min , @RequestParam double max)
    {
        return productService.getProductInRange(min,max);
    }

    @PostMapping("/save-product")
    public Mono<ProductDto> saveProduct(@RequestBody Mono<ProductDto>productDtoMono){
        return productService.saveProduct(productDtoMono);
    }

    @PutMapping("/update-product/{id}")
    public Mono<ProductDto> updateProduct(@RequestBody Mono<ProductDto>productDtoMono,@PathVariable String id){
        return productService.updateProduct(productDtoMono,id);
    }

    @DeleteMapping("/delete-product/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id)
    {
        return productService.deleteProduct(id);
    }
}
