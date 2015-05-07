package contacts.manager.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import contacts.manager.app.dao.ContactRepository;
import contacts.manager.app.dto.ContactDTO;
import contacts.manager.app.model.Contact;
import contacts.manager.app.model.PagedResultList;

@Service
public class ContactService {

	private static final int PAGE_SIZE = 10;
	@Autowired
	private ContactRepository contactRepository;

	@Transactional(readOnly = true)
	public PagedResultList<ContactDTO> findContacts(String name, Integer pageNumber) {
		//List<ContactDTO> result = contactRepository.searchContacts(name, pageNumber);
		return null;
	}

	@Transactional(readOnly = true)
	public Page<Contact> getContacts(Integer pageNumber) {
		PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "firstName");
		return contactRepository.findAll(request);
	}

	public Page<Contact> findByName(String name, int page, int size) {
		return contactRepository.findByFirstNameOrLastName(name, name, new PageRequest(page - 1, PAGE_SIZE, Sort.Direction.DESC, "firstName"));
	}
}
