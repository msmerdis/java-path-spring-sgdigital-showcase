package gr.codelearn.spring.showcase.app.domain;

import lombok.Builder;
import lombok.Data;

/**
 * This class represents a customer to our eshop system.
 */
@Data
@Builder
public class Customer {
	private String email;
	private String firstname;
	private String lastname;
	private Integer age;
	private String address;
	private CustomerCategory customerCategory;
}
