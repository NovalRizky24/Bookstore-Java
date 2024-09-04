package OOP.TokoBuku.controller;

import OOP.TokoBuku.model.User;
import OOP.TokoBuku.services.UserRepository;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        User user = userRepository.findFirstByUsername(username);

        if (user != null && password.equals(user.getPassword())) {
            session.setAttribute("userId", user.getIduser());
            session.setAttribute("username", user.getUsername());
            session.setAttribute("nama", user.getNama()); 
            if ("admin".equals(user.getRole())) {
                return new ModelAndView("redirect:/buku");
            } else if ("user".equals(user.getRole())) {
                return new ModelAndView("redirect:/homeuser");
            } else {
                ModelAndView modelAndView = new ModelAndView("login/login");
                modelAndView.addObject("error", "Role salah.");
                return modelAndView;
            }
        } else {
            ModelAndView modelAndView = new ModelAndView("login/login");
            modelAndView.addObject("error", "Username atau password salah.");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/login-page", method = RequestMethod.GET)
    public String showLoginPage() {
        return "login/login";
    }
}