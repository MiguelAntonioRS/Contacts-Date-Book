package com.migueldev.contactsDateBook.repository;

import com.migueldev.contactsDateBook.entities.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface contactsRepository extends JpaRepository<Contacts, Integer> {
}
