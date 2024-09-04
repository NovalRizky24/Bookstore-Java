package OOP.TokoBuku.services;

import OOP.TokoBuku.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerNewUser(User user) {
        // Tidak mengenkripsi password, langsung menyimpannya
        return userRepository.save(user);
    }
}
