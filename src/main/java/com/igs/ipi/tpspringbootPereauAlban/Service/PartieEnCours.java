package com.igs.ipi.tpspringbootPereauAlban.Service;

import com.igs.ipi.tpspringbootPereauAlban.Model.GameModel;
import com.igs.ipi.tpspringbootPereauAlban.Repository.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PartieEnCours {


    private GameModel gameModel;
    
    
    
   



    public GameModel getGameModel() {
        return gameModel;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;

    }
    
    




}
