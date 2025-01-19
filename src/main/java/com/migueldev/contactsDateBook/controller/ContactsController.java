package com.migueldev.contactsDateBook.controller;

import com.migueldev.contactsDateBook.entities.Contacts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/new")
    public String saveContact(Contacts contacts, RedirectAttributes redirect) {
        return "redirect:/";
    }
}
