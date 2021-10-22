package gr.codelearn.spring.showcase.app.transfer.demo;

import gr.codelearn.spring.showcase.app.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductForm {
	@NotNull
	private String serial;
	@NotNull
	private String name;
	@Positive(message = "Only positive numbers are accepted.")
	private BigDecimal price;
	@NotNull
	private String category;
}
