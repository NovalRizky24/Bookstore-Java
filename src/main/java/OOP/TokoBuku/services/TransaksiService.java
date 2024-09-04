package OOP.TokoBuku.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import OOP.TokoBuku.model.Transaksi;

@Service
public class TransaksiService {

    @Autowired
    private TransaksiRepository transaksiRepository;

    @Transactional
    public Transaksi simpanTransaksi(Transaksi transaksi) {
        return transaksiRepository.save(transaksi);
    }
}
