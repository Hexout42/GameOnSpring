package ru.lerup.gameonspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.lerup.gameonspring.events.Event;

import java.util.Scanner;

@SpringBootApplication
public class GameOnSpringApplication {


    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(GameOnSpringApplication.class, args);

        Scanner scanner = new Scanner(System.in);
        int x;
        int y = (int)(Math.random()*1000);
        context.publishEvent(Event.of("Create"));
        context.publishEvent(Event.of(scanner.nextLine()));
        context.publishEvent(Event.of("New"));
        do{
            context.publishEvent(Event.of("Start"));
            x = scanner.nextInt();
            if (x== y)
                context.publishEvent(Event.of("Equal"));
            else if (x>y)
                context.publishEvent(Event.of("Less"));
            else if (x< y)
                context.publishEvent(Event.of("More"));
        }
        while (x!= y);
        scanner.close();
    }



    }


