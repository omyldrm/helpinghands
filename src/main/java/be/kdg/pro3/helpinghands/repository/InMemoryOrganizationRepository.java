package be.kdg.pro3.helpinghands.repository;

import be.kdg.pro3.helpinghands.domain.Organization;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InMemoryOrganizationRepository implements OrganizationRepository {
    private static final List<Organization> organizations = new ArrayList<>();

    static {
        organizations.add(new Organization("Live Nation", LocalDate.of(2010, 1, 25), 3.9, true, "https://cdn.prod.website-files.com/69fcec01601a440674da336f/6a060e72c4e409d4794af40e_LN_Logo_Primary_Red-Black_web.webp", 1L);
        organizations.add(new Organization("Cirque du Soleil", LocalDate.of(1984, 1, 25), 4, true, "https://upload.wikimedia.org/wikipedia/fr/1/1c/Logo_Cirque_du_Soleil.svg?utm_source=fr.wikipedia.org&utm_campaign=index&utm_content=original", 2L);
        organizations.add(new Organization("UNICEF", LocalDate.of(1946, 1, 25), 4.5, true, "https://thumb.wikimedia.org/wikipedia/commons/thumb/3/36/Logo_of_UNICEF_%28cropped%29.svg/3840px-Logo_of_UNICEF_%28cropped%29.svg.png?utm_source=commons.wikimedia.org&utm_campaign=index&utm_content=thumbnail", 3L);
        organizations.add(new Organization("Feeding America", LocalDate.of(1979, 1, 1), 2.3, true, "https://i0.wp.com/www.fsproduce.com/wp-content/uploads/2015/05/Feeding_America_logo.svg.png?ssl=1", 4L);
        organizations.add(new Organization("World Wildlife Fund", LocalDate.of(1961, 4, 29), 5, true, "https://thumb.wikimedia.org/wikipedia/de/thumb/0/06/WWF_Logo.svg/1920px-WWF_Logo.svg.png?utm_source=de.wikipedia.org&utm_campaign=index&utm_content=thumbnail", 5L);
        organizations.add(new Organization("KDG", LocalDate.of(1999, 9, 9), 1.2, false, "https://upload.wikimedia.org/wikipedia/commons/5/5b/Logo_Karel_de_Grote_Hogeschool.png?utm_source=commons.wikimedia.org&utm_campaign=index&utm_content=original", 6L);
    }
}
