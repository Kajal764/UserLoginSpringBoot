package user.registration.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BeanConfiguration {
    @Bean
    public BCryptPasswordEncoder getEncryptedPassword(){
    return new BCryptPasswordEncoder();
}

}
