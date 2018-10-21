package com.heredh7.lab.controllers;

import com.heredh7.lab.entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;

import java.sql.*;
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


    /**
     * View Single product
     */
    @RequestMapping(value="/product{id}", method = RequestMethod.GET)
    public String product(Model model, @PathVariable Integer id){
        model.addAttribute("productName","My Custom Page Title");
        model.addAttribute("products",getProduct(id));
        return "views/product";
    }

    /**
     * Single Product
     * @param id product
     * @return
     */
    public Product getProduct(Integer id){

        Product product1= new Product();
        product1.setId(1);
        product1.setName("Detergente HOLA Ariel");
        product1.setDescription("Detergente más económico del mercado");
        product1.setPrice(2.36);

        //return "redirect/
        return product1;
    }


    private ArrayList<Product> createProducts(){
        ArrayList<Product> products = new ArrayList<Product>();

        System.out.println("HELLO WORLD: trying connection from ProductController");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/heredh7_sl?autoReconnect=true&useSSL=false","user_test_here7","password");
            Statement stm = con.createStatement();
            stm = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE); //I get it 2 variables to can to do UPDATES in the table


            // Method 1 to move through results ( Lineal Method => with next() )
            ResultSet result = stm.executeQuery("SELECT * FROM SL_PRODUCT");

            while(result.next()){
                if(result.wasNull()){
                    System.out.println(" RESULT without expedient...");
                } else{
                    System.out.println(" Register PRODUCT -" + result.getInt("id") + "- it's Okay");
                    Product product = new Product();
                    product.setId(result.getInt("id"));
                    product.setName(result.getString("name"));
                    product.setDescription(result.getString("description"));
                    product.setImage(result.getString("image"));
                    product.setPrice(result.getDouble("price"));
                    products.add(product);
                }
                /*System.out.println("=>  ID: "+result.getInt("id") + "; \t" +
                        "USER:" + result.getString("username") +"; \t" +
                        "START DATE: "+result.getDate("start_date"));*/

            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

       /* Product product1= new Product();
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
        products.add(product2);*/


        return products;
    }

    /*
    private String getPostBody(){
        String body = "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ac finibus mi. Morbi porttitor urna dui, sed volutpat justo rutrum sit amet. Etiam elementum lacus eget malesuada egestas. Sed id lectus arcu. Pellentesque molestie dignissim diam non commodo. Nunc nec aliquet lectus. Ut a accumsan sapien. Pellentesque sit amet sem nisl. Nulla fringilla vulputate mauris, eleifend dapibus libero. Sed eu cursus orci. In hac habitasse platea dictumst. Vestibulum vel vulputate ex. Nam gravida blandit nisl, at luctus mi interdum ut. Pellentesque et pharetra mi. Proin id placerat diam. Ut porttitor risus in leo tincidunt, a iaculis velit maximus.</p>";
        return body;
    }*/

}
