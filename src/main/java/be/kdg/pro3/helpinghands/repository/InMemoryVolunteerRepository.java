package be.kdg.pro3.helpinghands.repository;

import be.kdg.pro3.helpinghands.domain.Volunteer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InMemoryVolunteerRepository implements VolunteerRepository{
    private static final List<Volunteer> volunteers = new ArrayList<>();

    static {
        volunteers.add(new Volunteer("Omer", "Yildirim", "omer.yildirim@student.kdg.be", LocalDate.of(2005, 6, 24), true, "randomurl1", 1));
        volunteers.add(new Volunteer("Naz", "Aksinir", "naz.aksinir@student.kdg.be", LocalDate.of(2007, 11, 23), true, "randomurl2", 2));
        volunteers.add(new Volunteer("Yigit", "Yildirim", "yigit.yildirim@gmail.com", LocalDate.of(2009, 1, 24), true, "randomurl3", 3));
        volunteers.add(new Volunteer("John", "Doe", "johndoe@gmail.com", LocalDate.of(1967, 2, 14), false, "randomurl4", 4 ));
        volunteers.add(new Volunteer("Jane", "Doe", "janedoe@gmail.com", LocalDate.of(1969, 6, 4), false, "randomurl5", 5));
        volunteers.add(new Volunteer("Victor", "Osimhen", "victorosimhen@gmail.com", LocalDate.of(1997, 4, 22), false, "randomurl6", 6));
    }
}
