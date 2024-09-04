package OOP.TokoBuku.controller;

import OOP.TokoBuku.model.Buku;
import OOP.TokoBuku.services.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BukuRepository bukuRepository;

    @GetMapping("/homeuser")
    public String homeUser(Model model, @RequestParam(value = "namabuku", required = false) String namaBuku) {
        List<Buku> listBuku;
        if (namaBuku != null && !namaBuku.isEmpty()) {
            listBuku = bukuRepository.findByNamabukuContainingIgnoreCase(namaBuku);
        } else {
            listBuku = bukuRepository.findAll();
        }
        model.addAttribute("listBuku", listBuku);
        return "user/homeuser"; 
    }
}
