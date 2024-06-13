package dio.spring_data_jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dio.spring_data_jpa.model.User;
import dio.spring_data_jpa.repository.UserRepository;

@RestController
public class UserController {
    @Autowired
    UserRepository repository;

    @GetMapping("/usuarios")
    public List<User> findall(){
        List<User> saida = repository.findAll();
        return saida;
    }

    @GetMapping("/usuarios/{name}")
    public User findByUserName(@PathVariable("name") String name){
        return repository.filtrarPorNome(name);
    }
}
