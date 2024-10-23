package dio.spring_data_jpa.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserControllerAdvice extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(UserNullException.class)
    public ResponseEntity<Object> catchNullException(){
        Map<String,Object> body = new HashMap<String,Object>();
        body.put("Erro", "Usuario ou senha invalidos");
        body.put("Message", "Verifique novamente as credenciais");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> catchNotFoundException(){
        Map<String,Object> body = new HashMap<String,Object>();
        body.put("Erro", "Usuario nao encontrado");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
