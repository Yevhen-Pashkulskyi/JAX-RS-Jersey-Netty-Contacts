package org.example.app.service.impl;

import org.example.app.domain.contact.Contact;
import org.example.app.repository.impl.ContactRepository;
import org.example.app.service.AppService;

import java.util.Collections;
import java.util.List;

public class ContactService implements AppService<Contact> {

    ContactRepository repository = new ContactRepository();

    public Contact create(Contact contact) {
        repository.create(contact);
        return repository.getLastEntity()
                .orElse(null);
    }

    public List<Contact> fetchAll() {
        return repository.fetchAll()
                .orElse(Collections.emptyList());
    }

    public Contact fetchById(Long id) {
        return repository.fetchById(id).orElse(null);
    }

    public Contact update(Long id, Contact contact) {
        if (repository.fetchById(id).isPresent()) {
            repository.update(id, contact);
        }
        return repository.fetchById(id).orElse(null);
    }
/*    public Contact update(Long id, Contact contact) {
        if (repository.fetchById(id).isPresent()) {
            // Update specific fields only if the contact exists
            Contact existingContact = repository.fetchById(id).get();
            existingContact.setName(contact.getName()); // Update name
            // Update other fields as needed (e.g., phone)
            repository.update(id, existingContact);
            return repository.fetchById(id).orElse(null);
        } else {
            return null; // Indicate contact not found
        }
    }*/


    public boolean delete(Long id) {
        if (repository.isIdExists(id)) {
            repository.delete(id);
            return true;
        } else return false;
    }

    public List<Contact> fetchByFirstName(String firstName) {
        return repository.fetchByFirstName(firstName)
                .orElse(Collections.emptyList());
    }

    public List<Contact> fetchAllOrderBy(String orderBy) {
        return repository.fetchAllOrderBy(orderBy)
                .orElse(Collections.emptyList());
    }

    public List<Contact> fetchBetweenIds(int from, int to) {
        return repository.fetchBetweenIds(from, to)
                .orElse(Collections.emptyList());
    }
}
