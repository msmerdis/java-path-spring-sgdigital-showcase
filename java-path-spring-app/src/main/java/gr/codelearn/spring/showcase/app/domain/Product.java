package gr.codelearn.spring.showcase.app.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * This class represents a product for sale.
 */
@Data
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@JsonFilter("product_filter")
public class Product extends BaseEntity {
	private String serial;
	private String name;
	@JsonIgnore
	private BigDecimal price;
	private Category category;
}
