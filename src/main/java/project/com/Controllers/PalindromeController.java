package project.com.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.com.Entity.Palindrome;
import project.com.Service.PalindromeService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PalindromeController {

    @Autowired
    PalindromeService palindromeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getPalindromes(Model model) {
        List<Palindrome> allPalindromes;
        allPalindromes = palindromeService.getAll();
        model.addAttribute("allPalindromes",allPalindromes);
        model.addAttribute("palindrome", new Palindrome());
        return "palindromes";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String setPalindrome(@Valid Palindrome palindrome, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors()) {
            List<Palindrome> allPalindromes;
            allPalindromes = palindromeService.getAll();
            model.addAttribute("allPalindromes",allPalindromes);
            return "palindromes";
        }
        palindromeService.findPalindromes(palindrome);
        return "redirect:/";
    }
}