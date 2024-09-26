package pe.edu.cibertec.jeremias_frontend_t1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginControler {

    @GetMapping("/inicio")

    public String inicio(Model model) {
        model.addAttribute("nombre", "ASR-124");
        return "inicio";
    }

}
