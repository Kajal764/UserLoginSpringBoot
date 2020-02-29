package user.registration.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import user.registration.demo.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User ,Integer> {
    Optional<User> findByEmailId(String emailId);
    Optional<User> findByFname(String name);
    void deleteByEmailId(String emailId);

}

