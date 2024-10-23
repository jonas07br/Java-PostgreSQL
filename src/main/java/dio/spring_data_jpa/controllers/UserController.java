package dio.spring_data_jpa.controllers;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.spring_data_jpa.DTOs.UserDTO;
import dio.spring_data_jpa.handler.BusinessException;
import dio.spring_data_jpa.model.User;
import dio.spring_data_jpa.repository.UserRepository;
import dio.spring_data_jpa.service.UserService;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody UserDTO userDTO){
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(userService.add(userDTO));
    }
    @GetMapping
    public ResponseEntity<List<User>> findall(){
        return ResponseEntity
        .status(HttpStatus.OK)
        .body(userService.findall());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Optional<User>> findByUserName(@PathVariable("name") String name){
        if(userService.findByUserName(name).isPresent()){
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(userService.findByUserName(name));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<User> putUser(@PathVariable("id") Integer id,@RequestBody UserDTO userDto) throws Exception{
        return ResponseEntity
        .status(HttpStatus.OK)
        .body(userService.updateUser(id,userDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id")Integer id){
        return ResponseEntity
        .status(HttpStatus.ACCEPTED)
        .body(userService.deleteUser(id));
    }

    @GetMapping("/role")
    public ResponseEntity<String> getRole(){
        return ResponseEntity
        .status(HttpStatus.OK)
        .body(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
