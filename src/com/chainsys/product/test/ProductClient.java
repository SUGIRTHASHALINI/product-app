package com.chainsys.product.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.chainsys.product.exception.ProductNotFoundException;
import com.chainsys.product.model.Product;
import com.chainsys.product.service.ProductService;
import com.chainsys.product.service.ProductServiceImpl;

public class ProductClient {
	public static void main(String[] args) {

		Set<Product> productSet;
		List<String> namelist;
		List<Integer> idlist;
		ProductService service = new ProductServiceImpl();
		String date;
		DateTimeFormatter dateFormat;
		int id;
		System.out.println("Enter the choice");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Find All Products");
			productSet = service.findAll();
			System.out.println(productSet);
			break;
		case 2:
			System.out.println("Find the Product By Id");
			System.out.println("Enter the Product Id");
			id = scanner.nextInt();
			try {
				Product product = service.findById(id);
				System.out.println(product);
			} catch (ProductNotFoundException e) {
			}
			break;
		case 3:
			System.out.println("Update the Product Name Based on the Id");
			date = "06/05/2019";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Product updateProduct = new Product(1, "pencil", LocalDate.parse(date, dateFormat));
			try {
				service.update(updateProduct);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {

			}
			break;
		case 4:
			System.out.println("Adding a Product");
			date = "06/05/2019";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Product newProduct = new Product(4, "Pencil", LocalDate.parse(date, dateFormat));
			service.save(newProduct);
			productSet = service.findAll();
			System.out.println(productSet);
			break;
		case 5:
			System.out.println("Deleting a Product");
			System.out.println("Enter the Product Id");
			id = scanner.nextInt();
			try {
				service.delete(id);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {
			}
		case 6:
			System.out.println("Find the Product By Name");
			System.out.println("Enter the Product Name");
			String name = scanner.next();
			try {
				Product product = service.findByName(name);
				System.out.println(product);
			} catch (ProductNotFoundException e) {
			}
			break;
			
		case 7:
			System.out.println("Update the Product Expiry Date Based on the Id");
			System.out.println("Enter the Product Id");
			id = scanner.nextInt();
			date = "06/05/2021";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			updateProduct = new Product(id, "pencil", LocalDate.parse(date, dateFormat));
			try {
				service.update_expire(updateProduct);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {

			}
			break;
			
		case 8:
			System.out.println("Deleting a Product");
			try {
				 	date = "06/05/2019";
					dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
					service.delete_date(LocalDate.parse(date,dateFormat));
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {
			}
			
		case 9:
			System.out.println("Deleting a Product");
			System.out.println("Enter the Product name");
			name = scanner.next();
			try {
				service.delete_name(name);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {
			}
		case 10:
			System.out.println("Find the Product By Date");
			try {
			 	date = "03/01/2023";
				dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				Product product=service.findByDate(LocalDate.parse(date,dateFormat));
				System.out.println(product);
			} catch (ProductNotFoundException e) {
			}
			break;
		case 11:
			System.out.println("Find All Products Names");
			namelist = service.findAllName();
			System.out.println(namelist);
			break;
		case 12:
			System.out.println("Find All Product Id");
			idlist = service.findAllId();
			System.out.println(idlist);
			break;
			
		default:
			break;
		}
		scanner.close();
	}

}
