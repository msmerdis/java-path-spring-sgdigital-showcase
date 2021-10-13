package gr.codelearn.spring.showcase.demo.component;

import gr.codelearn.spring.showcase.demo.base.AbstractLogComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Simple class representing bean depending on another bean.
 */
@Component
@RequiredArgsConstructor
public class DependentBean extends AbstractLogComponent {
	@Value("${sample.property:0}")
	private int sampleProperty;

	private final IndependentBean independentBean;

	@PostConstruct
	public void sayHello() {
		// Code that will be executed after the initialization of the bean
		logger.info("Hello, I am a dependent bean with a sample value of {}.", sampleProperty);
	}

	public String getSampleText() {
		return "This is a sample text.";
	}

	@PreDestroy
	public void sayBye() {
		// Code that will be executed before the bean is destroyed
		logger.info("Bye bye, I used to be a dependent bean.");
	}
}
