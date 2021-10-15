package gr.codelearn.spring.showcase.app.bootstrap;

import gr.codelearn.spring.showcase.app.domain.Product;
import gr.codelearn.spring.showcase.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class ProductRunner implements CommandLineRunner {
	final ProductService productService;

	@Override
	public void run(final String... args) throws Exception {
		Product product1 = Product.builder().name("Tomatoes").price(BigDecimal.ONE).build();
		Product product2 = Product.builder().name("Potatoes").price(BigDecimal.TEN).build();
		Product product3 = Product.builder().name("Cabbage").price(BigDecimal.valueOf(2)).build();
		Product product4 = Product.builder().name("Carrots").price(BigDecimal.valueOf(15)).build();
		Product product5 = Product.builder().name("Vegan Meat").price(BigDecimal.valueOf(20)).build();

		productService.create(product1);
		productService.create(product2);
		productService.create(product3);
		productService.create(product4);
		productService.create(product5);
	}
}
