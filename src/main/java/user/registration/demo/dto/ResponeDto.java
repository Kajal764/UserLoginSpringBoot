package user.registration.demo.dto;

import lombok.Getter;
import lombok.Setter;
import user.registration.demo.model.User;

@Getter
@Setter
public class ResponeDto {

    public String message;
    public User user;
    public ResponeDto(String message, User user) {
        this.message=message;
        this.user=user;
    }

//    public ResponeDto(String login) {
//        this.message=login;
//    }


    @Override
    public String toString() {
        return "ResponeDto{" +
                "message='" + message + '\'' +
                ", user=" + user +
                '}';
    }
}
