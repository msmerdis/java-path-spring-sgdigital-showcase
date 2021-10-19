package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryRepositoryImpl extends AbstractRepository<Category> implements CategoryRepository {
	List<Category> categoryStorage = new ArrayList<>();

	@Override
	public List<Category> getStorage() {
		return categoryStorage;
	}
}
