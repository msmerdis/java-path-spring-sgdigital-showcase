package gr.codelearn.spring.showcase.app.controller;

import gr.codelearn.spring.showcase.app.domain.Product;
import gr.codelearn.spring.showcase.app.service.ProductService;
import gr.codelearn.spring.showcase.app.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;

	@GetMapping()
	public ResponseEntity<ApiResponse<List<Product>>> findAll() {
		return ResponseEntity.ok(ApiResponse.<List<Product>>builder().data(productService.findAll()).build());
	}
}
