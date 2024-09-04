package OOP.TokoBuku.controller;

import OOP.TokoBuku.model.Buku;
import OOP.TokoBuku.services.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class DeleteController {

    private final BukuRepository bukuRepository;

    @Autowired
    public DeleteController(BukuRepository bukuRepository) {
        this.bukuRepository = bukuRepository;
    }

    @PostMapping("/buku/delete")
    public String deleteBuku(@RequestParam("idbuku") int idbuku, Model model) {
        // Ambil buku berdasarkan ID
        Buku buku = bukuRepository.findById(idbuku).orElse(null);
        
        // Jika buku tidak ditemukan, kembalikan ke halaman /buku
        if (buku == null) {
            return "redirect:/buku";
        }

        // Hapus gambar dari sistem file
        Path imagePath = Paths.get("public/Gambar_Buku/" + buku.getFilegambar());
        try {
            Files.delete(imagePath);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }

        // Hapus buku dari database
        bukuRepository.delete(buku);
        
        // Redirect ke halaman /buku setelah penghapusan
        return "redirect:/buku";
    }
}
