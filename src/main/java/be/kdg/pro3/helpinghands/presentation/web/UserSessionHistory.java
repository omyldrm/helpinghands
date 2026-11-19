package be.kdg.pro3.helpinghands.presentation.web;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@SessionScope
public class UserSessionHistory {

    public record PageVisit(String pageName, String timestamp){
        // here will be the records of the visit
    }

    private final List<PageVisit> visits = new ArrayList<>();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void addVisit(String pageName){
        String now = LocalDateTime.now().format(FORMATTER);
        visits.add(new PageVisit(pageName, now));
    }

    public List<PageVisit> getVisits(){
        return Collections.unmodifiableList(visits);
    }
}
