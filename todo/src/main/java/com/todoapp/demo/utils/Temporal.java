package com.todoapp.demo.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Temporal {

    public static Instant curretDate(){
        LocalDateTime dateTime = LocalDateTime.now();
        Instant instant = dateTime.atZone(ZoneId.of("Europe/Paris")).toInstant();
        return instant;
    }
}
