package dio.spring_data_jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dio.spring_data_jpa.DTOs.UserDTO;
import dio.spring_data_jpa.handler.BusinessException;
import dio.spring_data_jpa.handler.UserNotFoundException;
import dio.spring_data_jpa.handler.UserNullException;
import dio.spring_data_jpa.model.User;
import dio.spring_data_jpa.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findall() {
        return repository.findAll();
    }

    public Optional<User> findByUserName(String name) {
        return repository.findByName(name);
    }

    public String deleteUser(Integer id) {
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
            return "USER REMOVED";
        }
        return "USER NOT FOUND";
    }

    public User add(UserDTO userDto) {
        if(userDto.name()==null || userDto.password()==null){
            /* throw new BusinessException("Name and password must be not-null"); */
            throw new UserNullException();
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        repository.save(user);
        return user;
        
    }

    public User updateUser(Integer id, UserDTO userDto) throws Exception {
        if(repository.findById(id).isPresent()){
            if(userDto.name()==null || userDto.password()==null){
                // throw new BusinessException("Name and password must be not-null");
                throw new UserNullException();
            }
            User user = new User();
            user.setId(id);
            BeanUtils.copyProperties(userDto, user);
            repository.save(user);
            return user;
        }
        // throw new BusinessException("User not found");
        throw new UserNotFoundException();
    }



}
