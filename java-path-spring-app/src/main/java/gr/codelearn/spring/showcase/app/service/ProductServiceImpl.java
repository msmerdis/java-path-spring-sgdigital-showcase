package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Product;
import gr.codelearn.spring.showcase.app.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
	final ProductRepository productRepository;

	@Override
	public void create(final Product product) {
		productRepository.create(product);
	}

	@Override
	public void delete(final Product product) {
		productRepository.delete(product);
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
		return productRepository.findAll();
	}

	@Override
	public boolean exists(final Product product) {
		return false;
	}
}
