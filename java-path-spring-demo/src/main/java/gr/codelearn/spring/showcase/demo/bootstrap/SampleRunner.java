package gr.codelearn.spring.showcase.demo.bootstrap;

import gr.codelearn.spring.showcase.demo.base.AbstractLogComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Bootstrap class demonstrating the property retrieval from two distinctive sources. It runs only once during
 * application initialization.
 */
@Component
@Profile("demo-property-injection")
public class SampleRunner extends AbstractLogComponent implements CommandLineRunner {
	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${custom.property}")
	private String customProperty;

	@Override
	public void run(final String... args) {
		logger.info("Application named '{}' has a custom property having the value of '{}'.", applicationName,
					customProperty);
	}
}
