package pe.edu.cibertec.jeremias_frontend_t1.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import pe.edu.cibertec.jeremias_frontend_t1.dto.Auto;

@Controller
@RequestMapping("/login")
public class AutoController {


    private final String API_URL = "http://localhost:8081/api/auto/buscar";
    private final RestTemplate restTemplate;

    public AutoController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/inicio")
    public String mostrarFormulario(Model model) {
        return "inicio";
    }
    @GetMapping("/buscar-auto")
    public String buscarAuto(@RequestParam("placa") String placa, Model model) {
        // Consumir el API REST
        Auto auto = restTemplate.getForObject(API_URL + "?placa=" + placa, Auto.class);

        if (auto != null) {
            model.addAttribute("auto", auto);
            return "resultado";
        } else {
            model.addAttribute("mensaje", "Auto no encontrado");
            return "resultado";
        }
    }
}