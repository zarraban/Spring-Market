package org.example.app.utils;

import org.example.app.controller.AppController;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AppStarter {
    static AppController controller;

    public AppStarter(@Qualifier("appController") AppController controller){
        AppStarter.controller = controller;
    }

    public  void run(){
        controller.initRepo();
        controller.run();
    }
}
