package com.foxminded;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDateTime;

import com.foxminded.services.parsers.AbbreviationDataParseService;
import com.foxminded.services.parsers.EndDataParseService;
import com.foxminded.services.parsers.StartDataParseService;

public class Main {
    public static void main(String[] args) {
        LocalDateTime l1 = LocalDateTime.parse("2018-05-24T12:14:12.054");
        LocalDateTime l2 = LocalDateTime.parse("2018-05-24T12:15:24.067");
        Duration duration = Duration.between(l1, l2);
             
        System.out.print(duration.toMinutes() +":"+ duration.toSeconds() % 60 +"."+ duration.toMillis() % 60000 * 0.001);
        
        AbbreviationDataParseService abbreviationParseService = new AbbreviationDataParseService("src/main/resources/abbreviations.txt");
        try {
            System.out.println(abbreviationParseService.parse());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        EndDataParseService endDataParseService = new EndDataParseService("src/main/resources/end.log");
        try {
            System.out.println(endDataParseService.parse());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        StartDataParseService service = new StartDataParseService("src/main/resources/start.log");
        try {
            System.out.println(service.parse());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
