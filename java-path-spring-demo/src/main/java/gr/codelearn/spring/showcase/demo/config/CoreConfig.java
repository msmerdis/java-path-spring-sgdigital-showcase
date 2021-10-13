package gr.codelearn.spring.showcase.demo.config;

import gr.codelearn.spring.showcase.demo.component.IndependentBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfig {
	@Bean
	public IndependentBean getIndependentBean() {
		return new IndependentBean();
	}
}
