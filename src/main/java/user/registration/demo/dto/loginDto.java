package user.registration.demo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;


@Getter
@Setter
public class loginDto {

    public String emailId;
    public String password;


}
