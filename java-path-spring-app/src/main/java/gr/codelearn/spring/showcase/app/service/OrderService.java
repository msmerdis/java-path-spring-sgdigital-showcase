package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Customer;
import gr.codelearn.spring.showcase.app.domain.Order;
import gr.codelearn.spring.showcase.app.domain.PaymentMethod;
import gr.codelearn.spring.showcase.app.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService extends BaseService<Order, Long> {
	Order initiateOrder(Customer customer);

	void addItem(Order Order, Product product, int quantity);

	void updateItem(Order order, Product product, int quantity);

	void removeItem(Order order, Product product);

	boolean containsItem (Order order, Product product);

	Order checkout(Order order, PaymentMethod paymentMethod);

	List<Order> filterByProduct(List<Order> orders, Product product);
	List<Order> filterByMinimumCost(List<Order> orders, BigDecimal cost);
}
