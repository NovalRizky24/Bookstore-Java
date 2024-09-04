package OOP.TokoBuku.model;

import java.sql.Blob;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table (name = "buku") 
public class Buku {
		
	@Id
	@GeneratedValue (strategy=GenerationType. IDENTITY)
	private int idbuku;
	private String namabuku;
	private String penulis;
	private int jumlahhalaman;
	private Date tglterbit;
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
	public double getHarga() {
		return harga;
	}
	public void setHarga(double harga) {
		this.harga = harga;
	}
	public String getFilegambar() {
		return Filegambar;
	}
	public void setFilegambar(String filegambar) {
		Filegambar = filegambar;
	}
	private double harga;
	private String Filegambar;
}