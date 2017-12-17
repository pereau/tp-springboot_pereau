package com.igs.ipi.tpspringbootPereauAlban.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GameController {

    @RequestMapping("/game/new")
    public ModelAndView newGame(){
        ModelAndView mav = new ModelAndView("game"); //Instanciation d'un objet de type ModelAndView qui s'affiche dans game (.html)

        return mav;
    }


}

