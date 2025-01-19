package com.migueldev.contactsDateBook.service.implement;

import com.migueldev.contactsDateBook.entities.Contacts;
import com.migueldev.contactsDateBook.persistence.IContactsDAO;
import com.migueldev.contactsDateBook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private IContactsDAO iContactsDAO;

    @Override
    public List<Contacts> findAll() {
        return iContactsDAO.findAll();
    }

    @Override
    public Contacts save(Contacts contacts) {
        return iContactsDAO.save(contacts);
    }

    @Override
    public Optional<Contacts> findById(Integer id) {
        return iContactsDAO.findById(id);
    }

    @Override
    public void delete(Integer id) {
        iContactsDAO.delete(id);
    }
}
