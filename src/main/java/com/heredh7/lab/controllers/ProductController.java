package com.heredh7.lab.controllers;

import com.heredh7.lab.entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import java.util.ArrayList;

@Controller
@RequestMapping("/products")
public class ProductController {

    @RequestMapping("/")
    public String list(Model model){
        model.addAttribute("productName","My Custom Page Title");
        model.addAttribute("products",createProducts());
        return "views/list";
    }


    private ArrayList<Product> createProducts(){
        ArrayList<Product> products = new ArrayList<Product>();


        Product product1= new Product();
        product1.setId(1);
        product1.setName("Detergente Ariel");
        product1.setDescription("Detergente más económico del mercado");
        product1.setPrice(2.36);
        products.add(product1);

        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Detergente Tide");
        product2.setDescription("Detergente más concentrado del mercado");
        product2.setPrice(3.13);
        products.add(product2);


        return products;
    }

    /*
    private String getPostBody(){
        String body = "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ac finibus mi. Morbi porttitor urna dui, sed volutpat justo rutrum sit amet. Etiam elementum lacus eget malesuada egestas. Sed id lectus arcu. Pellentesque molestie dignissim diam non commodo. Nunc nec aliquet lectus. Ut a accumsan sapien. Pellentesque sit amet sem nisl. Nulla fringilla vulputate mauris, eleifend dapibus libero. Sed eu cursus orci. In hac habitasse platea dictumst. Vestibulum vel vulputate ex. Nam gravida blandit nisl, at luctus mi interdum ut. Pellentesque et pharetra mi. Proin id placerat diam. Ut porttitor risus in leo tincidunt, a iaculis velit maximus.</p>";
        return body;
    }*/

}
