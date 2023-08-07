package AhnHz.Ahnspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.model.IAttribute;

// MVC 패턴의 기본 !!
@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("name", "님");
        return "hello";
    }

    @GetMapping("hello-template")
    public String helloMVC(@RequestParam("name") String name,
                           @RequestParam("age") Integer age,
                           Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return "hello-template";

    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("age") Integer age) {
        return "저의 나이는 " + age + "세 입니다.";
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloAPI(@RequestParam("name") String name) {
        // 객체 생성 및 값 적용
        Hello hello = new Hello();
        hello.setName(name);
        return hello;   // 객체 자체를 반환
    }

    static class Hello {
        private String name;

        // cmd + N 단축키
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @GetMapping("get-form")
    public String GetForm() {
        return "get-form";
    }

    //@GetMapping("get-result")
    @PostMapping("get-result")  // 주소에 있던 값이 숨겨짐
    public String GetResult(@RequestParam("subject") String subjectValue,
                            @RequestParam("content") String contentValue,
                            Model model) {

        model.addAttribute("subject", subjectValue);
        model.addAttribute("content", contentValue);
        return "get-result";
    }

    @GetMapping("/")
    public String root() {
        return "index";
    }

}
