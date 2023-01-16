package ru.lerup.gameonspring;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import ru.lerup.gameonspring.events.Event;
;import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


@Service
public class LoggerService implements ApplicationListener<Event> {
    private final Logger logger;
    Properties properties = new Properties();
    public LoggerService(Logger logger) {
        this.logger = logger;
    }


    @Override
    public void onApplicationEvent(Event event) {
        if (event.toString().indexOf("Create")>0)
            logger.log("Выберите язык Ru или Us");
        else if (event.toString().indexOf("Ru")>0){
            try {
                properties.loadFromXML(new FileInputStream("src/main/resources/text_ru_Ru.xml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (event.toString().indexOf("Us")>0){
            try {
                properties.load(new FileInputStream("src/main/resources/text_en_Us.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }






        if (event.toString().indexOf("Less") > 0)
            logger.log(properties.getProperty("msgLess"));
        else if (event.toString().indexOf("Equal") > 0)
            logger.log(properties.getProperty("msgEqually"));
        else if (event.toString().indexOf("More")>0)
            logger.log(properties.getProperty("msgMore"));
        else if (event.toString().indexOf("Start")>0)
            logger.log(properties.getProperty("msgStart"));
        else if (event.toString().indexOf("New")>0)
            logger.log(properties.getProperty("msgNew"));


    }

}

