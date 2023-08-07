package AhnHz.Ahnspring.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserCreateForm {

    @Size(min = 3, max = 20)    // 3~20 글자
    @NotEmpty(message = "사용자 ID는 꼭 입력하세요.")
    private String username;

    @NotEmpty(message = "비밀번호는 꼭 입력하세요.")
    private String password1;

    @NotEmpty(message = "비밀번호 확인은 꼭 입력하세요.")
    private String password2;

    @Email
    @NotEmpty(message = "이메일은 꼭 입력하세요.")
    private String email;

}
