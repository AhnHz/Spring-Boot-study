package AhnHz.Ahnspring.Repository;

import AhnHz.Ahnspring.user.SignUp;
import AhnHz.Ahnspring.user.SignUpRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class SignUpRepositoryTest {

    @Autowired
    private SignUpRepository signUpRepository;

    @Test
    void testJpa () {
        SignUp user1 = new SignUp();
        user1.setUsername("user1");
        user1.setPassword("user1user1");
        user1.setEmail("user1@user1.com");
        this.signUpRepository.save(user1);

        SignUp user2 = new SignUp();
        user2.setUsername("user2");
        user2.setPassword("user2user2");
        user2.setEmail("user2@user2.com");
        this.signUpRepository.save(user2);
    }


    @Test
    void testJpa_2 () {
        List<SignUp> all = this.signUpRepository.findAll();
        Assertions.assertEquals(2, all.size());

        SignUp user = all.get(0);
        Assertions.assertEquals("user1", user.getUsername());   // 실제로 받은 값이 user1과 같은지
    }

    @Test
    void testJpa_3 () {
        Optional<SignUp> up = this.signUpRepository.findById(1L);
        if(up.isPresent()){
            SignUp user = up.get();
            Assertions.assertEquals("user1@user1.com", user.getEmail());
        }
    }

    @Test
    void testJpa_4 () {
        SignUp user = this.signUpRepository.findByUsername("user2");
        Assertions.assertEquals("user2user2222", user.getPassword());
    }

    @Test
    void testJpa_5 () {
        SignUp user = this.signUpRepository.findByUsernameAndEmail("user2", "user2@user2.com");
        Assertions.assertEquals(2, user.getId());
    }

    @Test
    void testJpa_6 () {
        List<SignUp> userlist = this.signUpRepository.findByEmailLike("user%");
        SignUp user = userlist.get(0);
        Assertions.assertEquals("user1@user1.com", user.getEmail());

        Integer count = userlist.size();
        Assertions.assertEquals(2, count);
    }

    @Test
    void testJpa_7 () {
        Optional<SignUp> user = this.signUpRepository.findById(2L);
        Assertions.assertTrue(user.isPresent());
        SignUp u = user.get();
        u.setEmail("user2@naver.com");      // 이메일 수정
        this.signUpRepository.save(u);
    }

    @Test
    void testJpa_8() {
        Assertions.assertEquals(2, this.signUpRepository.count());
        Optional<SignUp> user = this.signUpRepository.findById(2L);
        Assertions.assertTrue(user.isPresent());
        SignUp u = user.get();
        this.signUpRepository.delete(u);    // 삭제
        Assertions.assertEquals(1, this.signUpRepository.count());  // 삭제한 뒤엔 count 1개
    }
}
