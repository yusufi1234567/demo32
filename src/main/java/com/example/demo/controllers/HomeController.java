package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController extends BaseController {

    @GetMapping("/")
    public String home(Model model) {
        // hämta saker från databas
        //list<string>
        List<String> players = new ArrayList<>();
        players.add("Foppa");
        players.add("Kalle");
        players.add("JJJ");
        model.addAttribute("players", players);
        model.addAttribute("user", "Kalle");
        return "home";


    }

//    @GetMapping("/profile")
//    public String profile() {
//        return "profile";


    @GetMapping("/profile")
    public String profile(Model model) {
        String email = getLoggedInEmail();
        model.addAttribute("user", email);

        return "profile";
    }
}

