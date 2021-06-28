package pl.arturszejna.SalesSystemBackend.controller.webController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.arturszejna.SalesSystemBackend.entity.UserCredentials;
import pl.arturszejna.SalesSystemBackend.repository.UserCredentialsRepository;
import pl.arturszejna.SalesSystemBackend.service.UserCredentialsService;

import java.util.Optional;

@Controller
public class SignUpController {

    private final UserCredentialsService userCredentialsService;
    private final UserCredentialsRepository userCredentialsRepository;

    @Autowired
    public SignUpController(UserCredentialsService userCredentialsService, UserCredentialsRepository userCredentialsRepository) {
        this.userCredentialsService = userCredentialsService;
        this.userCredentialsRepository = userCredentialsRepository;
    }

    @GetMapping("/sign_up")
    public ModelAndView signUp(ModelAndView modelAndView) {
        modelAndView.setViewName("sign_up");
        return modelAndView;
    }

    @PostMapping("/sign_up")
    public ModelAndView signUpPost(ModelAndView modelAndView,
                                   @RequestParam("username") String username,
                                   @RequestParam("password") String password,
//                                   @RequestParam("confirm") String confirm,
                                   @RequestParam("phone") Integer phone,
                                   @RequestParam("email") String email,
                                   @RequestParam("full_name") String fullName) {

        String[] name = fullName.split(" ");
        if (name.length == 2) {
            userCredentialsService.signUpUserCredensials(UserCredentials.of(name[0], name[1], email, username, password, phone));
            modelAndView.setViewName("info");
        } else {
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }

    @RequestMapping("confirm_email")
    public String confirmEmail(@RequestParam(name = "token") String token) {
        Optional<UserCredentials> optionalUser = userCredentialsRepository.findByConfirmationToken(token);
        if (optionalUser.isPresent()) {
            UserCredentials user = optionalUser.get();
            user.setEnabled(true);
            userCredentialsRepository.save(user);
            return "redirect:/login";
        } else {
            return "error";
        }
    }

}
