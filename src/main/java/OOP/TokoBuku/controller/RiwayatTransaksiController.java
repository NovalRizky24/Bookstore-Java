package OOP.TokoBuku.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import OOP.TokoBuku.model.Transaksi;
import OOP.TokoBuku.services.TransaksiRepository;

@Controller
@RequestMapping("/buku")
public class RiwayatTransaksiController {

    private final TransaksiRepository transaksiRepo;

    @Autowired
    public RiwayatTransaksiController(TransaksiRepository transaksiRepo) {
        this.transaksiRepo = transaksiRepo;
    }
    
    @GetMapping("/transaksi")
    public String showTransaksiPage(Model model) {
        List<Transaksi> transaksiList = transaksiRepo.findAll(); 
        model.addAttribute("transaksiList", transaksiList); 
        return "buku/transaksi";
    }
}
