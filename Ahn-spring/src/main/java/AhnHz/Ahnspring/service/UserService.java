package AhnHz.Ahnspring.service;

import AhnHz.Ahnspring.user.SignUp;
import AhnHz.Ahnspring.user.SignUpRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final SignUpRepository signUpRepository;    // 빨간줄에 Opt + Enter로 생성자 만들기
    private final PasswordEncoder passwordEncoder;      // 빨간줄에 Opt + Enter로 생성자 만들기

    public UserService(SignUpRepository signUpRepository, PasswordEncoder passwordEncoder) {     // 생성자
        this.signUpRepository = signUpRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public SignUp create(String username, String email, String password) {
        SignUp user = new SignUp();
        user.setUsername(username);
        user.setEmail(email);

        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(password));
        this.signUpRepository.save(user);
        return user;
    }


}
