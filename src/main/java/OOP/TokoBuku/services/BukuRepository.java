package OOP.TokoBuku.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import OOP.TokoBuku.model.Buku;

@Repository
public interface BukuRepository extends JpaRepository<Buku, Integer> {
    List<Buku> findByNamabukuContainingIgnoreCase(String namabuku);
}
