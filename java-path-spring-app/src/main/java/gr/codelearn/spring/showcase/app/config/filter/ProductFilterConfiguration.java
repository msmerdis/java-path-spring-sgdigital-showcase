package gr.codelearn.spring.showcase.app.config.filter;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.util.HashSet;
import java.util.Set;

/**
 * Configuration class that allows us to customize the ObjectMapper built by Jackson2ObjectMapperBuilder. This means
 * that we can filter products globally or set a default filtering mechanism. A default mechanism is used when we also
 * use our own custom object mapper (see the filteredProducts(...) method in the ProductController) For a
 * better understanding, see the following links:
 * How to customize Jackson object mapper: https://www.baeldung .com/spring-boot-customize-jackson-objectmapper,
 * All the message converters Spring includes: https://www.baeldung.com/spring-httpmessageconverter-rest
 */
@Configuration
// global configuration
public class ProductFilterConfiguration {
	private static final Set<String> ignorableFieldNames = new HashSet<>();

	static {
		/*
		Setting the fields that will be ignored when products are returned in a response.
		If we want the full product to be returned in a response, then we should not add any fields.
		If we want to choose between showing the full product or a filtered product, we can set
		the default mechanism (described here) to include no filtered fields, and then use a custom object mapper as
		already described in the javadoc of this class.
		 */
		//ignorableFieldNames.add("serial");
		//ignorableFieldNames.add("name");
	}

	@Bean
	public Jackson2ObjectMapperBuilderCustomizer productFilterCustomer(){
		SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider().setFailOnUnknownId(false);
		FilterProvider filters = simpleFilterProvider.addFilter("product_filter", SimpleBeanPropertyFilter
				.serializeAllExcept(ignorableFieldNames));
		// We can also add automatic filters such as not showing nulls etc.
		//.serializationInclusion(JsonInclude.Include.NON_NULL)
		Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer = builder -> builder.filters(filters);
		return jackson2ObjectMapperBuilderCustomizer;
	}
}
