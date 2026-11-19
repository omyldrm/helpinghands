package be.kdg.pro3.helpinghands.presentation.controller;

import be.kdg.pro3.helpinghands.presentation.web.UserSessionHistory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/history")
public class HistoryController {

    private final UserSessionHistory sessionHistory;

    public HistoryController(UserSessionHistory sessionHistory) {
        this.sessionHistory = sessionHistory;
    }

    @GetMapping
    public String showHistory(Model model) {
        // Record visit to history page itself
        sessionHistory.addVisit("Session History");
        model.addAttribute("visits", sessionHistory.getVisits());
        return "session-history";
    }
}