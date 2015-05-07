package contacts.manager.app.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * will store paged results
 */
@AllArgsConstructor
public class PagedResultList<T> {

	@Getter
	private List<T> items;

	@Getter
	private int size;

	@Getter
	private int page;

	@Getter
	private long total;

	@Getter
	public int totalPages;

}
