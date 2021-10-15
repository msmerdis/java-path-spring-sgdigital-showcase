package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService{
	List<Product> products = new ArrayList<>();

	@Override
	public void create(final Product product) {
		products.add(product);
	}

	@Override
	public void delete(final Product product) {
		products.remove(product);
	}

	@Override
	public void deleteById(final String serial) {

	}

	@Override
	public Product find() {
		return null;
	}

	@Override
	public List<Product> findAll() {
		return products;
	}

	@Override
	public boolean exists(final Product product) {
		return false;
	}
}
