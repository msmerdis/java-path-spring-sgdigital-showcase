package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Product;

import java.util.List;

public interface ProductRepository {
	Product create(Product product);

	List<Product> createAll(List<Product> product);

	List<Product> createAll(Product... product);

	void update(Product product);

	void delete(Product product);

	void deleteById(String serial);

	boolean exists(Product product);

	Product find(final Long id);

	List<Product> findAll();
}
