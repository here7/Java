package com.heredh7.lab.controllers;

//import com.heredh7.lab.database.DbPreloadStatement;
import com.heredh7.lab.entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
  //  DbPreloadStatement datab = new DbPreloadStatement();
    @RequestMapping("/")
    public String list(Model model){
        model.addAttribute("productName","My Custom Page Title");
        model.addAttribute("products",createProducts());
        return "views/product-list";
    }


    /**
     * View Single product
     */
    @RequestMapping("{id}/")
    public String product(Model model, @PathVariable Integer id){
        //model.addAttribute("productName","My Custom Page Title");
        model.addAttribute("productId",id);
        model.addAttribute("productName",getProduct(id).getName());
        model.addAttribute("productDescription",getProduct(id).getDescription());
        model.addAttribute("productPrice",getProduct(id).getPrice());
        model.addAttribute("productImage",getProduct(id).getImage());
        return "views/product";
    }


    /**
     * Single Product
     * @param idProduct
     * @return
     */
    public Product getProduct(Integer idProduct){

        Product product= new Product();
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/heredh7_sl?autoReconnect=true&useSSL=false","user_test_here7","password");
            Statement stm = con.createStatement();
            stm = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE); //I get it 2 variables to can to do UPDATES in the table


            // Method 1 to move through results ( Lineal Method => with next() )
            ResultSet result = stm.executeQuery("SELECT * FROM SL_PRODUCT WHERE id = " + idProduct);

            while(result.next()){
                if(result.wasNull()){
                    System.out.println(" RESULT without expedient...");
                } else{
                    product.setId(result.getInt("id"));
                    product.setName(result.getString("name"));
                    product.setDescription(result.getString("description"));
                    product.setImage(result.getString("image"));
                    product.setPrice(result.getDouble("price"));
                }
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }


    private List<Product> createProducts(){
        List<Product> products = new ArrayList<Product>();

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
                    Product product = new Product();
                    product.setId(result.getInt("id"));
                    product.setName(result.getString("name"));
                    product.setDescription(result.getString("description"));
                    product.setImage(result.getString("image"));
                    product.setPrice(result.getDouble("price"));
                    products.add(product);
                }
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
}
