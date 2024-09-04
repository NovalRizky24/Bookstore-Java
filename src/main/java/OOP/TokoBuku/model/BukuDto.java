// BukuDto.java
package OOP.TokoBuku.model;

import java.util.Date; // Mengubah import statement untuk Date

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;

public class BukuDto {

    private int idbuku; // Menambahkan field idbuku

    @NotEmpty(message = "Nama tidak boleh kosong")
    private String namabuku;

    @NotEmpty(message = "Penulis tidak boleh kosong")
    private String penulis;

    @Positive(message = "Harga harus lebih dari 0")
    private double harga;

    @Positive(message = "Jumlah halaman harus lebih dari 0")
    private int jumlahhalaman;

    @NotNull(message = "Tanggal terbit tidak boleh kosong")
    private Date tglterbit; // Mengubah tipe data menjadi java.util.Date

    @NotNull(message = "Gambar tidak boleh kosong")
    private MultipartFile fileGambar;

    // Getters dan setters...
    public int getIdbuku() {
        return idbuku;
    }

    public void setIdbuku(int idbuku) {
        this.idbuku = idbuku;
    }

    public String getNamabuku() {
        return namabuku;
    }

    public void setNamabuku(String namabuku) {
        this.namabuku = namabuku;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getJumlahhalaman() {
        return jumlahhalaman;
    }

    public void setJumlahhalaman(int jumlahhalaman) {
        this.jumlahhalaman = jumlahhalaman;
    }

    public Date getTglterbit() {
        return tglterbit;
    }

    public void setTglterbit(Date tglterbit) {
        this.tglterbit = tglterbit;
    }

    public MultipartFile getFileGambar() {
        return fileGambar;
    }

    public void setFileGambar(MultipartFile fileGambar) {
        this.fileGambar = fileGambar;
    } 
}
