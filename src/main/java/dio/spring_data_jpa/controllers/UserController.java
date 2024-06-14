package dio.spring_data_jpa.controllers;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.spring_data_jpa.handler.BusinessException;
import dio.spring_data_jpa.model.User;
import dio.spring_data_jpa.repository.UserRepository;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    UserRepository repository;

    @GetMapping
    public List<User> findall(){
        List<User> saida = repository.findAll();
        return saida;
    }

    @GetMapping("/{name}")
    public List<User> findByUserName(@PathVariable("name") String name){
        return repository.findByNameContaining(name);
    }
    
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id")Integer id){
        if(repository.findById(id).isEmpty()){
            return "Usuario inexistente";
        }
        else{
            repository.deleteById(id);
            return "Usuario removido";
        }
    }

    @PostMapping
    public void postUser(@RequestBody User usuario){
        if(usuario.getName()==null){
            throw new BusinessException("Usuario não pode ser nulo");
        }
        else{
            repository.save(usuario);
        }
        
        
    }
    @PutMapping
    public void putUser(@RequestBody User usuario){
        repository.save(usuario);
    }
}
