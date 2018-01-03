package com.igs.ipi.tpspringbootPereauAlban.Controller;

import com.igs.ipi.tpspringbootPereauAlban.Model.GameModel;
import com.igs.ipi.tpspringbootPereauAlban.Repository.GameRepository;
import com.igs.ipi.tpspringbootPereauAlban.Service.GameService;
import com.igs.ipi.tpspringbootPereauAlban.Service.PartieEnCours;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GameController {

    private GameService gameService = new GameService();
    private PartieEnCours partieEnCours = new PartieEnCours();
    
    @Autowired
    private GameRepository gameRepository;
    





    public GameController(GameService gameService, PartieEnCours partieEnCours) {
        this.gameService = gameService;
        this.partieEnCours = partieEnCours;
    }

    @RequestMapping("/game/new")
    public ModelAndView newGame(){

        ModelAndView mav = new ModelAndView("game"); //Instanciation d'un objet de type ModelAndView qui s'affiche dans game (.html)

        GameModel gameModel = gameService.newGame();

        String player = gameModel.getNom2();

        gameModel.setJoueurActuel(player);

        // initialisation de partieEnCours : initialement, partieEnCours est identique à gameModel de newGame
        partieEnCours.setGameModel(gameModel);

        mav.addObject("game", gameModel);

        return mav;
    }


    @RequestMapping("/game")
    public ModelAndView partieEnCours(){

        ModelAndView mav = new ModelAndView("game"); //Instanciation d'un objet de type ModelAndView qui s'affiche dans game (.html)

        GameModel gameModel = this.partieEnCours.getGameModel();

        mav.addObject("game", gameModel);

        return mav;
    }

    @GetMapping("game/drop/{i}")
    public ModelAndView dropJeton(@PathVariable("i") int col) {


        GameModel gameModel =this.partieEnCours.getGameModel(); //on récupère l'état actuel du jeu représenté par partieEnCours


        gameModel.ajoutJeton(col);

        gameModel.tourSuivant();
        this.partieEnCours.setGameModel(gameModel);

        ModelAndView mav =new ModelAndView("game");
        mav.addObject("game",gameModel);



        return mav;
    }
    
    
    @GetMapping("game/save")
    public ModelAndView Record() {

    	
        GameModel gameModel =this.partieEnCours.getGameModel(); //on récupère l'état actuel du jeu représenté par partieEnCours
        
        gameRepository.save(new GameModel(1,"Jean","Paul","Paul","Jean"));
    	
    	ModelAndView mav =new ModelAndView("game");
        mav.addObject("game",gameModel);



        return mav;

        
    }
    
    
    


}
