package gr.codelearn.spring.showcase.app.bootstrap;

import gr.codelearn.spring.showcase.app.base.AbstractLogComponent;
import gr.codelearn.spring.showcase.app.domain.Customer;
import gr.codelearn.spring.showcase.app.domain.CustomerCategory;
import gr.codelearn.spring.showcase.app.domain.Order;
import gr.codelearn.spring.showcase.app.service.CustomerService;
import gr.codelearn.spring.showcase.app.service.OrderService;
import gr.codelearn.spring.showcase.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("generate-content")
@RequiredArgsConstructor
public class GenerateContentRunner extends AbstractLogComponent implements CommandLineRunner {
	private final CustomerService customerService;
	private final OrderService orderService;
	private final ProductService productService;

	@Override
	public void run(String... args) {
		//@formatter:off
	List<Customer> customers = customerService.createAll(
			Customer.builder().email("c.giannacoulis@codehub.gr")
					.firstname("Constantinos").lastname("Giannacoulis")
					.address("3583 Tennessee Avenue")
					.customerCategory(CustomerCategory.INDIVIDUAL).age(47).build(),
			Customer.builder().email("john.porter@gmail.com")
					.firstname("John").lastname("Porter")
					.address("2955 Blackwell Street")
					.customerCategory(CustomerCategory.BUSINESS).age(40).build(),
			Customer.builder().email("malcolm.paker@gmail.com")
					.firstname("Malcolm").lastname("Parker")
					.address("4071 Kelly Drive")
					.customerCategory(CustomerCategory.GOVERNMENT).age(32).build(),
			Customer.builder().email("terry.jones@gmail.com")
					.firstname("Terry").lastname("Jones")
					.address("3849 Hinkle Lake Road")
					.customerCategory(CustomerCategory.BUSINESS).age(57).build(),
			Customer.builder().email("peter.mercury@outlook.com")
					.firstname("Peter").lastname("Mercury")
					.address("Freddie Street 28th")
					.customerCategory(CustomerCategory.INDIVIDUAL).age(32).build(),
			Customer.builder().email("magdalene.ferguson@gmail.com")
					.firstname("Magdalene").lastname("Ferguson")
					.address("Jelly Avenue 73")
					.customerCategory(CustomerCategory.INDIVIDUAL).age(32).build(),
			Customer.builder().email("jones.pirves@gmail.com")
					.firstname("Jones").lastname("Pirves")
					.address("3rd Mountain Hike, 3")
					.customerCategory(CustomerCategory.INDIVIDUAL).age(32).build(),
			Customer.builder().email("michael.anderson@gmail.com")
					.firstname("Michael").lastname("Anderson")
					.address("Hollywood Street 63")
					.customerCategory(CustomerCategory.BUSINESS).age(32).build(),
			Customer.builder().email("yennefer.lawrance@windowslive.com")
					.firstname("Yennefer").lastname("Lawrance")
					.address("Rivia 43")
					.customerCategory(CustomerCategory.BUSINESS).age(32).build(),
			Customer.builder().email("mary.ferry@windowslive.com")
					.firstname("Mary").lastname("Ferry")
					.address("Downtown 17, California")
					.customerCategory(CustomerCategory.GOVERNMENT).age(32).build());
			//@formatter:on

		logger.info("{} customers created.", customers.size());

		// Get all customers
		customerService.findAll().forEach(c -> logger.info("{}", c));

		// We don't mind if a "find" method returns a null
		logger.info("Does customer exist? {}.", (customerService.findByEmail("c.giannacoulis@codehub.gr") != null));
		logger.info("Does customer exist? {}.", (customerService.findByEmail("non-existing@gmail.com") != null));

		// Load customer and create an order by adding/updating/removing content before checking it out
		Customer firstCustomer = customerService.findByEmail("c.giannacoulis@codehub.gr");
		Order firstOrder = orderService.initiateOrder(firstCustomer);

		/*
		// Add item(s) both existing and non-existing
		orderService.addItem(firstOrder, productService.findBySerial("SN1000-0001"), 2);
		orderService.addItem(firstOrder, productService.findBySerial("SN1100-0001"), 1);
		orderService.addItem(firstOrder, productService.findBySerial("SN1000-0004"), 1);
		orderService.addItem(firstOrder, productService.findBySerial("SN1000-0008"), 1);
		// Update item(s)
		orderService.addItem(firstOrder, productService.findBySerial("SN1000-0001"), 1);
		orderService.updateItem(firstOrder, productService.findBySerial("SN1000-0004"), 2);
		// Remove item(s)
		orderService.removeItem(firstOrder, productService.findBySerial("SN1100-0001"));
		// Add some more item(s)
		orderService.addItem(firstOrder, productService.findBySerial("SN1300-0001"), 2);
		// Checkout order
		orderService.checkout(firstOrder, PaymentMethod.CREDIT_CARD);

		// Second customer and order
		Customer secondCustomer = customerService.find(2L);
		Order secondOrder = orderService.initiateOrder(secondCustomer);
		// Add item(s) to second order
		orderService.addItem(secondOrder, productService.findBySerial("SN1000-0002"), 1);
		orderService.addItem(secondOrder, productService.findBySerial("SN1200-0001"), 1);
		orderService.addItem(secondOrder, productService.findBySerial("SN1200-0001"), 1);
		orderService.addItem(secondOrder, productService.findBySerial("SN1299-0001"), 1);
		// Checkout 2nd order
		orderService.checkout(secondOrder, PaymentMethod.WIRE_TRANSFER);

		// Third customer and order
		Customer thirdCustomer = customerService.findByEmail("malcolm.paker@gmail.com");
		Order thirdOrder = orderService.initiateOrder(thirdCustomer);
		orderService.addItem(thirdOrder, productService.findBySerial("SN1000-0001"), 3);
		orderService.addItem(thirdOrder, productService.findBySerial("SN1000-0002"), 2);
		orderService.addItem(thirdOrder, productService.findBySerial("SN1000-0003"), 1);
		// Checkout 3rd order
		orderService.checkout(thirdOrder, PaymentMethod.CREDIT_CARD);

		// Fourth customer and order
		Customer fourthCustomer = customerService.findByEmail("terry.jones@gmail.com");
		Order fourthOrder = orderService.initiateOrder(fourthCustomer);
		orderService.addItem(fourthOrder, productService.findBySerial("SN1300-0001"), 1);
		orderService.addItem(fourthOrder, productService.findBySerial("SN1400-0001"), 2);
		orderService.addItem(fourthOrder, productService.findBySerial("SN1500-0001"), 1);
		orderService.addItem(fourthOrder, productService.findBySerial("SN1000-0003"), 1);
		orderService.addItem(fourthOrder, productService.findBySerial("SN1000-0004"), 1);
		// Checkout 4th order
		orderService.checkout(fourthOrder, PaymentMethod.CREDIT_CARD);
		*/
	}
}
