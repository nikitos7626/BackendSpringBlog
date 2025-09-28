package bookstore.personalblog.controller;

import bookstore.personalblog.model.modelUser;
import bookstore.personalblog.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class userController {
    private final UserService userService;

    public userController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/welcome")
    public String  welcome()
    {
        return "Добро пожаловать на незащищённую страницу";
    }

    @GetMapping("/allUsers")
    public List<modelUser> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public modelUser getUser(@PathVariable int id) {
        return userService.getUser(id);
    }
}