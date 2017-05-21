package com.openmatics.cardmaker.fxmlhandling;

import com.openmatics.cardmaker.main.Constants;
import com.openmatics.cardmaker.notifications.Notificator;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ResourceBundle;

//TODO class is unsused right now

public class LoadingUtil {
    private static Logger logger = LogManager.getLogger(LoadingUtil.class);
    private static FXMLLoader loader;

    private LoadingUtil(){}

    public static LoadingUtilProperties loadLayout(String fxmlLayout, String resourceBundle){
        Parent root = null;
        try{
            loader = new FXMLLoader(LoadingUtil.class.getResource(fxmlLayout));
            loader.setResources(ResourceBundle.getBundle(resourceBundle));
            root = loader.load();
        }catch (IOException e){
            Notificator.errorNotification(Constants.LOAD_ERROR);
            logger.error(e.getMessage());
        }finally {
            //TODO nope
            return new LoadingUtilProperties(loader.getController(),root);
        }
    }
}