package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Product;

import java.util.List;

public interface ProductService {
	Product create(Product product);

	List<Product> createAll(List<Product> products);

	List<Product> createAll(Product... products);

	void update(Product product);

	void delete(Product product);

	void deleteById(String serial);

	boolean exists(Product product);

	Product find(final Long id);

	List<Product> findAll();

}
