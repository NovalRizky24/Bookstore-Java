package OOP.TokoBuku.services;

import OOP.TokoBuku.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findFirstByUsername(String username);
}
