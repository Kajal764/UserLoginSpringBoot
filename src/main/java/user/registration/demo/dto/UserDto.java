package user.registration.demo.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserDto {

    @NotNull

    @Pattern(regexp ="^[a-zA-Z]{3,10}$",message = "Enter Valid Name")
    public String fname;

    @Email(regexp = "^[a-zA-Z0-9]{1,}[.+-]?[a-zA-Z0-9]{1,}?[@][a-zA-Z0-9]{1,}([.][a-zA-Z]{2,4}){1,2}$", message = "Enter Valid EmailId")
    public String emailId;

    @Pattern(regexp = "^[0-9A-Za-z]{3,10}$",message = "enter valid password")
    public String password;

    @Pattern(regexp = "^[+]?[0-9]{2}[ ][0-9]{10}$",message = "enter valid mobile no")
    public String mobileNo;

}
