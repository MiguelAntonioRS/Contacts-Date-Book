package com.migueldev.contactsDateBook.persistence;

import com.migueldev.contactsDateBook.entities.Contacts;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface IContactsDAO {

    public List<Contacts> findAll();

    public Contacts save(Contacts contacts);

    public Contacts getById(Integer id);

    public void delete(Contacts contacts);
}
