package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerRepositoryImpl extends AbstractRepository<Customer> implements CustomerRepository {
	List<Customer> customerStorage = new ArrayList<>();

	@Override
	public List<Customer> getStorage() {
		return customerStorage;
	}
}
