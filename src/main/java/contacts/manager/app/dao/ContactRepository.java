package contacts.manager.app.dao;

import contacts.manager.app.dto.ContactDTO;
import contacts.manager.app.model.PagedResultList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import contacts.manager.app.model.Contact;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {

	Page<Contact> findAll(Pageable pageable);
	Page<Contact> findByFirstNameOrLastName(String firstName, String lastName, Pageable pageable);
}
