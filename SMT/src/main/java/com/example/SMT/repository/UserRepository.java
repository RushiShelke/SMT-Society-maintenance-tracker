package com.example.SMT.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.SMT.entity.User;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
    Optional<User> findByphoneNumber(String phoneNumber);
    Optional<User> findBysocietyregno(String societyregno);


}
