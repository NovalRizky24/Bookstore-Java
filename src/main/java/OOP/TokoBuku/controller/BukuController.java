package OOP.TokoBuku.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import OOP.TokoBuku.model.Buku;
import OOP.TokoBuku.model.BukuDto;
import OOP.TokoBuku.services.BukuRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/buku")
public class BukuController {

    @Autowired
    private BukuRepository repo;

    @GetMapping({"", "/"})
    public String showBukuList(Model model) {
        List<Buku> buku = repo.findAll(Sort.by(Sort.Direction.DESC,"idbuku"));
        model.addAttribute("buku", buku);
        return "buku/index";
    }

    @GetMapping("/search")
    public String searchBuku(@RequestParam("namabuku") String namaBuku, Model model) {
        List<Buku> buku = repo.findByNamabukuContainingIgnoreCase(namaBuku);
        model.addAttribute("buku", buku);
        return "buku/index";
    }

    @GetMapping("/tambahbuku")
    public String showCreatePage(Model model) {
        BukuDto bukuDto = new BukuDto();
        model.addAttribute("bukuDto", bukuDto);
        return "buku/tambahbuku";
    }

    @PostMapping("/tambahbuku")
    public String createProduct(
            @Valid BukuDto bukuDto,
            BindingResult result,
            Model model
    ) {
        if (bukuDto.getFileGambar().isEmpty()) {
            result.addError(new FieldError("bukuDto", "fileGambar", "Gambar tidak boleh kosong"));
        }

        if (result.hasErrors()) {
            return "buku/tambahbuku";
        }

        // Simpan buku ke dalam basis data
        Buku buku = new Buku();
        buku.setNamabuku(bukuDto.getNamabuku());
        buku.setPenulis(bukuDto.getPenulis());
        buku.setHarga(bukuDto.getHarga());
        buku.setJumlahhalaman(bukuDto.getJumlahhalaman());
        buku.setTglterbit(bukuDto.getTglterbit());

        // Simpan gambar
        try {
            String uploadDir = "public/Gambar_Buku/";
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            MultipartFile image = bukuDto.getFileGambar();
            String storageFileName = new Date().getTime() + "_" + image.getOriginalFilename();
            Path filePath = uploadPath.resolve(storageFileName);
            Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            buku.setFilegambar(storageFileName);
        } catch (Exception ex) {
            System.out.println("Exception:" + ex.getMessage());
            return "buku/tambahbuku"; 
        }

        repo.save(buku);

        return "redirect:/buku";
    }

    @GetMapping("/edit/{idbuku}")
    public String showEditPage(
            Model model,
            @PathVariable int idbuku
    ) {
        try {
            Buku buku = repo.findById(idbuku).orElse(null);
            if (buku == null) {
                return "redirect:/buku";
            }

            model.addAttribute("buku", buku);

            BukuDto bukuDto = new BukuDto();
            bukuDto.setNamabuku(buku.getNamabuku());
            bukuDto.setPenulis(buku.getPenulis());
            bukuDto.setHarga(buku.getHarga());
            bukuDto.setJumlahhalaman(buku.getJumlahhalaman());
            bukuDto.setTglterbit(buku.getTglterbit());
            bukuDto.setFileGambar(null); 

            model.addAttribute("bukuDto", bukuDto); 

        } catch (Exception ex) {
            System.out.println("Exception:" + ex.getMessage());
            return "redirect:/buku";
        }
        return "buku/editbuku";
    }

//    @PostMapping("/edit/{idbuku}")
//    public String updateProduct(
//            @PathVariable int idbuku,
//            @Valid @ModelAttribute BukuDto bukuDto,
//            BindingResult result,
//            Model model
//    ) {
//        if (result.hasErrors()) {
//            return "buku/editbuku"; 
//        }
//
//        try {
//            Buku buku = repo.findById(idbuku).orElse(null);
//            if (buku == null) {
//                return "redirect:/buku"; 
//            }
//
//            buku.setNamabuku(bukuDto.getNamabuku());
//            buku.setPenulis(bukuDto.getPenulis());
//            buku.setHarga(bukuDto.getHarga());
//            buku.setJumlahhalaman(bukuDto.getJumlahhalaman());
//            buku.setTglterbit(bukuDto.getTglterbit());
//
//            if (!bukuDto.getFileGambar().isEmpty()) {
//                String uploadDir = "public/Gambar_Buku/";
//                Path oldImagePath = Paths.get(uploadDir + buku.getFilegambar());
//
//                try {
//                    Files.delete(oldImagePath);
//                } catch (Exception ex) {
//                    System.out.println("Exception: " + ex.getMessage());
//                }
//
//                MultipartFile image = bukuDto.getFileGambar();
//                String storageFileName = new Date().getTime() + "_" + image.getOriginalFilename();
//
//                try (InputStream inputStream = image.getInputStream()) {
//                    Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
//                            StandardCopyOption.REPLACE_EXISTING);
//                }
//
//                buku.setFilegambar(storageFileName);
//            }
//
//            repo.save(buku);
//        } catch (Exception ex) {
//            System.out.println("Exception: " + ex.getMessage());
//        }
//
//        return "redirect:/buku";
//    }


//    @PostMapping("/delete")
//    public String deleteProduct(@RequestParam int idbuku) {
//        try {
//            // Mencari buku berdasarkan ID
//            Optional<Buku> bukuOptional = repo.findById(idbuku);
//
//            // Jika buku ditemukan, hapus data buku dan gambar
//            if (bukuOptional.isPresent()) {
//                Buku buku = bukuOptional.get();
//
//                // Hapus gambar dari sistem file
//                Path imagePath = Paths.get("public/Gambar_Buku/" + buku.getFilegambar());
//                try {
//                    Files.delete(imagePath);
//                } catch (Exception ex) {
//                    System.out.println("Exception: " + ex.getMessage());
//                }
//
//                // Hapus data buku dari database
//                repo.delete(buku);
//            } else {
//            	System.out.println("Buku dengan ID " + idbuku + " tidak ditemukan.");
//            }
//        } catch (Exception ex) {
//            System.out.println("Exception: " + ex.getMessage());
//        }
//
//        return "redirect:/buku";
//    }


}
