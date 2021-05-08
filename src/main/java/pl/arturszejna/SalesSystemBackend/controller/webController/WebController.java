package pl.arturszejna.SalesSystemBackend.controller.webController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.arturszejna.SalesSystemBackend.component.SignUpMailer;

@Controller
public class WebController {

    @Autowired
    private SignUpMailer signUpMailer;

    @GetMapping("/user_panel")
    public ModelAndView userPanel(ModelAndView modelAndView) {
        modelAndView.setViewName("user_panel");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView loginPanel(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("send_mail")
    public String sendMail(){
        signUpMailer.sendMessage("arturtest69@gmail.com", "Testowy mail", "Mail testowy.");
        return "mail_sent";
    }
}
