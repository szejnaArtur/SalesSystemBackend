package pl.arturszejna.SalesSystemBackend.controller.webController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    @GetMapping("/start_panel")
    public ModelAndView userPanel(ModelAndView modelAndView) {
        modelAndView.setViewName("start_panel");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView loginPanel(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
