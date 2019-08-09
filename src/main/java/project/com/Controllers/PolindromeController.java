package project.com.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.com.Entity.Polindromes;
import project.com.Repository.PolindromeRepository;
import project.com.Service.PolindromeService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PolindromeController {

    @Autowired
    PolindromeService polindromeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greeting(Model model) {
        List<Polindromes> polindrome;
        polindrome = polindromeService.getAll();
        model.addAttribute("polindrome",polindrome);
        model.addAttribute("pol", new Polindromes());
        return "greeting";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String updateEmployee(@ModelAttribute("pol") Polindromes polindromes)
    {
        polindromeService.chackPolindrome(polindromes);
        return "redirect:/";
    }
}