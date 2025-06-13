package org.example.app;

import org.example.app.config.AppConfig;
import org.example.app.utils.AppStarter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AppStarter starter = context.getBean(AppStarter.class);
        starter.run();
    }
}
