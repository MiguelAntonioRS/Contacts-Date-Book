package com.migueldev.contactsDateBook.controller;

import com.migueldev.contactsDateBook.entities.Contacts;
import com.migueldev.contactsDateBook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
public class ContactsController {

    @Autowired
    private ContactService contactService;

    @GetMapping({"/",""})
    public String homePage(Model model) {
        List<Contacts> contacts = contactService.findAll();
        model.addAttribute("contacts", contacts);
        return "index";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("contacts", new Contacts());
        return "new";
    }

    @PostMapping("/new")
    public String saveContact(Contacts contacts, RedirectAttributes redirect) {
        contactService.save(contacts);
        redirect.addFlashAttribute("msgSucc", "El contacto se guardo satisfactoriamente");
        return "redirect:/";
    }
}
