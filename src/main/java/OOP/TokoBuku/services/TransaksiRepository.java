package OOP.TokoBuku.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import OOP.TokoBuku.model.Transaksi;

@Repository
public interface TransaksiRepository extends JpaRepository<Transaksi, Integer> {
    // Jika diperlukan, kamu dapat menambahkan method tambahan sesuai kebutuhan aplikasi
}


