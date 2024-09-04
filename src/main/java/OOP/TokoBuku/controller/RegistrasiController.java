package OOP.TokoBuku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import OOP.TokoBuku.model.User;
import OOP.TokoBuku.services.UserRepository;

@Controller
public class RegistrasiController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String showRegistrationPage() {
        return "login/registrasi";
    }

    @PostMapping("/registration")
    public ModelAndView registerUser(@RequestParam String nama, @RequestParam String username,
                                     @RequestParam String password, @RequestParam("confirmPassword") String confirmPassword) {
        // Check if password and confirm password match
        if (!password.equals(confirmPassword)) {
            // Redirect back to registration page with error message
            ModelAndView modelAndView = new ModelAndView("login/registrasi");
            modelAndView.addObject("error", "Password and Confirm Password do not match");
            return modelAndView;
        }

        // Create a new user with admin role
        User user = new User(nama, username, password, "user");

        // Save the user to the database
        userRepository.save(user);

        // Redirect to login page
        return new ModelAndView("redirect:/login-page");
    }
}
