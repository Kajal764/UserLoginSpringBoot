package user.registration.demo.service;

import user.registration.demo.Exception.UserDataExistException;
import user.registration.demo.dto.UserDto;
import user.registration.demo.dto.loginDto;
import user.registration.demo.model.User;

import java.util.List;

public interface UserService {

    User addRegisterrdUser(UserDto userDto) throws UserDataExistException;

    List<User> getRegisterdUser();

    User getDataByName(String name);

    void deleteUserData(String fname);

    //User updataUserData(UserDto userDto);

    boolean checkLogin(loginDto logindto);

    String authenticateUser(loginDto loginDto);
}
