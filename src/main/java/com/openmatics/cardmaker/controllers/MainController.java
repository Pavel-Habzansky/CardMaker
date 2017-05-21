package com.openmatics.cardmaker.controllers;

import com.openmatics.cardmaker.main.Constants;
import com.openmatics.cardmaker.settings.JsonManager;
import com.openmatics.cardmaker.notifications.Notificator;
import com.openmatics.cardmaker.employ.Employee;

import com.google.gson.GsonBuilder;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by PavelHabzansky on 25.01.17.
 */
public class MainController implements Initializable{
    private static Logger logger = LogManager.getLogger(MainController.class.getName());

    private final JsonManager jSonManager = new JsonManager(new GsonBuilder().setPrettyPrinting().create());

    private final File output = new File(Constants.DATA_OUTPUT);

    @FXML
    private TextField nameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField positionField;
    @FXML
    private VBox cardBox;

    @FXML
    public void initialize(URL url, ResourceBundle rb){
        logger.debug("Main Controller initialized");

        FXMLLoader czLoader = new FXMLLoader(MainController.class.getResource(Constants.CARD_LAYOUT));
        FXMLLoader enLoader = new FXMLLoader(MainController.class.getResource(Constants.CARD_LAYOUT));

        czLoader.setResources(ResourceBundle.getBundle(Constants.CZ_LANG_PROPERTIES));
        enLoader.setResources(ResourceBundle.getBundle(Constants.EN_LANG_PROPERTIES));

        //TODO nejsem si jistý, jestli je to takhle hezčí než předtím, ale aspoň není šance, že by Pane czCard a enCard byly null
        try{
            Pane enCard = enLoader.load();
            Pane czCard = czLoader.load();
            cardBox.getChildren().addAll(czCard,enCard);

            CardController czCardControl = czLoader.getController();
            CardController enCardControl = enLoader.getController();

            czCardControl.getNameLabelProperty().bind(nameField.textProperty());
            czCardControl.getPositionLabelProperty().bind(positionField.textProperty());
            czCardControl.getAddressLabelProperty().bind(addressField.textProperty());

            enCardControl.getNameLabelProperty().bind(nameField.textProperty());
            enCardControl.getPositionLabelProperty().bind(positionField.textProperty());
            enCardControl.getAddressLabelProperty().bind(addressField.textProperty());

        }catch (IOException e){
            logger.error(e.getMessage());
            Platform.exit();
            logger.debug("Exiting application... ");
        }
    }

    @FXML
    public void handleSaveButtonAction(ActionEvent event){
        if (nameField.getText().trim().isEmpty() ||
                positionField.getText().trim().isEmpty() ||
                addressField.getText().trim().isEmpty()){
            Notificator.errorNotification("One or more fields are empty");
        }
        else{
            Employee employee = new Employee(nameField.getText(),positionField.getText(),addressField.getText());
            if (output.exists()){
                jSonManager.writeToJson(employee,Constants.DATA_OUTPUT);
                logger.debug("Employee added, data saved successfully");
            }else {
                try{
                    logger.debug("Output file doesnt exist, creating new output file... ");
                    output.createNewFile();
                    jSonManager.writeToJson(employee,Constants.DATA_OUTPUT);
                    logger.debug("Employee added, data saved successfully");
                }catch (IOException e){
                    logger.error(e.getMessage());
                }
            }
        }
    }
}