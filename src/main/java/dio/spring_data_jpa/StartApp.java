package dio.spring_data_jpa;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dio.spring_data_jpa.model.Emprestimos;
import dio.spring_data_jpa.model.User;
import dio.spring_data_jpa.repository.EmprestimosRepository;
import dio.spring_data_jpa.repository.UserRepository;
@SuppressWarnings("unused")
@Component
public class StartApp implements CommandLineRunner {
    @Autowired
    private UserRepository repository;
    @Autowired
    private EmprestimosRepository emprestimosRepository;

    @Override
    public void run(String... args) throws Exception {
        
        
        
        
    }

}
