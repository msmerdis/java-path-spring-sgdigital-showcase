package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Product;

import java.util.List;

public interface ProductService {
	void create(Product product);
	void delete(Product product);
	void deleteById(String serial);
	Product find();
	List<Product> findAll();
	boolean exists(Product product);
}
