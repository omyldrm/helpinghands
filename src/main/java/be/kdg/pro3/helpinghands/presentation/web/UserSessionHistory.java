package be.kdg.pro3.helpinghands.presentation.web;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UserSessionHistory {

    public record PageVisit(String pageName, String Timestamp){
        // here will be the records of tge visti
    }

}
