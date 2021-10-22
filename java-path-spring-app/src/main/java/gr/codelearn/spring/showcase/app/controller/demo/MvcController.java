package gr.codelearn.spring.showcase.app.controller.demo;

import gr.codelearn.spring.showcase.app.domain.Category;
import gr.codelearn.spring.showcase.app.domain.Product;
import gr.codelearn.spring.showcase.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mvc")
public class MvcController {

	final ProductService productService;

	@GetMapping
	public String index(Model model) {
		Category category = Category.builder().description("Food").build();
		Product product = Product.builder().name("Tomatoes").category(category).price(BigDecimal.ONE).serial("AA110")
								 .build();
		model.addAttribute("name", "Ioannis");
		model.addAttribute("product", product);
		return "index";
	}

	@GetMapping("/redirect")
	public String redirectionExample() {
		return "redirect:/mvc";
	}

	@GetMapping("/ourProducts")
	public String findAllProduct(Model model) {
		List<Product> allProducts = productService.findAll();
		model.addAttribute("products", allProducts);
		return "ourProducts";
	}

	@GetMapping("/registerProduct")
	public String registerProduct() {
		return "registerProduct";
	}

	@GetMapping("/condition")
	public String condition(Model model) {
		boolean result = true;
		model.addAttribute("result", result);
		Product product = null;
		model.addAttribute("product", product);
		return "demo/condition";
	}

	@GetMapping("/about")
	public String about(HttpServletRequest request, HttpServletResponse response) {
		createCookie(request, response);
		return "about";
	}

	private void createCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie cookie;
		if (request.getCookies() != null) {
			cookie = Arrays.stream(request.getCookies()).filter(c -> c.getName().equals("counter")).findAny()
								  .orElse(new Cookie("counter", "0"));
			int counterValue = Integer.parseInt(cookie.getValue());
			cookie.setValue(String.valueOf(++counterValue));
		} else {
			cookie = new Cookie("counter", "1");
		}
		response.addCookie(cookie);
	}

	@GetMapping("/findYourProduct")
	public String findYourProduct(Model model, @RequestParam(required = false) Integer productIndex) {
		if (productIndex != null) {
			List<Product> allProducts = productService.findAll();
			Product product = allProducts.get(productIndex);
			model.addAttribute("product", product);
		}
		return "findYourProduct";
	}

	@PostMapping("/findYourProduct")
	public String executeFindYourProduct1(Model model, @RequestParam Integer productIndex) {
		List<Product> allProducts = productService.findAll();
		Product product = allProducts.get(productIndex);
		model.addAttribute("product", product);
		return "findYourProduct";
	}

	@GetMapping("/findYourProduct/{index}")
	public String executeFindYourProduct2(Model model, @PathVariable Integer index) {
		List<Product> allProducts = productService.findAll();
		Product product = allProducts.get(index);
		model.addAttribute("product", product);
		return "findYourProduct";
	}
}
