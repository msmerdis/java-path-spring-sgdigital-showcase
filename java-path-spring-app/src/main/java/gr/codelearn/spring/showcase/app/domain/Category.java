package gr.codelearn.spring.showcase.app.domain;

import lombok.Builder;
import lombok.Data;

/**
 * This class represents a category in which products are organized.
 */
@Data
@Builder
public class Category {
	private String description;
}
