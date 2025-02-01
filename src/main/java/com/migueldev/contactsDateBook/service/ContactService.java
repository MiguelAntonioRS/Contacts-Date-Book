package com.migueldev.contactsDateBook.service;

import com.migueldev.contactsDateBook.entities.Contacts;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface ContactService {

    public List<Contacts> findAll();

    public Contacts save(Contacts contacts);

    public Contacts getById(Integer id);

    public void delete(Contacts contacts);
}
