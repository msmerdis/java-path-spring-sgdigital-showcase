package gr.codelearn.spring.showcase.app.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * This class represents an order item, a product that is part an order submitted by a customer.
 */
@Data
@Builder
public class OrderItem {
	private Product product;
	private Order order;
	private Integer quantity;
	private BigDecimal price;
}
