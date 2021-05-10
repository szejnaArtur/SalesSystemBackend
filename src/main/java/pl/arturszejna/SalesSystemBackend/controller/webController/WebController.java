package pl.arturszejna.SalesSystemBackend.controller.webController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.arturszejna.SalesSystemBackend.component.mailer.SignUpMailer;
import pl.arturszejna.SalesSystemBackend.repository.UserCredentialsRepository;

@Controller
public class WebController {

    private SignUpMailer signUpMailer;
    private UserCredentialsRepository userCredentialsRepository;

    public WebController(SignUpMailer signUpMailer, UserCredentialsRepository userCredentialsRepository){
        this.signUpMailer = signUpMailer;
        this.userCredentialsRepository = userCredentialsRepository;
    }

    @GetMapping("/user_panel")
    public ModelAndView userPanel(ModelAndView modelAndView) {
        modelAndView.setViewName("user_panel");
        return modelAndView;
    }

    @GetMapping("/test")
    public ModelAndView testPanel(ModelAndView modelAndView) {
        modelAndView.setViewName("test");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView loginPanel(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
