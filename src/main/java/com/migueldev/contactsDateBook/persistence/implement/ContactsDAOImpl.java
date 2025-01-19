package com.migueldev.contactsDateBook.persistence.implement;

import com.migueldev.contactsDateBook.entities.Contacts;
import com.migueldev.contactsDateBook.persistence.IContactsDAO;
import com.migueldev.contactsDateBook.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ContactsDAOImpl implements IContactsDAO {

    @Autowired
    private ContactsRepository contactsRepository;

    @Override
    public List<Contacts> findAll() {
        return contactsRepository.findAll();
    }

    @Override
    public Contacts save(Contacts contacts) {
        return contactsRepository.save(contacts);
    }

    @Override
    public Optional<Contacts> findById(Integer id) {
        return contactsRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        contactsRepository.deleteById(id);
    }
}
