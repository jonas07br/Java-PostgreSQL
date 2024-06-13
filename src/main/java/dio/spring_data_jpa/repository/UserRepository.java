package dio.spring_data_jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dio.spring_data_jpa.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{

    List<User> findByNameContaining(String name);


    //Query Override
    @Query("SELECT u FROM User u WHERE u.name LIKE %:name%")
    User filtrarPorNome(@Param("name") String name);

    

    
} 
