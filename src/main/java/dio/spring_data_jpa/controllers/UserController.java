package dio.spring_data_jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public List<User> findByUserName(@PathVariable("name") String name){
        return repository.findByNameContaining(name);
    }
    @DeleteMapping("/usuarios/{id}")
    public void deleteUser(@PathVariable("id")Integer id){
        repository.deleteById(id);
    }

    @PostMapping("/usuarios")
    public void postUser(@RequestBody User usuario){
        repository.save(usuario);
        
    }
    @PutMapping("/usuarios")
    public void putUser(@RequestBody User usuario){
        repository.save(usuario);
    }
}
