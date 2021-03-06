package gr.codelearn.spring.showcase.demo.component;

import gr.codelearn.spring.showcase.demo.base.AbstractLogComponent;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Simple class representing bean upon which another beans depend on.
 */
public class IndependentBean extends AbstractLogComponent {
	@PostConstruct
	public void sayHello() {
		// Code that will be executed after the initialization of the bean
		logger.info("Hello, I am an independent bean.");
	}

	@PreDestroy
	public void sayBye() {
		// Code that will be executed before the bean is destroyed
		logger.info("Bye bye, I used to be an independent bean.");
	}
}
