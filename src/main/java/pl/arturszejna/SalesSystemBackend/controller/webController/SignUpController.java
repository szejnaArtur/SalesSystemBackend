package pl.arturszejna.SalesSystemBackend.controller.webController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.arturszejna.SalesSystemBackend.entity.UserCredentials;
import pl.arturszejna.SalesSystemBackend.service.UserCredentialsService;

@Controller
public class SignUpController {

    private UserCredentialsService userCredentialsService;

    @Autowired
    public SignUpController(UserCredentialsService userCredentialsService){
        this.userCredentialsService = userCredentialsService;
    }

    @GetMapping("/sign_up")
    public ModelAndView signUp(ModelAndView modelAndView){
        modelAndView.setViewName("sign_up");
        return modelAndView;
    }

    @PostMapping("/sign_up")
    public ModelAndView signUpPost(ModelAndView modelAndView, @RequestParam("username") String username, @RequestParam("password") String password){
        modelAndView.setViewName("redirect:/login");
        userCredentialsService.signUpUserCredensials(new UserCredentials(username, password));
        return modelAndView;
    }

}
