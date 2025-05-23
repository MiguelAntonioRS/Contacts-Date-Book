package com.migueldev.contactsDateBook.controller;

import com.migueldev.contactsDateBook.entities.Contacts;
import com.migueldev.contactsDateBook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Optional;

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
    public String saveContact(@Validated Contacts contacts, BindingResult bindingResult, RedirectAttributes redirect, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("contacts", contacts);
            return "new";
        }

        contactService.save(contacts);
        redirect.addFlashAttribute("msgSucc", "El contacto se guardo satisfactoriamente");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editContact( @PathVariable Integer id, Model model) {
        Contacts contacts = contactService.getById(id);
        model.addAttribute("contacts", contacts);
        return "new";
    }

    @PostMapping("/edit/{id}")
    public String actualizeContact(@PathVariable Integer id, @Validated Contacts contacts, BindingResult bindingResult, RedirectAttributes redirect, Model model) {
        Contacts contactsDb = contactService.getById(id);

        if (bindingResult.hasErrors()) {
            model.addAttribute("contacts", contacts);
            return "new";
        }

        contactsDb.setName(contacts.getName());
        contactsDb.setPhone(contacts.getPhone());
        contactsDb.setEmail(contacts.getEmail());
        contactsDb.setBornDate(contacts.getBornDate());

        contactService.save(contactsDb);
        redirect.addFlashAttribute("msgSucc", "El contacto se actualizo satisfactoriamente");
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteContact(@PathVariable Integer id, RedirectAttributes redirect) {
        Contacts contacts = contactService.getById(id);
        contactService.delete(contacts);

        redirect.addFlashAttribute("msgSucc", "Contacto Eliminado");
        return "redirect:/";
    }
}
