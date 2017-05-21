package com.openmatics.cardmaker.notifications;

import javafx.scene.control.Alert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Notificator {
    private static Logger logger = LogManager.getLogger(Notificator.class.getName());

    private Notificator(){}

    public static void errorNotification(String errorMessage){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(errorMessage);
        alert.showAndWait();
        logger.error(errorMessage);
    }

    public static void successNotification(String successMessage){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText(successMessage);
        alert.showAndWait();
        logger.debug(successMessage);
    }
}
