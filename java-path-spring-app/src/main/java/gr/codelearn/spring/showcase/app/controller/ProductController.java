package gr.codelearn.spring.showcase.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import gr.codelearn.spring.showcase.app.domain.Product;
import gr.codelearn.spring.showcase.app.service.BaseService;
import gr.codelearn.spring.showcase.app.service.ProductService;
import gr.codelearn.spring.showcase.app.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController extends AbstractController<Product> {
	private final ProductService productService;

	@Override
	public BaseService<Product, Long> getBaseService() {
		return productService;
	}

	@GetMapping("/filteredProducts")
	public ResponseEntity<ApiResponse<JsonNode>> findFiltered() {
		List<Product> all = productService.findAll();
		Product product = all.get(0);
		JsonNode jsonNode = filteredProducts(product, "category");
		return ResponseEntity.ok(ApiResponse.<JsonNode>builder().data(jsonNode).build());
	}

	private JsonNode filteredProducts(Product product, String... ignorableFieldNames){
		/*
		 * Method that filters a given product and returns it based on what attributes we have chosen to exclude
		 * This may be considered a way of dynamic filtering without setting a "global filter" in a product
		 * configuration
		 */
		SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider().setFailOnUnknownId(false);
		FilterProvider filters = simpleFilterProvider.addFilter("product_filter", SimpleBeanPropertyFilter
				.serializeAllExcept(ignorableFieldNames));
		// Local object mapper that will convert our product to a string based on the given filter
		ObjectMapper mapper = new ObjectMapper();
		mapper.setFilterProvider(filters);
		ObjectWriter writer = mapper.writer();
		try {
			// Converting to json string to filter out attributes we have excluded
			String jsonString = writer.writeValueAsString(product);
			return mapper.readTree(jsonString);
		} catch (JsonProcessingException e) {
			// Will be caught by the exception handler which handles generic exceptions
			throw new RuntimeException("Json processing has failed");
		}
	}
}
