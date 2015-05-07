package contacts.manager.app.controllers;

import contacts.manager.app.dto.ContactDTO;
import contacts.manager.app.model.Contact;
import contacts.manager.app.model.PagedResultList;
import contacts.manager.app.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.security.Principal;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/contact")
public class ContactController {

	private static final String DEFAULT_PAGE = "1";

	@Autowired
	private ContactService contactService;

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET)
	public PagedResultList<ContactDTO> getContacts(
			Principal principal,
			@RequestParam(value = "pageNumber", required = false, defaultValue = DEFAULT_PAGE) Integer pageNumber) {
		Page<Contact> contacts = contactService.findByName("",1, 10);
		return contactService.findContacts(principal.getName(), pageNumber);
	}
}
