package dio.spring_data_jpa.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
    @GetMapping
    public String welcome(){
        return "OLA";
    }
}
