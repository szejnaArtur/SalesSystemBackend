package pl.arturszejna.SalesSystemBackend.controller.webController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    @RequestMapping(value = "/user_panel", method = RequestMethod.GET)
    public ModelAndView userPanel(ModelAndView modelAndView){
        modelAndView.setViewName("user_panel");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPanel(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }


}
