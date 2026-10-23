package ridesync.repository;

import ridesync.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Returning List prevents NonUniqueResultException if duplicates exist
    List<User> findByPhone(String phone);
}