package OOP.TokoBuku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SuccessController {

    @GetMapping("/payment-success")
    public String showSuccessPage() {
        return "user/success";
    }
}
