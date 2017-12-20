package com.igs.ipi.tpspringbootPereauAlban.Controller;

import com.igs.ipi.tpspringbootPereauAlban.Model.GameModel;
import com.igs.ipi.tpspringbootPereauAlban.Service.GameService;
import com.igs.ipi.tpspringbootPereauAlban.Service.PartieEnCours;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GameController {

    private GameService gameService = new GameService();
    private PartieEnCours partieEnCours = new PartieEnCours();

    public GameController(GameService gameService, PartieEnCours partieEnCours) {
        this.gameService = gameService;
        this.partieEnCours = partieEnCours;
    }

    @RequestMapping("/game/new")
    public ModelAndView newGame(){



        ModelAndView mav = new ModelAndView("game"); //Instanciation d'un objet de type ModelAndView qui s'affiche dans game (.html)



        GameModel gameModel = gameService.newGame();

        partieEnCours.setGameModel(gameModel);



        mav.addObject("game", gameModel);



        return mav;
    }


    @RequestMapping("/game")
    public ModelAndView partieEnCOurs(){

        ModelAndView mav = new ModelAndView("game"); //Instanciation d'un objet de type ModelAndView qui s'affiche dans game (.html)



        GameModel gameModel = this.partieEnCours.getGameModel();


        mav.addObject("game", gameModel);



        return mav;
    }


}

