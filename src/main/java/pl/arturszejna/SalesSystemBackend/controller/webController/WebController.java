package pl.arturszejna.SalesSystemBackend.controller.webController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.arturszejna.SalesSystemBackend.component.mailer.SignUpMailer;
import pl.arturszejna.SalesSystemBackend.repository.UserCredentialsRepository;

@Controller
public class WebController {

    private final SignUpMailer signUpMailer;
    private final UserCredentialsRepository userCredentialsRepository;

    @Autowired
    public WebController(SignUpMailer signUpMailer, UserCredentialsRepository userCredentialsRepository) {
        this.signUpMailer = signUpMailer;
        this.userCredentialsRepository = userCredentialsRepository;
    }

    @GetMapping("/start_panel")
    public ModelAndView userPanel(ModelAndView modelAndView) {
        modelAndView.setViewName("start_panel");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView loginPanel(ModelAndView modelAndView) {
        modelAndView.setViewName("loginNew");
        return modelAndView;
    }
}
