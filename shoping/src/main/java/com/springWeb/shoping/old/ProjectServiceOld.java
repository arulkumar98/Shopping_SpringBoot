//package com.springWeb.shoping.repository;
//
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class ProjectServiceOld {
//
//    ProductRepo repo;
//
//    public ProjectServiceOld(ProductRepo repo){
//        this.repo = repo;
//    }
//
//    List<Product> products =new ArrayList<>( Arrays.asList(
//            new Product(101,"iphone 6",1000),
//            new Product(102,"google pixel xl", 50246),
//            new Product(103,"samsung s6", 1000)));
//
//    public List<Product> getProducts(){
//        return products;
//    }
//
//
//    public Product getProductById(int proId) {
//        return products.stream()
//                .filter(i -> i.getProductId() == proId)
//                .findFirst().orElse(new Product(0,"No Item",0));
//    }
//
//    public String addProduct(Product product){
//       if (products.add(product)){
//           return "Product added";
//       }else return "Product added Failed";
//
//    }
//
//    public Boolean updateProduct(Product pro) {
//        int findIndex = findIndex(pro);
//        if (findIndex == -1){
//            return false;
//        }
//        products.set(findIndex,pro);
//        return true;
//    }
//
//
//
//
//
//    private int findIndex(Product pro) {
//        for (int i = 0; i < products.size(); i++) {
//           if (products.get(i).getProductId() == pro.getProductId()){
//               return i;
//           }
//        }
//        return -1;
//    }
//
//    public boolean deleteProduct(int proId) {
//        Product productIndex = findProduct(proId);
//        if (products == null){
//            return false;
//        }
//        products.remove(productIndex);
//        return true;
//    }
//
//    private Product findProduct(int proId) {
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getProductId() == proId){
//                return products.get(i);
//            }
//        }
//        return null;
//    }
//}
