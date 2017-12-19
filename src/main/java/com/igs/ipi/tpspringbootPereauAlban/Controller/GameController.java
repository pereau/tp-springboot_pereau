package com.igs.ipi.tpspringbootPereauAlban.Controller;

import com.igs.ipi.tpspringbootPereauAlban.Model.GameModel;
import com.igs.ipi.tpspringbootPereauAlban.Service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GameController {

    @RequestMapping("/game/new")
    public ModelAndView newGame(){

        ModelAndView mav = new ModelAndView("game"); //Instanciation d'un objet de type ModelAndView qui s'affiche dans game (.html)

        GameService gameService = new GameService();

        GameModel gameModel = gameService.newGame();

        mav.addObject("nom1", gameModel.getNom1());
        mav.addObject("nom2", gameModel.getNom2());

        mav.addObject("game", gameModel);



        return mav;
    }


}

