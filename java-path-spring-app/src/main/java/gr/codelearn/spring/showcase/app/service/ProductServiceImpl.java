package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Product;
import gr.codelearn.spring.showcase.app.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	final ProductRepository productRepository;

	@Override
	public Product create(final Product product) {
		return productRepository.create(product);
	}

	@Override
	public List<Product> createAll(final List<Product> products) {
		return null;
	}

	@Override
	public List<Product> createAll(final Product... products) {
		return null;
	}

	@Override
	public void update(final Product product) {

	}

	@Override
	public void delete(final Product product) {
		productRepository.delete(product);
	}

	@Override
	public void deleteById(final String serial) {

	}

	@Override
	public boolean exists(final Product product) {
		return false;
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product find(final Long id) {
		return null;
	}
}
