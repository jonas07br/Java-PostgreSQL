package dio.spring_data_jpa.handler;

public class BusinessException extends RuntimeException {
    public BusinessException(String mensage){
        super(mensage);
    }
}