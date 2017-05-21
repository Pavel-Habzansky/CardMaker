package com.openmatics.cardmaker.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ResourceBundle;

public class Main extends Application {
    //TODO improve log4j configuration
    //TODO log4j sometimes throws NullPointerException sayin RollingFile couldn't be initialized
    //TODO package fxmlhandling and its classes are now without any use in the project
    //TODO due to change in log4j2 configuration logger now logs only into file, no console logging

    // TRACE < DEBUG < INFO < WARN < ERROR < FATAL
    private static Logger logger = LogManager.getLogger(Main.class);

    @Override
    public void start(Stage primaryStage) throws Exception{
        logger.debug("Application startup...");

        FXMLLoader loader = new FXMLLoader(getClass().getResource(Constants.MAIN_LAYOUT));
        loader.setResources(ResourceBundle.getBundle(Constants.MAIN_PROPERTIES));
        Parent root = loader.load();

        Scene scene = new Scene(root,650,450);
        primaryStage.setScene(scene);
        primaryStage.setTitle(ResourceBundle.getBundle(Constants.MAIN_PROPERTIES).getString("main.title"));
        primaryStage.show();

        primaryStage.setOnCloseRequest( e -> {
            logger.debug("Exiting application... ");
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
