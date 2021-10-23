package gr.codelearn.spring.showcase.app.controller;

import gr.codelearn.spring.showcase.app.domain.Order;
import gr.codelearn.spring.showcase.app.domain.Product;
import gr.codelearn.spring.showcase.app.service.BaseService;
import gr.codelearn.spring.showcase.app.service.OrderService;
import gr.codelearn.spring.showcase.app.service.ProductService;
import gr.codelearn.spring.showcase.app.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController extends AbstractController<Order> {
	private final OrderService orderService;
	private final ProductService productService;

	@Override
	public BaseService<Order, Long> getBaseService() {
		return orderService;
	}

	@GetMapping(value = "", params = "productSerial")
	public ResponseEntity<ApiResponse<List<Order>>> findByProductSerial(@RequestParam("productSerial") final String serial) {
		// convert the serial to a product
		Product product = productService.findBySerial(serial);

		// get the full list orders
		List<Order> orders = orderService.findAll();

		// filter by serial
		orders = orderService.filterByProduct(orders, product);

		// filter orders based on that product and return the list
		return ResponseEntity.ok(ApiResponse.<List<Order>>builder().data(orders).build());
	}

	@GetMapping(value = "", params = "minimumCost")
	public ResponseEntity<ApiResponse<List<Order>>> findByMinimumCost(@RequestParam("minimumCost") final BigDecimal cost) {
		// get the full list orders
		List<Order> orders = orderService.findAll();

		// filter by minimum cost
		orders = orderService.filterByMinimumCost(orders, cost);

		// filter orders based on that product and return the list
		return ResponseEntity.ok(ApiResponse.<List<Order>>builder().data(orders).build());
	}
}