package com.chainsys.product.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.chainsys.product.model.Product;

public interface ProductDAO {
	
	Set<Product> findAll();

	Product findById(int id);
	
	List<String> findAllName();

	void save(Product product);

	void update(Product product);

	void delete(int id);
	
	Product findByName(String name);
	
	Product findByDate(LocalDate expiryDate);
	
	void update_expire(Product product);
	
	void delete_date(LocalDate expiryDate);
	
	void delete_name(String name);
}
