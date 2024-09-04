package OOP.TokoBuku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import OOP.TokoBuku.model.Buku;
import OOP.TokoBuku.model.Transaksi;
import OOP.TokoBuku.model.User;
import OOP.TokoBuku.services.BukuRepository;
import OOP.TokoBuku.services.TransaksiService;
import jakarta.servlet.http.HttpSession;

import java.util.Date;

@Controller
public class PembayaranController {

    @Autowired
    private BukuRepository bukuRepository;

    @Autowired
    private TransaksiService transaksiService;

    @GetMapping("/payment")
    public String showPaymentPage(@RequestParam("id") int id, Model model) {
        Buku buku = bukuRepository.findById(id).orElse(null);
        if (buku == null) {
            return "error"; 
        }

        model.addAttribute("id", id);
        model.addAttribute("buku", buku);

        return "user/payment";
    }

    @PostMapping("/payment")
    public String processPayment(@RequestParam("id") int id, HttpSession session, Model model) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login-page"; 
        }

        Buku buku = bukuRepository.findById(id).orElse(null);
        if (buku == null) {
            return "error"; 
        }

        User user = new User(); 
        user.setIduser(userId); 
        // Mengubah konstruktor untuk tidak lagi memerlukan objek Buku
        Transaksi transaksi = new Transaksi(user, userId, new Date(), buku.getHarga());

        transaksiService.simpanTransaksi(transaksi);

        return "redirect:/payment-success";
    }
}