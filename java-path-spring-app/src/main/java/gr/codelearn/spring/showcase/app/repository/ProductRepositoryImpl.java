package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository {
	List<Product> productStorage = new ArrayList<>();

	@Override
	public Product create(final Product product) {
		productStorage.add(product);
		return product;
	}

	@Override
	public List<Product> createAll(final List<Product> products) {
		productStorage.addAll(products);
		return products;
	}

	@Override
	public List<Product> createAll(final Product... products) {
		return createAll(Arrays.asList(products));
	}

	@Override
	public void update(final Product product) {
	}

	@Override
	public void delete(final Product product) {
		productStorage.remove(product);
	}

	@Override
	public void deleteById(final String serial) {
	}

	@Override
	public List<Product> findAll() {
		return productStorage;
	}

	@Override
	public boolean exists(final Product product) {
		return false;
	}

	@Override
	public Product find(final Long id) {
		return null;
	}
}
