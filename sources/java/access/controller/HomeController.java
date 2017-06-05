package access.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Vladyslav Dovhopol
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/schedule")
    public String showSchedule() {
        return "schedule";
    }
}
