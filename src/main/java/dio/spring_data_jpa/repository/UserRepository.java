package dio.spring_data_jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import dio.spring_data_jpa.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{

    Optional<User> findByName(String name);

    List<User> findByNameContaining(String name);

    

    
} 
