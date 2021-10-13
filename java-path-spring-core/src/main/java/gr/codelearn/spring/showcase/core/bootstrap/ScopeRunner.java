package gr.codelearn.spring.showcase.core.bootstrap;

import gr.codelearn.spring.showcase.core.base.AbstractLogComponent;
import gr.codelearn.spring.showcase.core.component.Prototype;
import gr.codelearn.spring.showcase.core.component.Singleton;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("demo-scope")
@RequiredArgsConstructor
public class ScopeRunner extends AbstractLogComponent implements ApplicationRunner {
	private final ApplicationContext container;

	@Override
	public void run(final ApplicationArguments args) throws Exception {
		logger.info("Fetching singleton bean...");
		var singleton1 = container.getBean(Singleton.class);
		singleton1.increaseValueByOne();
		var singleton2 = container.getBean(Singleton.class);
		singleton2.increaseValueByOne();
		var singleton3 = container.getBean(Singleton.class);
		singleton3.increaseValueByOne();

		logger.info("Fetching prototype bean...");
		var prototype1 = container.getBean(Prototype.class);
		prototype1.increaseValueByOne();
		var prototype2 = container.getBean(Prototype.class);
		prototype2.increaseValueByOne();
		var prototype3 = container.getBean(Prototype.class);
		prototype3.increaseValueByOne();
	}
}
