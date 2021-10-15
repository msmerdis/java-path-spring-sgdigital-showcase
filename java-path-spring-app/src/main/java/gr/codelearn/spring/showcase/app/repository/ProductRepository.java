package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Product;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ProductRepository {
	void create(Product product);
	void delete(Product product);
	void deleteById(String serial);
	Product find();
	List<Product> findAll();
	boolean exists(Product product);
}
