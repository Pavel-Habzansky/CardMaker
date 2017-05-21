package com.openmatics.cardmaker.fxmlhandling;

import com.openmatics.cardmaker.controllers.CardController;
import javafx.scene.Parent;

//TODO class is unsused right now

public class LoadingUtilProperties {
    private final CardController cardController;
    private final Parent root;

    public LoadingUtilProperties(CardController cardController, Parent root){
        this.cardController = cardController;
        this.root = root;
    }

    public CardController getCardController(){
        return cardController;
    }
    public Parent getRoot(){
        return root;
    }

}
