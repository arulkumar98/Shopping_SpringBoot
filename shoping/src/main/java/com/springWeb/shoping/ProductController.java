package com.springWeb.shoping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

//    @Autowired
    ProjectService projectService;

    // consturction injuction
//    public ProductController(ProjectService service){
//        this.service = service;
//    }
//
    // setter Injuction
    @Autowired
    public void setProjectService(ProjectService projectService){
        this.projectService = projectService;
    }

    //GET
    @GetMapping("/products")
    public List<Product> getProduct(){
        return projectService.getProducts();
    }

    @GetMapping("/products/{proId}")
    public Product getProductById(@PathVariable int proId){
        return projectService.getProductById(proId);
    }

    //POST
    @PostMapping("/products/add")
    public String addProduct(@RequestBody  Product pro){
        return projectService.addProduct(pro);
    }


    //UPDATE
    @PutMapping("product/update")
    public ResponseEntity<String> updateProduct(@RequestBody Product pro){
         if (projectService.updateProduct(pro)){
             return ResponseEntity.ok("Product updated");
         } else {
             return ResponseEntity.status(404).body("Product not found");
         }
    }


    //DELETE
    @DeleteMapping("product/delete/{proId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int proId){
        if (projectService.deleteProduct(proId)){
            return ResponseEntity.ok("Product updated");
        } else {
            return ResponseEntity.status(404).body("Product not found");
        }
    }





}
