package com.igs.ipi.tpspringbootPereauAlban.Service;

import com.igs.ipi.tpspringbootPereauAlban.Model.GameModel;
import org.springframework.stereotype.Service;

@Service
public class GameService {



    public GameModel newGame(){

        GameModel gameModel = new GameModel();



        gameModel.setNom1("joueur1");
        gameModel.setNom2("joueur2");

        return gameModel;

    }

}
