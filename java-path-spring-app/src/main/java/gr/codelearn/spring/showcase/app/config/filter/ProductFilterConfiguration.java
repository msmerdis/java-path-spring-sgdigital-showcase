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

@Configuration
// global configuration
public class ProductFilterConfiguration {
	private static final Set<String> ignorableFieldNames = new HashSet<>();

	static {
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
