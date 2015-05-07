package contacts.manager.app.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import contacts.manager.app.model.Contact;

public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {
}
