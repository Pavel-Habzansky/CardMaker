package com.openmatics.cardmaker.controllers;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by PavelHabzansky on 01.02.17.
 */
public class CardController {
    @FXML
    private Label nameLabel;
    @FXML
    private Label positionLabel;
    @FXML
    private Label addressLabel;

    private static Logger logger = LogManager.getLogger(CardController.class.getName());

//    @FXML
//    public void initialize(){
//        logger.debug("Card Controller initialized");
//    }

    public StringProperty getNameLabelProperty(){
        return nameLabel.textProperty();
    }

    public StringProperty getPositionLabelProperty(){
        return positionLabel.textProperty();
    }

    public StringProperty getAddressLabelProperty(){
        return addressLabel.textProperty();
    }

}
