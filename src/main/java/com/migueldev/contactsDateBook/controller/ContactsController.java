package com.migueldev.contactsDateBook.controller;

import com.migueldev.contactsDateBook.entities.Contacts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactsController {

    @GetMapping({"/",""})
    public String homePage() {
        return "index";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("contacts", new Contacts());
        return "new";
    }
}
