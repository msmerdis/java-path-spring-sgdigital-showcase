package gr.codelearn.spring.showcase.core.controller;

import gr.codelearn.spring.showcase.core.base.AbstractLogComponent;
import gr.codelearn.spring.showcase.core.component.DependentBean;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SampleController extends AbstractLogComponent {
	private final DependentBean dependentBean;

	@GetMapping("/")
	public String sayHello() {
		return "Hello from our sample Spring Boot. " + dependentBean.getSampleText();
	}
}
