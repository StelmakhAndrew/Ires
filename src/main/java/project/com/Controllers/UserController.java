package project.com.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.com.Entity.Book;
import project.com.Entity.User;
import project.com.Service.UserService;
import project.com.Service.BookService;

import java.util.List;
import java.util.Set;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    // "redirect:/user?id="+user.getId()

    @RequestMapping(value = "/user", method = GET)
    public String userProfile(@RequestParam("id") Long id, Model model){
        User user = userService.findById(id).orElse(new User("d","sdf@gmail.com","fs"));
        model.addAttribute("user",user);
        System.out.println(userService.getCurrentUser().getUsername());
        return "user";
    }
    @RequestMapping(value = "/profile", method = GET)
    public String profile(Model model){
        User user = userService.getCurrentUser();
        List<Book> books = user.getBooks();
        model.addAttribute("user",user);
        model.addAttribute("allBooks",books);
        return "profile";
    }
}
