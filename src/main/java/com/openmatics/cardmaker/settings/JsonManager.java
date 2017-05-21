package com.openmatics.cardmaker.settings;

import com.google.gson.Gson;
import com.openmatics.cardmaker.main.Constants;
import com.openmatics.cardmaker.notifications.Notificator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class JsonManager {
    //TODO improve exception handling

    private static Logger logger = LogManager.getLogger(JsonManager.class.getName());
    private final Gson gson;

    public JsonManager(Gson gson){
        this.gson=gson;
    }

    public void writeToJson(Object object, String destination){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))){
            String objectData = gson.toJson(object);
            writer.write(objectData);
            Notificator.successNotification(Constants.ADD_EMPLOYEE_SUCCESS);
        }catch (IOException e){
            logger.error(e.getMessage());
            Notificator.errorNotification(Constants.ADD_EMPLOYEE_FAIL);
        }
    }
}
