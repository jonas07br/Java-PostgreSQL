package dio.spring_data_jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.spring_data_jpa.model.Livros;
import dio.spring_data_jpa.repository.LivrosRepository;

@RestController
@RequestMapping("/livros")
public class LivrosController {
    @Autowired
    LivrosRepository livrosRepository;
    @GetMapping("/buscar")
    public List<Livros> buscarLivros(){
        return livrosRepository.findAll();
    }

    @PostMapping("/create")
    public void addLivro(Livros livro){
        livrosRepository.save(livro);
    }
}
