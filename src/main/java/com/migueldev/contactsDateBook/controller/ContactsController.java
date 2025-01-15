package com.migueldev.contactsDateBook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactsController {

    @GetMapping({"/",""})
    public String homePage() {
        return "index";
    }
}
