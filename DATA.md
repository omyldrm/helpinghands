# Helping hand dataset
## Entities

Organization :  
name            (String)  
foundedDate     (LocalDate)  
averageRating   (double)  
isVerified      (boolean)  
logoUrl         (String – image url)

Event :  
title           (String)  
eventDate       (LocalDate)  
maxVolunteers   (int)  
category        EventCategory (enum)  
status          Status (enum)  
bannerUrl       (String – image url)

Volunteer :  
firstName       (String)  
lastName        (String)  
email           (String)  
birthDate       (LocalDate)  
isStudent       (boolean)  
avatarUrl       (String – image url)

## Relations

Organization 1 ──── N Event
- An organization organizes zero or more events.
- Each event is organized by exactly one organization.
- Implementation: Organization has `List<Event> events`, Event has `Organization organization`.

Event N ──── M Volunteer
- An event can have zero or more volunteers (up to maxVolunteers).
- A volunteer can sign up for zero or more events.
- Implementation: Event has `List<Volunteer> volunteers`, Volunteer has `List<Event> events`.

## Some examples

Red Cross Antwerp organizes the "Beach Cleanup Ostend" event (CLEANUP, PLANNED).

Jan Peeters signs up for "Beach Cleanup Ostend" as a DRIVER, logging 5 hours.

"Charity Concert De Roma" (CONCERT, COMPLETED) has 12 volunteers signed up.

Volunteer Sara Nowak is registered but has signed up for 0 events yet.
Food Bank Ghent runs 0 events so far.