package dio.spring_data_jpa.config;

import java.net.InetAddress;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthCheck implements HealthIndicator {
    @Override
    public Health health() {
        // TODO Auto-generated method stub
        try{
            InetAddress  adress = InetAddress.getByName("localhost");
            if(adress.isReachable(1000)){
                return Health.up().build();
            }
        }
        catch(Exception e){
            return Health.down().withDetail("Motivo",e).build();
        }
        return Health.down().withDetail("Motivo nao mapeado", null).build();
    }

}
