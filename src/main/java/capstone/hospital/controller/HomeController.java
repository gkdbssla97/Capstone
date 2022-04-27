package capstone.hospital.controller;

import capstone.hospital.argumentresolver.Login;
import capstone.hospital.domain.Patient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String homeLogin(@Login Object loginMember, Model model) {

        if (loginMember == null) {
            return "home";
        }

        model.addAttribute("loginMember", loginMember);
        log.info("login");
        return "loginHome";
    }
}
