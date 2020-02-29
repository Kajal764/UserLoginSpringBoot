package user.registration.demo.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import user.registration.demo.Exception.UserDataExistException;
import user.registration.demo.dto.ResponeDto;
import user.registration.demo.dto.UserDto;
import user.registration.demo.dto.loginDto;
import user.registration.demo.model.User;
import user.registration.demo.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<ResponeDto> addRegisterrdUser(@Valid @RequestBody UserDto userDto) throws UserDataExistException {
        User user = userService.addRegisterrdUser(userDto);
        ResponeDto userData = new ResponeDto("User Info Successfully Addded", user);
        return new ResponseEntity<ResponeDto>(userData, HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/userdata")
    public List<User> getRegisteredUserData() {
        List<User> registerdUser = userService.getRegisterdUser();
        return registerdUser;
    }

    @GetMapping("/findbyid/{fname}")
    public User getUserDataById(@PathVariable("fname") String fname){
        User dataById = userService.getDataByName(fname);
        return dataById;
    }

    @DeleteMapping("deletedata/{EmailId}")
    public void deleteData(@PathVariable("EmailId") String emailId){
        userService.deleteUserData(emailId);

    }

//    @PutMapping("/updatedData")
//    public ResponseEntity<ResponeDto> getUpdateData(@RequestBody UserDto userDto){
//        User user = userService.updataUserData(userDto);
//        ResponeDto userData = new ResponeDto("User Info Successfully updated", user);
//        return new ResponseEntity<ResponeDto>(userData, HttpStatus.OK);
//    }

    @PutMapping("/login")
    public ResponseEntity<ResponeDto>checkLogin(@RequestBody loginDto logindto){
        User user=new User(logindto);
        if(userService.checkLogin(logindto))
        {
            ResponeDto userData = new ResponeDto("login",user);
            return new ResponseEntity<ResponeDto>(userData, HttpStatus.OK);
        }
        ResponeDto userData = new ResponeDto("Please Registered !!!",user);
        return new ResponseEntity<ResponeDto>(userData,HttpStatus.OK);
    }

    @PutMapping("/authenticateuser")
    public ResponseEntity<ResponeDto> authenticateUser(@RequestBody loginDto loginDto){
       // User user=new User(loginDto);
        String user1 = userService.authenticateUser(loginDto);

        //ResponeDto userData = new ResponeDto("User Id And Password Verify Successfully", user);
        return new ResponseEntity(user1, HttpStatus.OK);
    }



}
