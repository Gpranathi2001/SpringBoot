package com.jsp.ShoppingCart.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.jsp.ShoppingCart.DTO.Product;
import com.jsp.ShoppingCart.REPOSITORY.ProductRepository;

@Repository
public class ProductDao 
{
	@Autowired
	ProductRepository respository;
	
	public String addProduct(Product product)
	{
		respository.save(product);
		return "product is added to cart successfully";
	}
	
	//to fetch all objects data base
	public List<Product> getAllProducts()
	{
		return respository.findAll();
		 
	}
	
	//to fetch one object based on ID
	public Product findProductById(int id)
	{
		Optional<Product> o= respository.findById(id);
		if(o.isPresent())
		{
			return o.get();
		}
		return null;
	}
	
	
	//to delete an object from the DB
	public String deleteProduct(int id)
	{
		Product p=findProductById(id);
		if(p!=null)
		{
			String productname= p.getProduct_name();
			respository.delete(p); // respository.deleteById(id);
			return productname+"product was removed from cart";
			
		}
		return "product not available in cart";
	}

	
	//to update quality of a product based on id
	public Product updateQuantity(int id,int newQuantity)
	{
		Product p=findProductById(id);
		if(p!=null)
		{
			p.setQuantity(newQuantity);
			respository.save(p);
			return p;
		}
		return null;
	}
	
	
	
	
//	public List<Product> getByName(String name)
//	{
//		return respository.getByName(name);
//	}
}
