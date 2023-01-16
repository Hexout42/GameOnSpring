package ru.lerup.gameonspring;

import org.springframework.stereotype.Component;

@Component
public class Logger {
    public void log (Object o){
        System.out.println(o);
    }
}
