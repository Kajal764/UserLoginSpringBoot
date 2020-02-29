package user.registration.demo.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import user.registration.demo.Exception.UserDataExistException;
import user.registration.demo.dto.UserDto;
import user.registration.demo.dto.loginDto;
import user.registration.demo.model.User;
import user.registration.demo.repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("${jwt.secret}")
    private String secret;

    @Override
    public User addRegisterrdUser(UserDto userDto) throws UserDataExistException {
        userDto.password=bCryptPasswordEncoder.encode(userDto.password);
        User user=new User(userDto);
        Optional<User> byEmailId=userRepository.findByEmailId(userDto.emailId);
        if(byEmailId.isPresent())
            throw new UserDataExistException("User Already Register!!! ");
        User registerdUser = userRepository.save(user);
        return registerdUser;
    }

    @Override
    public List<User> getRegisterdUser()
    {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public User getDataByName(String name) {
        User user = userRepository.findByFname(name).get();
        return user;
    }

    @Override
    public void deleteUserData(String emailId) {
        Optional<User> byEmailId = userRepository.findByEmailId(emailId);
        if(byEmailId.isPresent()) {
            userRepository.delete(byEmailId.get());
            return;
        }
        throw new UserDataExistException("User Data Not Available!!! ");
    }

//    @Override
//    public User updataUserData(UserDto userDto) {
//        User user = new User(userDto);
//
//        Optional<User> byEmailId = userRepository.findByEmailId(userDto.emailId);
//        if (byEmailId.isPresent()) {
//            User save = userRepository.save(user);
//            return save;
//        }
//        return userRepository.save(user);

        // return registerdUser;
//        User updatedData = userRepository.save(user);

//    }

    @Override
    public boolean checkLogin(loginDto loginDto) {

        Optional<User> byEmailId = userRepository.findByEmailId(loginDto.emailId);
        if(byEmailId.isPresent() && bCryptPasswordEncoder.matches(loginDto.password,byEmailId.get().password))
            return true;
        return false;
    }

    @Override
    public String authenticateUser(loginDto loginDto) {
        Optional<User> byEmailId = userRepository.findByEmailId(loginDto.emailId);

        if (byEmailId.isPresent() && bCryptPasswordEncoder.matches(loginDto.password, byEmailId.get().password))
            return Jwts.builder().
                    claim("email", loginDto.emailId).setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 20))
                    .signWith(SignatureAlgorithm.HS512, secret).compact();
        throw new UserDataExistException("Incorrect user id And password !!! ");
    }
}



