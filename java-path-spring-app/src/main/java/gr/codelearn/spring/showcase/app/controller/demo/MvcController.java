package gr.codelearn.spring.showcase.app.controller.demo;

import gr.codelearn.spring.showcase.app.domain.Category;
import gr.codelearn.spring.showcase.app.domain.Product;
import gr.codelearn.spring.showcase.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mvc")
public class MvcController {

	final ProductService productService;

	@GetMapping
	public String index(Model model){
		Category category = Category.builder().description("Food").build();
		Product product = Product.builder().name("Tomatoes").category(category).price(BigDecimal.ONE).serial("AA110").build();
		model.addAttribute("name", "Ioannis");
		model.addAttribute("product", product);
		return "hello";
	}

	@GetMapping("/redirect")
	public String redirectionExample(){
		return "redirect:/mvc";
	}

	@GetMapping("/allProducts")
	public String findAllProduct(Model model){
		List<Product> allProducts = productService.findAll();
		model.addAttribute("products", allProducts);
		return "allProducts";
	}
}
