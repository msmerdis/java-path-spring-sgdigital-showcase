package gr.codelearn.spring.showcase.app.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * This class represents a product for sale.
 */
@Data
@Builder
public class Product {
	private String serial;
	private String name;
	private BigDecimal price;
	private Category category;
}
