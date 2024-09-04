package OOP.TokoBuku.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "transaksi")
public class Transaksi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtransaksi")
    private int idtransaksi;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;

    @Column(name = "idbuku") 
    private int idBuku;

    @Column(name = "tanggaltransaksi")
    private Date tanggaltransaksi;

    @Column(name = "harga")
    private double harga;

    // constructors, getters, and setters
    public Transaksi() {
    } 

    public Transaksi(User user, int idBuku, Date tanggaltransaksi, double harga) {
        this.user = user;
        this.idBuku = idBuku;
        this.tanggaltransaksi = tanggaltransaksi;
        this.harga = harga;
    }

    // getters and setters
    public int getIdtransaksi() {
        return idtransaksi;
    }

    public void setIdtransaksi(int idtransaksi) {
        this.idtransaksi = idtransaksi;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(int idBuku) {
        this.idBuku = idBuku;
    }
 
    public Date getTanggaltransaksi() {
        return tanggaltransaksi;
    }

    public void setTanggaltransaksi(Date tanggaltransaksi) {
        this.tanggaltransaksi = tanggaltransaksi;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}